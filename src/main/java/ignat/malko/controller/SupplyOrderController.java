package ignat.malko.controller;

import ignat.malko.model.SupplyOrder;
import ignat.malko.service.PurchaseRequestService;
import ignat.malko.service.SupplierService;
import ignat.malko.service.SupplyOrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/supply-orders")
public class SupplyOrderController {
    private final SupplyOrderService supplyOrderService;
    private final PurchaseRequestService purchaseRequestService;
    private final SupplierService supplierService;

    public SupplyOrderController(SupplyOrderService supplyOrderService, PurchaseRequestService purchaseRequestService, SupplierService supplierService) {
        this.supplyOrderService = supplyOrderService;
        this.purchaseRequestService = purchaseRequestService;
        this.supplierService = supplierService;
    }

    @GetMapping
    public String getAllSupplyOrders(Model model) {
        model.addAttribute("orders", supplyOrderService.getAllSupplyOrders());
        return "supply-orders/list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("supplyOrder", new SupplyOrder());
        model.addAttribute("purchaseRequests", purchaseRequestService.getAllPurchaseRequests());
        model.addAttribute("suppliers", supplierService.getAllSuppliers());
        return "supply-orders/create";
    }

    @PostMapping
    public String createSupplyOrder(@ModelAttribute SupplyOrder supplyOrder) {
        supplyOrderService.createSupplyOrder(supplyOrder);
        return "redirect:/supply-orders";
    }

    @GetMapping("/delete/{id}")
    public String deleteSupplyOrder(@PathVariable Long id) {
        supplyOrderService.deleteSupplyOrder(id);
        return "redirect:/supply-orders";
    }
}
