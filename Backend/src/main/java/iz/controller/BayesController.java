package iz.controller;

import iz.model.enums.Cause;
import iz.model.enums.Malfunction;
import iz.model.enums.Symptom;
import iz.dto.*;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import unbbayes.io.BaseIO;
import unbbayes.io.NetIO;
import unbbayes.prs.bn.JunctionTreeAlgorithm;
import unbbayes.prs.bn.ProbabilisticNetwork;
import unbbayes.prs.bn.ProbabilisticNode;
import unbbayes.util.extension.bn.inference.IInferenceAlgorithm;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@CrossOrigin
@RestController
@RequestMapping("/api/bayes")
public class BayesController {
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public BayesResultDTO Bayes(@RequestBody BayesDTO dto){
        ProbabilisticNetwork net;
        BaseIO io = new NetIO();
        try {
            net = (ProbabilisticNetwork)io.load(new File("data/malfunctions.net"));
        } catch (IOException e) {
            throw new RuntimeException("No such file");
        }
        IInferenceAlgorithm algorithm = new JunctionTreeAlgorithm();

        algorithm.setNetwork(net);
        algorithm.run();

        for (String symptom : dto.getComputerSymptomsList()){
            ((ProbabilisticNode)net.getNode(Symptom.getNodeName(Symptom.valueOf(symptom)))).addFinding(0);
        }

        for (String cause : dto.getMalfunctionCausesList()) {
            ((ProbabilisticNode)net.getNode(Cause.getNodeName(Cause.valueOf(cause)))).addFinding(0);
        }

        for (Cause cause : Cause.values()){
            boolean found = false;
            for(String inDto : dto.getMalfunctionCausesList()){
                if (cause == Cause.valueOf(inDto)){
                    found = true;
                    break;
                }
            }
            if(found) continue;
            ((ProbabilisticNode)net.getNode(Cause.getNodeName(cause))).addFinding(1);
        }

        try {
            net.updateEvidences();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        Malfunction[] allMalfunctions = Malfunction.values();
        BayesResultDTO malfunctions = new BayesResultDTO();
        for(Malfunction malfunction : allMalfunctions){
            ProbabilisticNode node = (ProbabilisticNode) net.getNode(Malfunction.getNodeName(malfunction));
            if (node.getMarginalAt(0) > 0)
                malfunctions.getResults().
                        add(new BayesResponseDTO(Malfunction.toString(malfunction), node.getMarginalAt(0)));
        }
        malfunctions.getResults().sort(Comparator.comparing(BayesResponseDTO::getProbability).reversed());

        float percentSum = 0;
        for (int i = 0; i < malfunctions.getResults().size(); i++) {
            BayesResponseDTO bayes = malfunctions.getResults().get(i);
            percentSum+=bayes.getProbability();
        }

        for (int i = 0; i < malfunctions.getResults().size(); i++) {
            malfunctions.getResults().get(i).setProbability(malfunctions.getResults().get(i).getProbability()/percentSum*100);
        }

        //Odkomentarisati (radi zaokruzivanja na do 100, inace je 0.nesto
        /*for (int i = 0; i < malfunctions.getResults().size(); i++) {
            malfunctions.getResults().get(i).setProbability(malfunctions.getResults().get(i).getProbability()*100);
        }*/

        return malfunctions;
    }

    @GetMapping(value = "symptoms",produces = MediaType.APPLICATION_JSON_VALUE)
    public SymptomsDTO GetSymptoms(){
        SymptomsDTO symptomsDTO = new SymptomsDTO();
        symptomsDTO.setSymptomsList(Stream.of(Symptom.values())
                .map(Enum::name)
                .collect(Collectors.toList()));
        return symptomsDTO;
    }

    @GetMapping(value = "causes",produces = MediaType.APPLICATION_JSON_VALUE)
    public CausesDTO GetCauses(){
        CausesDTO causesDTO = new CausesDTO();
        causesDTO.setCausesList(Stream.of(Cause.values())
                .map(Enum::name)
                .collect(Collectors.toList()));
        return causesDTO;
    }
}