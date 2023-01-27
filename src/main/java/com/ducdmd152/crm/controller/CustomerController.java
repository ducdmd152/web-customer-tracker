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
@RequestMapping("/customer")
public class CustomerController {
	// need to inject the customer dao
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String listCustomers(Model model) {
		List<Customer> customers = customerService.getCustomers();
		model.addAttribute("customers", customers);
		
		return "customer/list-customers";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		Customer customer = new Customer();
		
		model.addAttribute(customer);
		model.addAttribute("FORM_TITLE","Create customer");
		
		return "list-customers";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(
			@ModelAttribute("customer") Customer customer,
			Model model) {
//		System.out.println("Customer ID: " + customer.getId());
//		customer.setId(7);
//		System.out.println("Customer ID: " + customer.getId());
		customerService.saveCustomer(customer);
//		System.out.println("Customer ID: " + customer.getId());
		return "redirect:/customer/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(
			@RequestParam int customerId,
			Model model) {		
		Customer customer = customerService.getCustomer(customerId);
				
		model.addAttribute(customer);
		model.addAttribute("FORM_TITLE","Update customer");
		
		return "customer/customer-form";
	}
	
	@GetMapping("/deleteCustomer")
	public String deleteCustomer(
			@RequestParam int customerId
			) {
		
		// delete the customer
		customerService.deleteCustomer(customerId);
		
		return "redirect:/customer/list";
	}
}
