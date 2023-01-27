package com.ducdmd152.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ducdmd152.crm.customer.Customer;
import com.ducdmd152.crm.customer.CustomerService;

@Controller
@RequestMapping("/customers")
public class CustomerController {
	// need to inject the customer dao
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String listCustomers(Model model) {
		List<Customer> customers = customerService.getCustomers();
		model.addAttribute("customers", customers);
		
		return "customers/list-customers";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		Customer customer = new Customer();
		
		customer.setId(0);
		model.addAttribute(customer);
		model.addAttribute("FORM_TITLE","Create customer");
		
		return "customers/customer-form";
	}
	
	@PostMapping("/save")
	public String saveCustomer(
			@ModelAttribute("customer") Customer customer,
			Model model) {
		customerService.saveCustomer(customer);
		return "redirect:/customers/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(
			@RequestParam int customerId,
			Model model) {		
		Customer customer = customerService.getCustomer(customerId);
				
		model.addAttribute(customer);
		
		return "customers/customer-form";
	}
	
	@GetMapping("/deleteCustomer")
	public String deleteCustomer(
			@RequestParam int customerId
			) {
		
		// delete the customer
		customerService.deleteCustomer(customerId);
		
		return "redirect:/customers/list";
	}
}
