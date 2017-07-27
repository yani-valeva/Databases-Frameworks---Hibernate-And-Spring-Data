package entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "occupancies")
public class Occupancy {
    private Long id;
    private Date dateOccupied;
    private Customer customer;
    private Room room;
    private BigDecimal rateApplied;
    private BigDecimal phoneCharge;
    private String notes;

    public Occupancy() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "date_occupied")
    public Date getDateOccupied() {
        return dateOccupied;
    }

    public void setDateOccupied(Date dateOccupied) {
        this.dateOccupied = dateOccupied;
    }

    @ManyToOne
    @JoinColumn(name = "account_number", referencedColumnName = "account_number")
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @ManyToOne
    @JoinColumn(name = "room_number", referencedColumnName = "room_number")
    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    @Column(name = "rate_applied")
    public BigDecimal getRateApplied() {
        return rateApplied;
    }

    public void setRateApplied(BigDecimal rateApplied) {
        this.rateApplied = rateApplied;
    }

    @Column(name = "phone_charge")
    public BigDecimal getPhoneCharge() {
        return phoneCharge;
    }

    public void setPhoneCharge(BigDecimal phoneCharge) {
        this.phoneCharge = phoneCharge;
    }

    @Basic
    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
