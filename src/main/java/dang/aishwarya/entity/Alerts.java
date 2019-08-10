package dang.aishwarya.entity;

import javax.persistence.*;

@Entity
@NamedQueries({
        @NamedQuery(name = "Alerts.findHigh", query = "SELECT alerts FROM Alerts alerts WHERE alerts.priority = 'HIGH'"),
        @NamedQuery(name = "Alerts.findHighSorted", query = "SELECT alerts FROM Alerts alerts WHERE alerts.priority = 'HIGH' ORDER BY alerts.vehicle.vin DESC"),
        @NamedQuery(name = "Alerts.findByVin", query = "SELECT alerts FROM Alerts alerts WHERE alerts.vehicle.vin=:paramVin")
})
public class Alerts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column( columnDefinition = "VARCHAR(36)" )
    private String rule;

    @Column( columnDefinition = "VARCHAR(36)" )
    private String priority;

    @Column( columnDefinition = "VARCHAR(36)" )
    private String timestamp;

    @OneToOne
    private Vehicle vehicle;

    public Alerts() {
    }

    public Alerts(String rule, String priority, Vehicle vehicle, String timestamp) {
        this.rule = rule;
        this.priority = priority;
        this.vehicle = vehicle;
        this.timestamp = timestamp;
    }

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }


    @Override
    public String toString() {
        return "Alerts{" +
                "id=" + id +
                ", rule='" + rule + '\'' +
                ", priority='" + priority + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", vehicle=" + vehicle +
                '}';
    }
}
