package entities;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "checking_accounts")
@PrimaryKeyJoinColumn(name = "id")
public class CheckingAccount extends BasicAccount{
    private BigDecimal fee;

    public CheckingAccount() {
    }

    @Basic
    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    public void deductFee() {
        super.setBalance(super.getBalance().subtract(super.getBalance().multiply(this.fee.divide(new BigDecimal(100)))));
    }
}
