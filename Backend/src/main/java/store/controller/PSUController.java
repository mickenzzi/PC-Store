package store.controller;

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

import store.service.PSUService;
import store.dto.PSUCompatibleDTO;
import store.model.PSU;

@CrossOrigin
@RestController
@RequestMapping("/api/PSU")
public class PSUController {
    @Autowired
    private PSUService psuService;
    
    @GetMapping(value = "{title}", produces = MediaType.APPLICATION_JSON_VALUE)
    public PSU getOne(@PathVariable("title") String title){
        return psuService.getOne(title);
    }
    
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PSU> getAll(){
        return psuService.getAll();
    }
    
    @PostMapping(value="compatible",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PSU> getCompatibleGPU(@RequestBody PSUCompatibleDTO dto){
        return psuService.getCompatiblePSU(dto.getGpuTitle());
    }
}
