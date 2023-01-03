package ducdmd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	@RequestMapping("/list")
	public String listCustomers(Model model) {
//		System.out.println("CAME: CustomerController | listCustomers()");
		return "customer/list-customers";
	}
}
