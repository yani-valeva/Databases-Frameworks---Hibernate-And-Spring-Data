package entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "store_locations")
public class StoreLocation {
    private Long id;
    private String locationName;
    private Set<Sale> storeSales;

    public StoreLocation() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "location_name")
    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    @OneToMany(mappedBy = "storeLocation")
    public Set<Sale> getStoreSales() {
        return storeSales;
    }

    public void setStoreSales(Set<Sale> storeSales) {
        this.storeSales = storeSales;
    }
}
