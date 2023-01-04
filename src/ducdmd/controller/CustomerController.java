package ducdmd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import ducdmd.dao.CustomerDAO;
import ducdmd.entity.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	// need to inject the customer dao
	@Autowired
	private CustomerDAO customerDAO;
	
	@RequestMapping("/list")
	public String listCustomers(Model model) {
		// get customers from dao
		List<Customer> customers = customerDAO.getCustomers();
		// add the customers to the model
//		System.out.println(customers);
		model.addAttribute("customers", customers);
		
		return "customer/list-customers";
	}
}
