package za.ac.nwu.project.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "ACCOUNT", schema = "DCS")
public class AccountType implements Serializable
{
    @Id
    @SequenceGenerator(name = "GENERIC_SEQ",sequenceName = "RELATION.GENERIC_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GENERIC_SEQ")

    private Long accountId;

    private String accountName;

    private String accountDesc;

    private LocalDate creationDate;

    private Long amount;

    private Set<AccountTransation> accountTransations;
    private Object accountTransactions;

    public AccountType(Long accountId, String accountName, String accountDesc, LocalDate creationDate, Long amount)
    {
        this.accountId = accountId;
        this.accountName = accountName;
        this.accountDesc = accountDesc;
        this.creationDate = creationDate;
        this.amount = amount;
    }

    public AccountType(String mnemonic, String accountTypeName, LocalDate creationDate) {

    }

    public AccountType() {

    }

    @Column(name = "ACCOUNT_ID")
    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    @Column(name = "ACCOUNT_NAME")
    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    @Column(name = "ACCOUNT_DESC")
    public String getAccountDesc() {
        return String.valueOf(accountDesc);
    }

    public void setAccountDesc(String accountDesc) {
        this.accountDesc = accountDesc;
    }

    @Column(name = "CREATED")
    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    @OneToMany(targetEntity = AccountTransation.class, fetch = FetchType.LAZY,
            mappedBy = "accountType", orphanRemoval = true, cascade = CascadeType.PERSIST)
    public Set<AccountTransation> getAccountTransations()
    {
        return accountTransations;
    }

    public void setAccountTransations(Set<AccountTransation> accountTransations)
    {
        this.accountTransactions = accountTransactions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountType that = (AccountType) o;
        return Objects.equals(accountId, that.accountId) && Objects.equals(accountName, that.accountName) && Objects.equals(accountDesc, that.accountDesc) && Objects.equals(creationDate, that.creationDate) && Objects.equals(amount, that.amount) && Objects.equals(accountTransations, that.accountTransations) && Objects.equals(accountTransactions, that.accountTransactions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountId, accountName, accountDesc, creationDate, amount, accountTransations, accountTransactions);
    }

    @Override
    public String toString() {
        return "AccountType{" +
                "accountId=" + accountId +
                ", accountName='" + accountName + '\'' +
                ", accountDesc='" + accountDesc + '\'' +
                ", creationDate=" + creationDate +
                ", amount=" + amount +
                ", accountTransations=" + accountTransations +
                ", accountTransactions=" + accountTransactions +
                '}';
    }
}
