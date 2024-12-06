package ignat.malko.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String showIndexPage(Model model) {
        model.addAttribute("title", "Управление снабжением");
        model.addAttribute("subtitle", "Добро пожаловать в систему снабжения!");
        return "index";
    }
}

