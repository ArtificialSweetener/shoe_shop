package shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import shop.entity.Product;

import java.time.LocalDateTime;

@Controller
public class DemoController {
    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("message", "Its a message from model");
        return "index";
    }
    @ResponseBody
    @GetMapping("/time")
    public String getCurrentTime() {
        return LocalDateTime.now().toString();
    }

    @ResponseBody
    @GetMapping("/phone")
    public Product getProduct() {
        return new Product(1L, "iPhone Demo", 1000.0);
    }
}
