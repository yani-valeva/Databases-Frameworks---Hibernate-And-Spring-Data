package entities.vehicles.motorVehicle;

import entities.vehicles.Vehicle;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "motor_vehicles")
@PrimaryKeyJoinColumn(name = "vehicle_id")
public abstract class MotorVehicle extends Vehicle{
    private Integer numberOfEngines;
    private String engineType;
    private Double tankCapacity;

    protected MotorVehicle() {
    }

    @Column(name = "engine_numbers")
    public Integer getNumberOfEngines() {
        return numberOfEngines;
    }

    public void setNumberOfEngines(Integer numberOfEngines) {
        this.numberOfEngines = numberOfEngines;
    }

    @Column(name = "engine_type")
    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    @Column(name = "tank_capacity")
    public Double getTankCapacity() {
        return tankCapacity;
    }

    public void setTankCapacity(Double tankCapacity) {
        this.tankCapacity = tankCapacity;
    }
}
