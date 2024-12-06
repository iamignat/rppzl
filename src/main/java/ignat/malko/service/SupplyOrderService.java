package ignat.malko.service;

import ignat.malko.model.SupplyOrder;
import ignat.malko.repository.SupplyOrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplyOrderService {
    private final SupplyOrderRepository supplyOrderRepository;

    public SupplyOrderService(SupplyOrderRepository supplyOrderRepository) {
        this.supplyOrderRepository = supplyOrderRepository;
    }

    public SupplyOrder createSupplyOrder(SupplyOrder order) {
        order.setStatus("PENDING");
        order.setOrderDate(java.time.LocalDate.now());
        return supplyOrderRepository.save(order);
    }

    public List<SupplyOrder> getAllSupplyOrders() {
        return supplyOrderRepository.findAll();
    }

    public SupplyOrder updateOrderStatus(Long id, String status) {
        return supplyOrderRepository.findById(id).map(order -> {
            order.setStatus(status);
            return supplyOrderRepository.save(order);
        }).orElseThrow(() -> new RuntimeException("Заказ не найден"));
    }

    public SupplyOrder getSupplyOrderById(Long supplyOrderId) {
        return supplyOrderRepository.findById(supplyOrderId).orElse(null);
    }

    public void deleteSupplyOrder(Long id) {
        supplyOrderRepository.deleteById(id);
    }
}

