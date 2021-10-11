package za.ac.nwu.project.repo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.nwu.project.domain.persistence.AccountType;

@Repository
public interface ATRepo extends JpaRepository<AccountType, Long>
{

}
