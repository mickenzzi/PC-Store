package iz.controller;

import iz.model.HDD;
import iz.service.HDDService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/api/hdd")
public class HDDController {

    @Autowired
    private HDDService hddService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<HDD> getAll() {
        return hddService.getAll();
    }

    @GetMapping(value = "{title}", produces = MediaType.APPLICATION_JSON_VALUE)
    public HDD getOne(@PathVariable("title") String title) {
        return hddService.getOne(title);
    }
}
