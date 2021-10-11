package za.ac.nwu.project.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "ACCOUNT_TYPE", schema = "VITRSA_SANDBOX")
public class AccountType implements Serializable
{
    @Id
    @SequenceGenerator(name = "VIT_RSA_GENERIC_SEQ",sequenceName = "VITRSA_SANDBOX.VIT_RSA_GENERIC_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "VIT_RSA_GENERIC_SEQ")

    private Long accountTypeId;

    private String mnemonic;

    private Long accountTypeName;

    private Long creationDate;

    private Set<AccountTransation> accountTransations;
    private Object accountTransactions;

    public AccountType(Long accountTypeId, String mnemonic, Long accountTypeName, Long creationDate)
    {
        this.accountTypeId = accountTypeId;
        this.mnemonic = mnemonic;
        this.accountTypeName = accountTypeName;
        this.creationDate = creationDate;
    }
    public AccountType()
    {

    }

    public AccountType(String mnemonic, String accountTypeName, LocalDate creationDate)
    {

    }

    @Column(name = "ACCOUNT_TYPE_ID")
    public Long getAccountTypeId() {
        return accountTypeId;
    }

    public void setAccountTypeId(Long accountTypeId) {
        this.accountTypeId = accountTypeId;
    }

    @Column(name = "MNEMONIC")
    public String getMnemonic() {
        return mnemonic;
    }

    public void setMnemonic(String mnemonic) {
        this.mnemonic = mnemonic;
    }

    @Column(name = "ACCOUNT_TYPE_NAME")
    public String getAccountTypeName() {
        return String.valueOf(accountTypeName);
    }

    public void setAccountTypeName(Long accountTypeName) {
        this.accountTypeName = accountTypeName;
    }

    @Column(name = "CREATION_DATE")
    public LocalDate getCreationDate() {
        return LocalDate.ofEpochDay(creationDate);
    }

    public void setCreationDate(Long creationDate) {
        this.creationDate = creationDate;
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
        return Objects.equals(accountTypeId, that.accountTypeId) && Objects.equals(mnemonic, that.mnemonic) && Objects.equals(accountTypeName, that.accountTypeName) && Objects.equals(creationDate, that.creationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountTypeId, mnemonic, accountTypeName, creationDate);
    }

    @Override
    public String toString() {
        return "AccountType{" +
                "accountTypeId=" + accountTypeId +
                ", mnemonic='" + mnemonic + '\'' +
                ", accountTypeName=" + accountTypeName +
                ", creationDate=" + creationDate +
                '}';
    }
}
