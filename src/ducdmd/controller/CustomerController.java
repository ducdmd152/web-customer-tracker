package ducdmd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ducdmd.dao.CustomerDAO;
import ducdmd.entity.Customer;
import ducdmd.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	// need to inject the customer dao
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String listCustomers(Model model) {
		// get customers from service
		List<Customer> customers = customerService.getCustomers();
		// add the customers to the model
//		System.out.println(customers);
		model.addAttribute("customers", customers);
		
		return "customer/list-customers";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		Customer customer = new Customer();
		
		model.addAttribute(customer);
		
		return "customer/customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(
			@ModelAttribute("customer") Customer customer,
			Model model) {
		customerService.saveCustomer(customer);
		return "redirect:/customer/list";
	}
}
