package ignat.malko.service;

import ignat.malko.model.DeliverySchedule;
import ignat.malko.repository.DeliveryScheduleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryScheduleService {
    private final DeliveryScheduleRepository deliveryScheduleRepository;

    public DeliveryScheduleService(DeliveryScheduleRepository deliveryScheduleRepository) {
        this.deliveryScheduleRepository = deliveryScheduleRepository;
    }

    // Создание графика поставки
    public DeliverySchedule createDeliverySchedule(DeliverySchedule schedule) {
        return deliveryScheduleRepository.save(schedule);
    }

    // Получение всех графиков
    public List<DeliverySchedule> getAllDeliverySchedules() {
        return deliveryScheduleRepository.findAll();
    }

    // Обновление статуса графика
    public DeliverySchedule updateScheduleStatus(Long id, String status) {
        return deliveryScheduleRepository.findById(id).map(schedule -> {
            schedule.setStatus(status);
            return deliveryScheduleRepository.save(schedule);
        }).orElseThrow(() -> new RuntimeException("График не найден"));
    }

    public void deleteDeliverySchedule(Long id) {
        deliveryScheduleRepository.deleteById(id);
    }
}

