package store.controller;

import store.dto.CPUCompatibleDTO;
import store.model.CPU;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import store.service.CPUService;

@CrossOrigin
@RestController
@RequestMapping("/api/CPU")
public class CPUController {

    @Autowired
    private CPUService cpuService;
    
    @GetMapping(value = "{title}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CPU getOne(@PathVariable("title") String title){
        return cpuService.getOne(title);
    }
    
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CPU> getAll(){
        return cpuService.getAll();
    }
    
    @PostMapping(value = "compatible", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CPU> getCompatibleCPU(@RequestBody CPUCompatibleDTO dto){
        return cpuService.getCompatibleCPUS(dto.getMoboTitle());
    }
    
    
}
