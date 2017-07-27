package softuni.users.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "towns")
public class Town {
    private Long id;
    private String name;
    private String country;
    private Set<User> bornUsers;
    private Set<User> livingUsers;

    public Town() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @OneToMany(mappedBy = "bornTown")
    public Set<User> getBornUsers() {
        return bornUsers;
    }

    public void setBornUsers(Set<User> bornUsers) {
        this.bornUsers = bornUsers;
    }

    @OneToMany(mappedBy = "livingTown")
    public Set<User> getLivingUsers() {
        return livingUsers;
    }

    public void setLivingUsers(Set<User> livingUsers) {
        this.livingUsers = livingUsers;
    }
}
