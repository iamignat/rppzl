package ignat.malko.controller;

import ignat.malko.model.Contract;
import ignat.malko.service.ContractService;
import ignat.malko.service.SupplierService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/contracts")
public class ContractController {
    private final ContractService contractService;
    private final SupplierService supplierService;

    public ContractController(ContractService contractService, SupplierService supplierService) {
        this.contractService = contractService;
        this.supplierService = supplierService;
    }

    // Получение всех контрактов
    @GetMapping
    public String getAllContracts(Model model) {
        model.addAttribute("contracts", contractService.getAllContracts());
        return "contracts/list";
    }

    // Создание нового контракта (форма)
    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("contract", new Contract());
        model.addAttribute("suppliers", supplierService.getAllSuppliers());
        return "contracts/create";
    }

    // Сохранение контракта
    @PostMapping
    public String createContract(@ModelAttribute Contract contract) {
        contractService.createContract(contract);
        return "redirect:/contracts";
    }

    @GetMapping("/delete/{id}")
    public String deleteContract(@PathVariable Long id) {
        contractService.deleteContract(id);
        return "redirect:/contracts";
    }
}

