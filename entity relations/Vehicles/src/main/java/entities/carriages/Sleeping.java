package entities.carriages;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "sleeping")
@PrimaryKeyJoinColumn(name = "carriage_id")
public class Sleeping extends Carriage {
    private Integer bedsCount;

    public Sleeping() {
    }

    @Column(name = "beds_count")
    public Integer getBedsCount() {
        return bedsCount;
    }

    public void setBedsCount(Integer bedsCount) {
        this.bedsCount = bedsCount;
    }
}
