package za.ac.nwu.project.logic.flow.impl;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import za.ac.nwu.project.domain.dto.ATDto;
import za.ac.nwu.project.logic.flow.CreateAccountTypeFlow;
import za.ac.nwu.project.translator.AccountTypeTranslator;

import java.time.LocalDate;

@Transactional
@Component("createAccountTypeFlowName")
public class CreateAccountTypeFlowImpl  implements CreateAccountTypeFlow
{
    private final AccountTypeTranslator accountTypeTranslator;

    public CreateAccountTypeFlowImpl(AccountTypeTranslator accountTypeTranslator)
    {
        this.accountTypeTranslator = accountTypeTranslator;
    }

    @Override
    public ATDto create(ATDto accountType)
    {
        if (null == accountType.getCreationDate())
        {
            accountType.setCreationDate(LocalDate.now());
        }
        return accountTypeTranslator.create(accountType);
    }
}
