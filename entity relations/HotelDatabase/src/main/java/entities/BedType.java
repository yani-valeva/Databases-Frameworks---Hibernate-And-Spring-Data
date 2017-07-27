package entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "bed_types")
public class BedType {
    private Long id;
    private String bedType;
    private String notes;
    private Set<Room> roomsByBedType;

    public BedType() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "bed_type")
    public String getBedType() {
        return bedType;
    }

    public void setBedType(String bedType) {
        this.bedType = bedType;
    }

    @Basic
    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @OneToMany(mappedBy = "bedType")
    public Set<Room> getRoomsByBedType() {
        return roomsByBedType;
    }

    public void setRoomsByBedType(Set<Room> roomsByBedType) {
        this.roomsByBedType = roomsByBedType;
    }
}
