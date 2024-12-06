package ignat.malko.service;

import ignat.malko.model.DeliverySchedule;
import ignat.malko.model.Supplier;
import ignat.malko.model.SupplyOrder;
import ignat.malko.repository.DeliveryScheduleRepository;
import ignat.malko.repository.SupplierRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DeliveryScheduleOptimizationService {
    private final DeliveryScheduleRepository deliveryScheduleRepository;
    private final SupplierRepository supplierRepository;

    public DeliveryScheduleOptimizationService(DeliveryScheduleRepository deliveryScheduleRepository, SupplierRepository supplierRepository) {
        this.deliveryScheduleRepository = deliveryScheduleRepository;
        this.supplierRepository = supplierRepository;
    }

    public List<DeliverySchedule> optimizeDeliverySchedules(SupplyOrder supplyOrder) {
        List<DeliverySchedule> schedules = deliveryScheduleRepository.findBySupplyOrder(supplyOrder);
        return schedules.stream()
                .sorted((ds1, ds2) -> {
                    if (ds1.getPriority().equals(ds2.getPriority())) {
                        return ds1.getDeliveryTime().compareTo(ds2.getDeliveryTime());
                    }
                    return ds1.getPriority().compareTo(ds2.getPriority());
                })
                .collect(Collectors.toList());
    }

    public Supplier recommendSupplier(SupplyOrder supplyOrder) {
        List<Supplier> suppliers = supplierRepository.findAll();

        // Рейтинг от высокого к низкому
        return suppliers.stream().min((s1, s2) -> s2.getRating().compareTo(s1.getRating()))
                .orElse(null);
    }
}

