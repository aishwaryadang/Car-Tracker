package dang.aishwarya.repository;

import dang.aishwarya.entity.Alerts;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class AlertsRepositoryImpl implements AlertsRepository{

    @PersistenceContext
    private EntityManager em;

    @Override
    public void createAlert(Alerts alert) {
        em.persist(alert);
    }

    @Override
    public List<Alerts> findHighAlerts() {
        TypedQuery<Alerts> typedQuery = em.createNamedQuery("Alerts.findHigh", Alerts.class);

        List<Alerts> alertsList = typedQuery.getResultList();

        return alertsList;

    }

    @Override
    public List<Alerts> findHighSorted() {
        TypedQuery<Alerts> typedQuery = em.createNamedQuery("Alerts.findHighSorted", Alerts.class);

        List<Alerts> alertsList = typedQuery.getResultList();

        return alertsList;
    }

    @Override
    public List<Alerts> findVehicleAlerts(String vehicleID) {
        TypedQuery<Alerts> typedQuery = em.createNamedQuery("Alerts.findByVin", Alerts.class);
        typedQuery.setParameter("paramVin", vehicleID);
        List<Alerts> alertsList = typedQuery.getResultList();

        return alertsList;
    }
}
