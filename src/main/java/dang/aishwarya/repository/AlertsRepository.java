package dang.aishwarya.repository;

import dang.aishwarya.entity.Alerts;

import java.util.List;

public interface AlertsRepository {

        public List<Alerts> findHighAlerts();
        public void createAlert(Alerts alert);
        public List<Alerts> findHighSorted();

        public List<Alerts> findVehicleAlerts(String vehicleID);
}
