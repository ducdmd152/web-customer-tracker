package com.ducdmd152.crm.customer;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerJpaRepository extends JpaRepository<Customer, Integer> {
	// no need to write code!
	
	// add a method to sort by last name
	public List<Customer> findAllByOrderByLastNameAsc();
}
