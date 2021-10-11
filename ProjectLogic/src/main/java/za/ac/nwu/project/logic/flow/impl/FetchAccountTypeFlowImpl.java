package za.ac.nwu.project.logic.flow.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import za.ac.nwu.project.domain.dto.ATDto;
import za.ac.nwu.project.logic.flow.FetchAccountTypeFlow;
import za.ac.nwu.project.translator.AccountTypeTranslator;

import java.util.List;

@Transactional
@Component
public class FetchAccountTypeFlowImpl implements FetchAccountTypeFlow
{
    private final AccountTypeTranslator accountTypeTranslator;

    @Autowired
    public FetchAccountTypeFlowImpl(AccountTypeTranslator accountTypeTranslator)
    {
        this.accountTypeTranslator = accountTypeTranslator;
    }

    @Override
    public List<ATDto> getAllAcountTypes()
    {
        return accountTypeTranslator.getAllAcountTypes();
    }
}
