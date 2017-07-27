package entities.vehicles.nonMotorVehicle;

import javax.persistence.*;

@Entity
@Table(name = "bikes")
@PrimaryKeyJoinColumn(name = "vehicle_id")
public class Bike extends NonMotorVehicle {
    private Integer shiftsCount;
    private String color;

    public Bike() {
    }

    @Column(name = "shifts_count")
    public Integer getShiftsCount() {
        return shiftsCount;
    }

    public void setShiftsCount(Integer shiftsCount) {
        this.shiftsCount = shiftsCount;
    }

    @Basic
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}

