package dang.aishwarya.service;

import dang.aishwarya.entity.Vehicle;

import java.util.List;

public interface VehicleService {

    List<Vehicle> findAll();
    void findOne(String vin);
    Vehicle create(Vehicle vehicle);
}
