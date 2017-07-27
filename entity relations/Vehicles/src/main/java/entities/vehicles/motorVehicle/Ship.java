package entities.vehicles.motorVehicle;

import javax.persistence.*;

@Entity
@Table(name = "ships")
@PrimaryKeyJoinColumn(name = "vehicle_id")
public class Ship extends MotorVehicle {
    private String nationality;
    private String captainName;
    private Integer shipCrewSize;

    public Ship() {
    }

    @Basic
    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    @Column(name = "captain_name")
    public String getCaptainName() {
        return captainName;
    }

    public void setCaptainName(String captainName) {
        this.captainName = captainName;
    }

    @Column(name = "ship_crew_size")
    public Integer getShipCrewSize() {
        return shipCrewSize;
    }

    public void setShipCrewSize(Integer shipCrewSize) {
        this.shipCrewSize = shipCrewSize;
    }
}
