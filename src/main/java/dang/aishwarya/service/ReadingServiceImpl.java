package dang.aishwarya.service;

import dang.aishwarya.entity.Alerts;
import dang.aishwarya.entity.Readings;
import dang.aishwarya.entity.Vehicle;
import dang.aishwarya.repository.AlertsRepository;
import dang.aishwarya.repository.ReadingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class ReadingServiceImpl implements ReadingService {

    @Autowired
    ReadingRepository readingRepository;

    @Autowired
    AlertsRepository alertsRepository;

    @PersistenceContext
    EntityManager em;

    @Override
    @Transactional
    public Readings updateReadings(Readings readings) {
        Vehicle readingsOfVehicle = em.find(Vehicle.class, readings.getVin());
        if (readingsOfVehicle != null) {

            if (readings.getEngineRpm() > readingsOfVehicle.getRedlineRpm())
                alertsRepository.createAlert(new Alerts("engineRpm > redlineRpm", "HIGH", readingsOfVehicle, readings.getTimestamp()));
            if (readings.getFuelVolume() < (readingsOfVehicle.getMaxFuelVolume() / 10))
                alertsRepository.createAlert(new Alerts("fuelVolume < 10% of maxFuelVolume", "MEDIUM", readingsOfVehicle, readings.getTimestamp()));
            if (32 > readings.getFrontLeft() || 32 > readings.getFrontRight() || 32 > readings.getRearLeft() || 32 > readings.getRearRight())
                alertsRepository.createAlert(new Alerts("Tire Pressure Low", "LOW", readingsOfVehicle, readings.getTimestamp()));
            if (36 < readings.getFrontLeft() || 36 < readings.getFrontRight() || 36 < readings.getRearLeft() || 36 < readings.getRearRight())
                alertsRepository.createAlert(new Alerts("Tire Pressure High", "LOW", readingsOfVehicle, readings.getTimestamp()));
            if (readings.isEngineCoolantLow())
                alertsRepository.createAlert(new Alerts("Engine Coolant Low", "LOW", readingsOfVehicle, readings.getTimestamp()));
            if (readings.isCheckEngineLightOn())
                alertsRepository.createAlert(new Alerts("Check Engine Light is On", "LOW", readingsOfVehicle, readings.getTimestamp()));
        }

        return readingRepository.updateReadings(readings);
    }
}
