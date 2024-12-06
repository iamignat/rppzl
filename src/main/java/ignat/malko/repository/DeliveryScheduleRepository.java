package ignat.malko.repository;

import ignat.malko.model.DeliverySchedule;
import ignat.malko.model.SupplyOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeliveryScheduleRepository extends JpaRepository<DeliverySchedule, Long> {
    List<DeliverySchedule> findByStatus(String status);
    List<DeliverySchedule> findBySupplyOrder(SupplyOrder supplyOrder);
}

