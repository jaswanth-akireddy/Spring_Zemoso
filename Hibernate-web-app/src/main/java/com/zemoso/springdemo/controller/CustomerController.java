package com.zemoso.springdemo.controller;

import com.zemoso.springdemo.dao.CustomerDAO;
import com.zemoso.springdemo.entity.Customer;
import com.zemoso.springdemo.service.CustomerService;
import org.hibernate.annotations.LazyGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;
import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    //inject the customerService into the controller
    @Autowired
    private CustomerService customerService;

    @GetMapping("/list")
    public String listCustomers(Model theModel){

        //get customers from service and add to model.
        List<Customer> theCustomer = customerService.getCustomers();

        theModel.addAttribute("customers",theCustomer);

        return "list-customers";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel){
        Customer theCustomer = new Customer();
        theModel.addAttribute("customer",theCustomer);
        return "customer-form";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer theCustomer){

        //save customer using our service

        customerService.saveCustomer(theCustomer);

        return "redirect:/customer/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@ModelAttribute("customerId") int theId,Model theModel){

        //get customer from service to populate and send to our form

        Customer theCustomer = customerService.getCustomer(theId);

        theModel.addAttribute("customer",theCustomer);

        return "customer-form";
    }

    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("customerId") int theId){

        //delete customer from service using Id and
        customerService.deleteCustomer(theId);

        return "redirect:/customer/list";

    }




}
