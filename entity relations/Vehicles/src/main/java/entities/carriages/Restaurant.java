package entities.carriages;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "restaurants")
@PrimaryKeyJoinColumn(name = "carriage_id")
public class Restaurant extends Carriage {
    private Integer tablesCount;

    public Restaurant() {
    }

    @Column(name = "tables_count")
    public Integer getTablesCount() {
        return tablesCount;
    }

    public void setTablesCount(Integer tablesCount) {
        this.tablesCount = tablesCount;
    }
}
