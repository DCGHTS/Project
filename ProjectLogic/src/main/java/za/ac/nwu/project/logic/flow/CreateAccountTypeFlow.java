package za.ac.nwu.project.logic.flow;

import za.ac.nwu.project.domain.dto.ATDto;

public interface CreateAccountTypeFlow {
    ATDto create(ATDto accountType);
}
