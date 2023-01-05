package ducdmd.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ducdmd.dao.CustomerDAO;
import ducdmd.entity.Customer;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDAO customerDAO;
	
	@Override
	public List<Customer> getCustomers() {
		
		return customerDAO.getCustomers();
	}

	@Override
	public void saveCustomer(Customer customer) {
		
		customerDAO.saveCustomer(customer);
	}

	@Override
	public Customer getCustomer(int customerId) {		
		return customerDAO.getCustomer(customerId);
	}	
}
