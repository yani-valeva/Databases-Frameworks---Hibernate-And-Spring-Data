package entities.carriages;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "passengers")
@PrimaryKeyJoinColumn(name = "carriage_id")
public class Passenger extends Carriage{
    private Integer standingPassengersCapacity;

    public Passenger() {
    }

    @Column(name = "standing_passengers_capacity")
    public Integer getStandingPassengersCapacity() {
        return standingPassengersCapacity;
    }

    public void setStandingPassengersCapacity(Integer standingPassengersCapacity) {
        this.standingPassengersCapacity = standingPassengersCapacity;
    }
}
