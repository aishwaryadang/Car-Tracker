package dang.aishwarya.repository;

import dang.aishwarya.entity.Vehicle;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Repository
public class VehicleRepositoryImpl implements VehicleRepository{

    @PersistenceContext
    private EntityManager em;

    @Override
    public Vehicle create(Vehicle vehicle) {
        Vehicle vehicleToSearch = em.find(Vehicle.class, vehicle.getVin());

        if(vehicleToSearch != null) {
            em.merge(vehicle);
        }
        else {
            em.persist(vehicle);
        }
        return vehicle;
    }

    @Override
    public List<Vehicle> findAll() {
        TypedQuery typedQuery = em.createNamedQuery("Vehicle.findAll", Vehicle.class);
        List<Vehicle> resultList = typedQuery.getResultList();

        return resultList;
    }
}
