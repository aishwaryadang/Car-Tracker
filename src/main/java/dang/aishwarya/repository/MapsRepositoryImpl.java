package dang.aishwarya.repository;

import dang.aishwarya.entity.Vehicle;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class MapsRepositoryImpl implements MapsRepository {

    @PersistenceContext
    EntityManager em;

    @Override
    public void findVehicleLocation(String vehicleID) {
        Vehicle vehicle = em.find(Vehicle.class, vehicleID);
        double latitude = vehicle.getReadings().getLatitude();
        double longitude = vehicle.getReadings().getLongitude();



    }
}
