package dang.aishwarya.service;

import dang.aishwarya.entity.Vehicle;
import dang.aishwarya.exception.VehicleNotCreatedException;
import dang.aishwarya.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    VehicleRepository vehicleRepository;

    @Override
    public List<Vehicle> findAll() {
        List<Vehicle> vehicleList = new ArrayList<>();
        /*vehicleList.add(new Vehicle("1HGCR2F3XFA027534", "HONDA", "ACCORD", 2015, 5500, 15, "2017-05-25T17:31:25.268Z"));
        vehicleList.add(new Vehicle("WP1AB29P63LA60179", "PORSCHE", "CAYENNE", 2015, 8000, 18, "2017-03-25T17:31:25.268Z"));*/
        return vehicleRepository.findAll();

    }

    @Override
    public void findOne(String vin) {

    }


    @Override
    @Transactional
    public Vehicle create(Vehicle vehicle) {
        Vehicle vehicle1 = vehicleRepository.create(vehicle);
        if (vehicle1 == null) {
            throw new VehicleNotCreatedException("Unable to create vehicle. Please check data.");
        }
        else {
            return vehicle1;
        }
    }
}
