package com.aspectlog.controller;

import com.aspectlog.model.Customer;
import com.aspectlog.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;
    @GetMapping("")
    public String home(Model model) throws Exception {
        List<Customer> customerList = customerService.findAll();
        model.addAttribute("customers", customerList);
        return "list";
    }
    @GetMapping("/{id}")
    public ModelAndView showInformation(@PathVariable Long id) {
        try {
            ModelAndView modelAndView = new ModelAndView("/customer/info");
            Customer customer = (Customer) customerService.findOne(id);
            modelAndView.addObject("customer", customer);
            return modelAndView;
        } catch (Exception e) {
            return new ModelAndView("redirect:/customers");
        }
    }
    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("customers", new Customer());
        return "create";
    }
    @PostMapping("/save")
    public String save(Customer customer){
        customerService.save(customer);
        return "redirect:/customers";
    }

}
