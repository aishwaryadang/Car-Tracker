package dang.aishwarya.controller;

import dang.aishwarya.entity.Readings;
import dang.aishwarya.service.ReadingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/readings")
public class ReadingsController {

    @Autowired
    ReadingService readingService;

    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST)
    public void updateReadings(@RequestBody Readings readings) {

        System.out.println(readings);

        readingService.updateReadings(readings);
    }
}
