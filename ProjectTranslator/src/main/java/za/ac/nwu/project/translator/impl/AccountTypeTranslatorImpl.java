package za.ac.nwu.project.translator.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.project.domain.dto.ATDto;
import za.ac.nwu.project.domain.persistence.AccountType;
import za.ac.nwu.project.repo.persistence.ATRepo;
import za.ac.nwu.project.translator.AccountTypeTranslator;

import java.util.ArrayList;
import java.util.List;

@Component
public abstract class AccountTypeTranslatorImpl implements AccountTypeTranslator
{
    private final ATRepo ATRepo;

    @Autowired
    public AccountTypeTranslatorImpl(ATRepo ATRepo)
    {
        this.ATRepo = ATRepo;
    }

    @Override
    public List<ATDto> getAllAccountTypes()
    {

        List<ATDto> ATDtos = new ArrayList<>();
        try {
            for (AccountType accountType : ATRepo.findAll())
            {
                ATDtos.add(new ATDto(accountType));
            }
        }
        catch (Exception e)
        {
            throw new RuntimeException("Unable to read from the DB", e);
        }

        return ATDtos;
    }

    @Override
    public ATDto create(ATDto ATDto) {
        try
        {
            AccountType accountType = ATRepo.save(ATDto.getAccountType());
            return new ATDto(accountType);
        }catch (Exception e)
        {
            throw new RuntimeException("Unable to save to the DB", e);
        }
    }
}
