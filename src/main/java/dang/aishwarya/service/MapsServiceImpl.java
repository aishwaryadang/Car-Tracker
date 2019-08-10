package dang.aishwarya.service;

import dang.aishwarya.repository.MapsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MapsServiceImpl implements MapsService{

    @Autowired
    MapsRepository mapsRepository;

    @Override
    public void findVehicleLocation(String vehicleID) {

    mapsRepository.findVehicleLocation(vehicleID);

    }

}
