package za.ac.nwu.project.translator;

import za.ac.nwu.project.domain.dto.ATDto;

import java.util.List;

public interface AccountTypeTranslator
{
    List<ATDto> getAllAccountTypes();

    List<ATDto> getAllAcountTypes();

    ATDto create(ATDto accountType);
}
