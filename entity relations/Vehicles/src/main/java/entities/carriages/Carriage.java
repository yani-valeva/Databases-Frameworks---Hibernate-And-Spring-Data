package entities.carriages;

import entities.vehicles.motorVehicle.Train;

import javax.persistence.*;

@Entity
@Table(name = "carriages")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Carriage {
    private Long id;
    private Integer seatsCapacity;
    private Train train;

    protected Carriage() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "seats_capacity")
    public Integer getSeatsCapacity() {
        return seatsCapacity;
    }

    public void setSeatsCapacity(Integer seatsCapacity) {
        this.seatsCapacity = seatsCapacity;
    }

    @ManyToOne
    @JoinColumn(name = "train_id", referencedColumnName = "vehicle_id")
    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }
}
