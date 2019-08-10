package dang.aishwarya.entity;

import com.mysql.cj.protocol.ColumnDefinition;

import javax.persistence.*;

@Entity
@NamedQueries({
        @NamedQuery(name = "Vehicle.findAll", query = "SELECT veh FROM Vehicle veh")
})
public class Vehicle {

    @Id
    @Column( columnDefinition = "VARCHAR(36)" )
    private String vin;

    @Column( columnDefinition = "VARCHAR(20)" )
    private String make;

    @Column( columnDefinition = "VARCHAR(20)" )
    private String model;

    private int year;
    private int redlineRpm;
    private float maxFuelVolume;

    @Column( columnDefinition = "VARCHAR(40)" )
    private String lastServiceDate;


    //@JoinColumn(name = "read_vin", nullable = false)
    //@MapsId
    @OneToOne//(fetch = FetchType.LAZY)
    private Readings readings;

    //need to create default constructor so Jackson doesn't throw no default constructor error.
    public Vehicle() {

    }

    public Vehicle(String vin, String make, String model, int year, int redlineRpm, float maxFuelVolume, String lastServiceDate) {
        this.vin = vin;
        this.make = make;
        this.model = model;
        this.year = year;
        this.redlineRpm = redlineRpm;
        this.maxFuelVolume = maxFuelVolume;
        this.lastServiceDate = lastServiceDate;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getRedlineRpm() {
        return redlineRpm;
    }

    public void setRedlineRpm(int redlineRpm) {
        this.redlineRpm = redlineRpm;
    }

    public float getMaxFuelVolume() {
        return maxFuelVolume;
    }

    public void setMaxFuelVolume(int maxFuelVolume) {
        this.maxFuelVolume = maxFuelVolume;
    }

    public String getLastServiceDate() {
        return lastServiceDate;
    }

    public void setLastServiceDate(String lastServiceDate) {
        this.lastServiceDate = lastServiceDate;
    }

    public Readings getReadings() {
        return readings;
    }

    public void setReadings(Readings readings) {
        this.readings = readings;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vin='" + vin + '\'' +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", redlineRpm=" + redlineRpm +
                ", maxFuelVolume=" + maxFuelVolume +
                ", lastServiceDate='" + lastServiceDate + '\'' +
                ", readings=" + readings +
                '}';
    }
}
