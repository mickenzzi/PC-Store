package store.controller;

import store.model.HDD;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import store.service.HDDService;

@CrossOrigin
@RestController
@RequestMapping("/api/HDD")
public class HDDController {

    @Autowired
    private HDDService hddService;
    
    @GetMapping(value = "{title}", produces = MediaType.APPLICATION_JSON_VALUE)
    public HDD getOne(@PathVariable("title") String title){
        return hddService.getOne(title);
    }
    
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<HDD> getAll(){
        return hddService.getAll();
    }
}
