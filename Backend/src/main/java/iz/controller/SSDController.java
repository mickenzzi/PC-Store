package iz.controller;

import iz.model.SSD;
import iz.service.SSDService;

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
@RequestMapping("/api/ssd")
public class SSDController {

    @Autowired
    private SSDService ssdService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<SSD> getAll() {
        return ssdService.getAll();
    }

    @GetMapping(value = "{title}", produces = MediaType.APPLICATION_JSON_VALUE)
    public SSD getOne(@PathVariable("title") String title) {
        return ssdService.getOne(title);
    }
}
