package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "saving_accounts")
@PrimaryKeyJoinColumn(name = "id")
public class SavingAccount extends BasicAccount {
    private BigDecimal interestRate;

    public SavingAccount() {
    }

    @Column(name = "interest_rate")
    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }

    public void addInterest() {
        super.setBalance(super.getBalance().add(super.getBalance().multiply(this.interestRate.divide(new BigDecimal(100)))));
    }
}
