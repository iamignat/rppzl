package ignat.malko.repository;

import ignat.malko.model.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ContractRepository extends JpaRepository<Contract, Long> {
    List<Contract> findByStartDateBeforeAndEndDateAfter(LocalDate startDate, LocalDate endDate);
}

