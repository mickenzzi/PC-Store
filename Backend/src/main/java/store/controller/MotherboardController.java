package store.controller;

import store.dto.MotherboardCompatibleDTO;
import store.model.Motherboard;

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

import store.service.MotherboardService;

@CrossOrigin
@RestController
@RequestMapping("/api/Motherboard")
public class MotherboardController {

    @Autowired
    private MotherboardService motherboardService;
    
    @GetMapping(value = "{title}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Motherboard getOne(@PathVariable("title") String title){
        return motherboardService.getOne(title);
    }
    
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Motherboard> getAll(){
        return motherboardService.getAll();
    }
    
    @PostMapping(value = "compatible", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Motherboard> GetCompatibleMotherboards(@RequestBody MotherboardCompatibleDTO dto){
        return motherboardService.getCompatibleMotherBoards(dto);
    }
}
