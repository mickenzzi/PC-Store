package store.controller;

import store.dto.GPUCompatibleDTO;
import store.model.GPU;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import store.service.GPUService;

@CrossOrigin
@RestController
@RequestMapping("/api/GPU")
public class GPUController {

    @Autowired
    private GPUService gpuService;
    
    @GetMapping(value = "{title}", produces = MediaType.APPLICATION_JSON_VALUE)
    public GPU getOne(@PathVariable("title") String title){
        return gpuService.getOne(title);
    }
    
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<GPU> getAll(){
        return gpuService.getAll();
    }
    
    @PostMapping(value="compatible",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<GPU> getCompatibleGPU(@RequestBody GPUCompatibleDTO dto){
        return gpuService.getCompatibleGPU(dto.getPsuTitle());
    }

}
