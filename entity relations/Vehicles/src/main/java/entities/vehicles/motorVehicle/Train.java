package entities.vehicles.motorVehicle;

import entities.carriages.Carriage;
import entities.vehicles.Locomotive;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "trains")
@PrimaryKeyJoinColumn(name = "vehicle_id")
public class Train extends MotorVehicle {
    private Locomotive locomotive;
    private Integer numberOfCarriages;
    private List<Carriage> carriages;

    public Train() {
    }

    @OneToOne
    @JoinColumn(name = "locomotive_id", referencedColumnName = "id")
    public Locomotive getLocomotive() {
        return locomotive;
    }

    public void setLocomotive(Locomotive locomotive) {
        this.locomotive = locomotive;
    }

    @Column(name = "carriages_number")
    public Integer getNumberOfCarriages() {
        return numberOfCarriages;
    }

    public void setNumberOfCarriages(Integer numberOfCarriages) {
        this.numberOfCarriages = numberOfCarriages;
    }

    @OneToMany(mappedBy = "train")
    public List<Carriage> getCarriages() {
        return carriages;
    }

    public void setCarriages(List<Carriage> carriages) {
        this.carriages = carriages;
    }
}
