package dang.aishwarya.service;

import dang.aishwarya.entity.Alerts;

import java.text.ParseException;
import java.util.List;

public interface AlertsService {

    public List<Alerts> findHighAlerts();

    public List<Alerts> findHighSorted() throws ParseException;

    public List<Alerts> findVehicleAlerts(String vehicleID);
}
