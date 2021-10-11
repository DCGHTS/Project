package za.ac.nwu.project.domain.persistence;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "Transaction", schema = "DCS")
public class AccountTransation
{
    @Id
    @SequenceGenerator(name = "GENERIC_SEQ",sequenceName = "DCS.GENERIC_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GENERIC_SEQ")

    private Long transactionId;

    private AccountType accountType;

    private AccountPerson accountPerson;

    private Long amount;

    private LocalDate transactionDate;

    public AccountTransation(Long transactionId, AccountType accountType, AccountPerson accountPerson, Long amount, LocalDate transactionDate) {
        this.transactionId = transactionId;
        this.accountType = accountType;
        this.accountPerson = accountPerson;
        this.amount = amount;
        this.transactionDate = transactionDate;
    }

    public AccountTransation()
    {

    }

    @Column(name = "TRANSACTION_ID")
    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ACCOUNT_ID")
    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Person_ID")
    public AccountPerson getAccountPerson() {
        return accountPerson;
    }

    public void setAccountPerson(AccountPerson personId) {
        this.accountPerson = personId;
    }

    @Column(name = "AMOUNTUSED")
    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    @Column(name = "DATEUSED")
    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountTransation that = (AccountTransation) o;
        return Objects.equals(transactionId, that.transactionId) && Objects.equals(accountType, that.accountType) && Objects.equals(accountPerson, that.accountPerson) && Objects.equals(amount, that.amount) && Objects.equals(transactionDate, that.transactionDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactionId, accountType, accountPerson, amount, transactionDate);
    }

    @Override
    public String toString() {
        return "AccountTransation{" +
                "transactionId=" + transactionId +
                ", accountType=" + accountType +
                ", personId=" + accountPerson +
                ", amount=" + amount +
                ", transactionDate=" + transactionDate +
                '}';
    }
}
