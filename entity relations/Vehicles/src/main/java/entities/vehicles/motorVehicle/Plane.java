package entities.vehicles.motorVehicle;

import javax.persistence.*;

@Entity
@Table(name = "planes")
@PrimaryKeyJoinColumn(name = "vehicle_id")
public class Plane extends MotorVehicle {
    private String airlineOwner;
    private String color;
    private Integer passengersCapacity;

    public Plane() {
    }

    @Column(name = "airline_owner")
    public String getAirlineOwner() {
        return airlineOwner;
    }

    public void setAirlineOwner(String airlineOwner) {
        this.airlineOwner = airlineOwner;
    }

    @Basic
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Column(name = "passengers_capacity")
    public Integer getPassengersCapacity() {
        return passengersCapacity;
    }

    public void setPassengersCapacity(Integer passengersCapacity) {
        this.passengersCapacity = passengersCapacity;
    }
}
