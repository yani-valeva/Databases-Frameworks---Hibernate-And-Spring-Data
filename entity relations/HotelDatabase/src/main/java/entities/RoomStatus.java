package entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "room_status")
public class RoomStatus {
    private Long id;
    private String roomStatus;
    private String notes;
    private Set<Room> roomsByStatus;

    public RoomStatus() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "room_status")
    public String getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(String roomStatus) {
        this.roomStatus = roomStatus;
    }

    @Basic
    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @OneToMany(mappedBy = "roomStatus")
    public Set<Room> getRoomsByStatus() {
        return roomsByStatus;
    }

    public void setRoomsByStatus(Set<Room> roomsByStatus) {
        this.roomsByStatus = roomsByStatus;
    }
}
