package rikkei.academy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import rikkei.academy.model.Customer;

import java.util.List;
import javax.servlet.http.*;

@Controller
public class CustomerServlet  {
    private Customer.CustomerService customerService;

    @GetMapping("/customers")
    public String showList(Model model) {
        List<Customer> customerList = customerService.findAll();
        model.addAttribute("customers", customerList);
        return "customers/list";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable Long id, HttpServletRequest request) {
        Customer customer = customerService.findOne(id);
        request.setAttribute("customer", customer);
        return "customers/info";
    }

}