package ignat.malko.controller;

import ignat.malko.model.PurchaseRequest;
import ignat.malko.service.PurchaseRequestService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/purchase-requests")
public class PurchaseRequestController {
    private final PurchaseRequestService purchaseRequestService;

    public PurchaseRequestController(PurchaseRequestService purchaseRequestService) {
        this.purchaseRequestService = purchaseRequestService;
    }

    @GetMapping
    public String getAllPurchaseRequests(Model model) {
        List<PurchaseRequest> requests = purchaseRequestService.getAllPurchaseRequests();
        model.addAttribute("requests", requests);
        return "purchase-requests/list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("purchaseRequest", new PurchaseRequest());
        return "purchase-requests/create";
    }

    @PostMapping
    public String createPurchaseRequest(@ModelAttribute PurchaseRequest purchaseRequest) {
        purchaseRequestService.createPurchaseRequest(purchaseRequest);
        return "redirect:/purchase-requests";
    }

    @GetMapping("/delete/{id}")
    public String deletePurchaseRequest(@PathVariable Long id) {
        purchaseRequestService.deletePurchaseRequest(id);
        return "redirect:/purchase-requests";
    }
}

