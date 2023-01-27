package com.ducdmd152.crm.customer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerJpaRepository extends JpaRepository<Customer, Integer> {
	// no need to write code!
}
