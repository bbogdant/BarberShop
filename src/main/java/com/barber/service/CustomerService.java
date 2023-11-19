package com.barber.service;

import com.barber.entity.*;
import java.util.Collection;
import java.util.List;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.core.GrantedAuthority;

public interface CustomerService {

	List<Customer> findAll(Specification<Customer> specification);

	Customer findByName(String name);

	Customer save(Customer customer);

	Customer getLoggedInUser();

	Customer update(Customer customer);

	Customer findById(Integer id);

	void deleteById(Integer id);

	boolean isUserAdmin();

	boolean isUserUser();

	Customer authenticateUser(String username, String password);


}