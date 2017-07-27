package entities.vehicles.motorVehicle;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "cruise_ships")
@PrimaryKeyJoinColumn(name = "vehicle_id")
public class CruiseShip extends Ship {
    private Integer passengersCapacity;

    public CruiseShip() {
    }

    @Column(name = "passengers_capacity")
    public Integer getPassengersCapacity() {
        return passengersCapacity;
    }

    public void setPassengersCapacity(Integer passengersCapacity) {
        this.passengersCapacity = passengersCapacity;
    }
}
