package za.ac.nwu.project.domain.persistence;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "Transaction", schema = "DCS")
public class AccountTransation
{
    @Id
    @SequenceGenerator(name = "GENERIC_SEQ",sequenceName = "RELATION.GENERIC_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GENERIC_SEQ")

    private Long transactionId;

    private AccountType accountType;

    private Long personId;

    private Long amount;

    private LocalDate transactionDate;

    public AccountTransation(Long transactionId, AccountType accountType, Long personId, Long amount, LocalDate transactionDate) {
        this.transactionId = transactionId;
        this.accountType = accountType;
        this.personId = personId;
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

    @Column(name = "PERSON_ID")
    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
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
        return Objects.equals(transactionId, that.transactionId) && Objects.equals(accountType, that.accountType) && Objects.equals(personId, that.personId) && Objects.equals(amount, that.amount) && Objects.equals(transactionDate, that.transactionDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactionId, accountType, personId, amount, transactionDate);
    }

    @Override
    public String toString() {
        return "AccountTransation{" +
                "transactionId=" + transactionId +
                ", accountType=" + accountType +
                ", personId=" + personId +
                ", amount=" + amount +
                ", transactionDate=" + transactionDate +
                '}';
    }
}
