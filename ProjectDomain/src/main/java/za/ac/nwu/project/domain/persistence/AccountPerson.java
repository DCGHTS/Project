package za.ac.nwu.project.domain.persistence;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "PERSON", schema = "DCS")
public class AccountPerson
{
    @Id
    @SequenceGenerator(name = "GENERIC_SEQ",sequenceName = "DCS.GENERIC_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GENERIC_SEQ")

    private Long personId;

    private String personFName;

    private String personLName;

    private String personNum;

    private String personEmail;

    public AccountPerson(Long personId, String personFName, String personLName, String personNum, String personEmail) {
        this.personId = personId;
        this.personFName = personFName;
        this.personLName = personLName;
        this.personNum = personNum;
        this.personEmail = personEmail;
    }

    public AccountPerson() {

    }

    private Set<AccountTransation> accountTransations;
    private Object accountTransactions;

    @OneToMany(targetEntity = AccountTransation.class, fetch = FetchType.LAZY,
            mappedBy = "accountPerson", orphanRemoval = true, cascade = CascadeType.PERSIST)
    public Set<AccountTransation> getAccountTransations()
    {
        return accountTransations;
    }
    public void setAccountTransations(Set<AccountTransation> accountTransations)
    {
        this.accountTransactions = accountTransactions;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public String getPersonFName() {
        return personFName;
    }

    public void setPersonFName(String personFName) {
        this.personFName = personFName;
    }

    public String getPersonLName() {
        return personLName;
    }

    public void setPersonLName(String personLName) {
        this.personLName = personLName;
    }

    public String getPersonNum() {
        return personNum;
    }

    public void setPersonNum(String personNum) {
        this.personNum = personNum;
    }

    public String getPersonEmail() {
        return personEmail;
    }

    public void setPersonEmail(String personEmail) {
        this.personEmail = personEmail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountPerson that = (AccountPerson) o;
        return Objects.equals(personId, that.personId) && Objects.equals(personFName, that.personFName) && Objects.equals(personLName, that.personLName) && Objects.equals(personNum, that.personNum) && Objects.equals(personEmail, that.personEmail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(personId, personFName, personLName, personNum, personEmail);
    }

    @Override
    public String toString() {
        return "AccountPerson{" +
                "personId=" + personId +
                ", personFName='" + personFName + '\'' +
                ", personLName='" + personLName + '\'' +
                ", personNum='" + personNum + '\'' +
                ", personEmail='" + personEmail + '\'' +
                '}';
    }
}
