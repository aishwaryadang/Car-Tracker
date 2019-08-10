package dang.aishwarya.service;

import dang.aishwarya.entity.Alerts;
import dang.aishwarya.repository.AlertsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class AlertsServiceImpl implements AlertsService {

    @Autowired
    AlertsRepository alertsRepository;

    @Override
    public List<Alerts> findHighAlerts() {
        return alertsRepository.findHighAlerts();
    }

    @Override
    public List<Alerts> findHighSorted() throws ParseException {
        List<Alerts> initialList = alertsRepository.findHighSorted();
        List<Alerts> finalList = new ArrayList<>();
        for(Alerts alert:initialList) {

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
            Date dt = sdf.parse(alert.getTimestamp());
            long epoch = dt.getTime();
            //System.out.println(epoch);

            long now = Instant.now().toEpochMilli() + 14400000;             // Needed to adjust this otherwise Instant.now() gives current system time.
            //System.out.println(now);
            System.out.println(now-epoch);
            if(now - epoch< 7200000)
                finalList.add(alert);

        }

        return finalList;
    }

    @Override
    public List<Alerts> findVehicleAlerts(String vehicleID) {
        return alertsRepository.findVehicleAlerts(vehicleID);
    }
}
