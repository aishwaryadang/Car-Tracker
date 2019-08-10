package dang.aishwarya.controller;

import dang.aishwarya.entity.Vehicle;
import dang.aishwarya.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/vehicles")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @RequestMapping(method = RequestMethod.GET)
    //don't need for project
    public List<Vehicle> findall() {
        return vehicleService.findAll();
    }

    //Don't need for project
    @RequestMapping(method = RequestMethod.GET, value = "/{vin}")
    public Vehicle findOne(@PathVariable("vin") String vehicleID) {
        return null;
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.PUT)
    public void create(@RequestBody Vehicle[] vehicle) {
        for(Vehicle vehicleEach : vehicle)
        vehicleService.create(vehicleEach);
    }
}
