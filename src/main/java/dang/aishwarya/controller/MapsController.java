package dang.aishwarya.controller;

import dang.aishwarya.service.MapsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/location")
public class MapsController {

    @Autowired
    MapsService mapsService;

    @RequestMapping(method = RequestMethod.GET, value = "/{vin}")
    public void findVehicleLocation(@PathVariable("vin") String vehicleID) {
        mapsService.findVehicleLocation(vehicleID);
    }
}
