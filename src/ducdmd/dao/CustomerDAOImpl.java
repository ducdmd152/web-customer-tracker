package ducdmd.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ducdmd.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
//	@Transactional
	public List<Customer> getCustomers() {
		// get the current hibernate session
		Session session = sessionFactory.getCurrentSession();

		// create a query
		String HQL = "FROM Customer "
				+ "ORDER BY lastName";
		Query query = session.createQuery(HQL, Customer.class);

		// execute query and get result list
		List<Customer> customers = query.getResultList();

		// return the results
		return customers;
	}

	@Override
	public void saveCustomer(Customer customer) {
		// get the current hibernate session
		Session session = sessionFactory.getCurrentSession();

		// save the customer
		session.save(customer);
	}

}
