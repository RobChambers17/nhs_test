package com.logicbig.example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CustomerController {

    private static List<Customer> customerList = new ArrayList<>();

    @PostMapping("/")
    public String handlePostRequest(@Valid Customer customer, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "customer-form";
        }
        customerList.add(customer);
        return "redirect:/customers";
    }

    @GetMapping("/")
    public String handleGetRequest(Customer customer) {
        return "customer-form";
    }

    @GetMapping("/customers")
    public String handleGetRequest(Model model) {
        model.addAttribute("customers", customerList);
        return "customer-view";
    }
}