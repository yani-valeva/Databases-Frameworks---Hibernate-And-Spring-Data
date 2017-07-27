package entities.vehicles.nonMotorVehicle;

import entities.vehicles.Vehicle;

import javax.persistence.*;

@Entity
@Table(name = "non_motor_vehicles")
@PrimaryKeyJoinColumn(name = "vehicle_id")
public abstract class NonMotorVehicle extends Vehicle{

    protected NonMotorVehicle() {
    }
}
