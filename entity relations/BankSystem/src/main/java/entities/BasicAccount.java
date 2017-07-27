package entities;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "accounts")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class BasicAccount{
    private Long id;
    private String accountNumber;
    private BigDecimal balance;

    protected BasicAccount() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "account_number")
    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Basic
    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public void depositMoney(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Amount couldn't be negative!");
        }

        this.balance = this.balance.add(amount);
    }

    public void withdrawMoney(BigDecimal amount) {
        if (amount.compareTo(this.balance) == 1) {
            throw new IllegalStateException("Insufficient balance!");
        }

        this.balance = this.balance.subtract(amount);
    }
}
