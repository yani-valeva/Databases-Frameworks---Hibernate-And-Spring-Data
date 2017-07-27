package entities.vehicles.motorVehicle;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "cars")
@PrimaryKeyJoinColumn(name = "vehicle_id")
public class Car extends MotorVehicle {
    private Integer doorNumbers;
    private Boolean hasInsurance;

    public Car() {
    }

    @Column(name = "door_numbers")
    public Integer getDoorNumbers() {
        return doorNumbers;
    }

    public void setDoorNumbers(Integer doorNumbers) {
        this.doorNumbers = doorNumbers;
    }

    @Column(name = "has_insurance")
    public Boolean getHasInsurance() {
        return hasInsurance;
    }

    public void setHasInsurance(Boolean hasInsurance) {
        this.hasInsurance = hasInsurance;
    }
}
