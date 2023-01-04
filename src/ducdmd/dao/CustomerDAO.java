package ducdmd.dao;

import java.util.List;
import ducdmd.entity.Customer;

public interface CustomerDAO {
	public List<Customer> getCustomers();

	public void saveCustomer(Customer customer);
}
