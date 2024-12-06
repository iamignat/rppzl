package ignat.malko.controller;

import ignat.malko.model.DeliverySchedule;
import ignat.malko.model.Supplier;
import ignat.malko.model.SupplyOrder;
import ignat.malko.service.DeliveryScheduleOptimizationService;
import ignat.malko.service.DeliveryScheduleService;
import ignat.malko.service.SupplyOrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/delivery-schedules")
public class DeliveryScheduleController {
    private final DeliveryScheduleService deliveryScheduleService;
    private final SupplyOrderService supplyOrderService;
    private final DeliveryScheduleOptimizationService optimizationService;

    public DeliveryScheduleController(DeliveryScheduleService deliveryScheduleService, SupplyOrderService supplyOrderService, DeliveryScheduleOptimizationService optimizationService) {
        this.deliveryScheduleService = deliveryScheduleService;
        this.supplyOrderService = supplyOrderService;
        this.optimizationService = optimizationService;
    }

    // Получение всех графиков
    @GetMapping
    public String getAllDeliverySchedules(Model model) {
        model.addAttribute("schedules", deliveryScheduleService.getAllDeliverySchedules());
        return "delivery-schedules/list";
    }

    // Создание графика поставок (форма)
    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("deliverySchedule", new DeliverySchedule());
        model.addAttribute("supplyOrders", supplyOrderService.getAllSupplyOrders());
        return "delivery-schedules/create";
    }

    // Сохранение графика
    @PostMapping
    public String createDeliverySchedule(@ModelAttribute DeliverySchedule deliverySchedule) {
        deliveryScheduleService.createDeliverySchedule(deliverySchedule);
        return "redirect:/delivery-schedules";
    }

    @GetMapping("/optimize/{supplyOrderId}")
    public String getOptimizedDeliverySchedules(@PathVariable Long supplyOrderId, Model model) {
        SupplyOrder supplyOrder = supplyOrderService.getSupplyOrderById(supplyOrderId);
        var optimizedSchedules = optimizationService.optimizeDeliverySchedules(supplyOrder);

        // Рекомендованный поставщик
        Supplier recommendedSupplier = optimizationService.recommendSupplier(supplyOrder);

        model.addAttribute("schedules", optimizedSchedules);
        model.addAttribute("recommendedSupplier", recommendedSupplier);

        return "delivery-schedules/optimized-list.html";
    }

    @GetMapping("/delete/{id}")
    public String deleteDeliverySchedule(@PathVariable Long id) {
        deliveryScheduleService.deleteDeliverySchedule(id);
        return "redirect:/delivery-schedules";
    }
}

