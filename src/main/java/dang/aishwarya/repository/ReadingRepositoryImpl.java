package dang.aishwarya.repository;

import dang.aishwarya.entity.Readings;
import dang.aishwarya.entity.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class ReadingRepositoryImpl implements ReadingRepository{

    @PersistenceContext
    private EntityManager em;

    @Override
    public Readings updateReadings(Readings readings) {
        Vehicle readingsOfVehicle = em.find(Vehicle.class, readings.getVin());
        if(readingsOfVehicle != null){

            if (readings.getEngineRpm() > readingsOfVehicle.getRedlineRpm())
                System.out.println("engineRpm > redlineRpm, Priority: HIGH");

            if (readings.getFuelVolume() < (readingsOfVehicle.getMaxFuelVolume()/10))
                System.out.println("fuelVolume < 10% of maxFuelVolume, Priority: MEDIUM");
            if ( 32 > readings.getFrontLeft() || 32 > readings.getFrontRight() || 32 > readings.getRearLeft() || 32 > readings.getRearRight() )
                System.out.println("Tire Pressure Low, Priority: LOW");
            if ( 36 < readings.getFrontLeft() || 36 < readings.getFrontRight() || 36 < readings.getRearLeft() || 36 < readings.getRearRight() )
                System.out.println("Tire Pressure High, Priority: LOW");
            if ( readings.isEngineCoolantLow() )
                System.out.println("Engine Coolant is Low");
            if ( readings.isCheckEngineLightOn())
                System.out.println("Check Engine Light is On");


            if(em.find(Readings.class, readings.getVin()) != null)
                em.merge(readings);
            else
                em.persist(readings);
            readingsOfVehicle.setReadings(readings);
            em.merge(readingsOfVehicle);
        }
        return readings;
    }
}
