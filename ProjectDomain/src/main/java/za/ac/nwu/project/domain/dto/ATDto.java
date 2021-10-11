package za.ac.nwu.project.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import za.ac.nwu.project.domain.persistence.AccountType;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@ApiModel(value = "AccountType", description = "A DTO that represents the AccountType")
public class ATDto implements Serializable
{
    private static final long serialVersionUID = -5346853206480289868L;

    private String accountName;
    private String accountDesc;
    private LocalDate creationDate;

    public ATDto()
    {

    }

    public ATDto(String accountName, String accountDesc, LocalDate creationDate) {
        this.accountName = accountName;
        this.accountDesc = accountDesc;
        this.creationDate = creationDate;
    }

    public ATDto(AccountType accountType)
    {
        this.setAccountDesc(accountType.getAccountDesc());
        this.setCreationDate(accountType.getCreationDate());
        this.setAccountName(accountType.getAccountName());
    }

    @ApiModelProperty(position = 1, value = "AccountType Mnemonic", name = "Mnemonic",
            notes = "Uniquely identifies the account name", dataType = "java.lang.String",
            example = "MILES", required = true)
    public String getAccountName() {return accountName;}
    public void setAccountName(String accountName) {this.accountName = accountName;}

    @ApiModelProperty(position = 2, value = "AccountType Name", name = "Name",
            notes = "The name of the AccountType", dataType = "java.lang.String",
            example = "MILES", allowEmptyValue = false, required = true)
    public String getAccountDesc() {return accountDesc;}
    public void setAccountDesc(String accountDesc) {this.accountDesc = accountDesc;}

    @ApiModelProperty(position = 3, value = "AccountType Creation Date", name = "CreationDate",
            notes = "This is the date on which the AccountType was Created", dataType = "java.lang.String",
            example = "2020-01-01", allowEmptyValue = true, required = false)
    public LocalDate getCreationDate() {return creationDate;}
    public void setCreationDate(LocalDate creationDate) {this.creationDate = creationDate;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ATDto that = (ATDto) o;
        return Objects.equals(accountName, that.accountName) && Objects.equals(accountDesc, that.accountDesc) && Objects.equals(creationDate, that.creationDate);
    }

    @JsonIgnore
    public AccountType getAccountType()
    {
        return new AccountType(getAccountName(), getAccountDesc(), getCreationDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountName, accountDesc, creationDate);
    }

    @Override
    public String toString() {
        return "AccountTypeDto{" +
                "mnemonic='" + accountName + '\'' +
                ", accountTypeName='" + accountDesc + '\'' +
                ", creationDate=" + creationDate +
                '}';
    }
}
