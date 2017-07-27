package entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "rooms")
public class Room {
    private Long roomNumber;
    private RoomType roomType;
    private BedType bedType;
    private BigDecimal rate;
    private RoomStatus roomStatus;
    private String notes;
    private Set<Occupancy> roomOccupancies;

    public Room() {
    }

    @Id
    @Column(name = "room_number")
    public Long getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Long roomNumber) {
        this.roomNumber = roomNumber;
    }

    @ManyToOne
    @JoinColumn(name = "room_type_id", referencedColumnName = "id")
    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    @ManyToOne
    @JoinColumn(name = "bed_type_id", referencedColumnName = "id")
    public BedType getBedType() {
        return bedType;
    }

    public void setBedType(BedType bedType) {
        this.bedType = bedType;
    }

    @Basic
    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    @ManyToOne
    @JoinColumn(name = "room_status_id", referencedColumnName = "id")
    public RoomStatus getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(RoomStatus roomStatus) {
        this.roomStatus = roomStatus;
    }

    @Basic
    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @OneToMany(mappedBy = "room")
    public Set<Occupancy> getRoomOccupancies() {
        return roomOccupancies;
    }

    public void setRoomOccupancies(Set<Occupancy> roomOccupancies) {
        this.roomOccupancies = roomOccupancies;
    }
}
