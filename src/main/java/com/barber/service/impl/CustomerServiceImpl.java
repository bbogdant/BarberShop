package com.barber.service.impl;

import com.barber.entity.*;
import com.barber.repository.CustomerRepository;
import com.barber.repository.RoleRepository;
import com.barber.security.SecurityUtil;
import com.barber.service.CustomerService;
import java.util.List;
import java.util.NoSuchElementException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
	private final CustomerRepository customerRepository;

	private final RoleRepository roleRepository;

	private final PasswordEncoder passwordEncoder;

	@Override
	public List<Customer> findAll(Specification<Customer> specification) {
		return customerRepository.findAll(specification);
	}

	@Override
	public Customer findByName(String name) {
		return customerRepository.findByName(name);
	}

	@Override
	public Customer findById(Integer id) {
		return customerRepository.findById(id)
				.orElseThrow(() -> new NoSuchElementException("CustomerService.notFound"));
	}

	@Override
	public Customer save(Customer customer) {


		Role roleUser = roleRepository.findByRoleName(Role.USER).orElse(null);
		customer.setRole(roleUser);

		customer.setPassword(passwordEncoder.encode(customer.getPassword()));

		return customerRepository.save(customer);


	}

	@Override
	public Customer getLoggedInUser() {
		String ime = SecurityUtil.getSessionUser();
		return findByName(ime);
	}

	@Override
	public Customer update(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public void deleteById(Integer id) {
		customerRepository.deleteById(id);
	}


	@Override
	public boolean isUserAdmin() {
		return getLoggedInUser() != null && getLoggedInUser().getRole().getRoleName().equals(Role.ADMIN);
	}

	@Override
	public boolean isUserUser() {
		return getLoggedInUser() != null && getLoggedInUser().getRole().getRoleName().equals(Role.USER);
	}

	@Override
	public Customer authenticateUser(String username, String password) {
		// Implement your authentication logic here.
		// For example, you can check if the provided username exists in the database
		// and if the password matches the hashed password stored in the database.

		Customer customer = customerRepository.findByName(username);

		if (customer != null && passwordEncoder.matches(password, customer.getPassword())) {
			// Authentication successful
			return customer;
		} else {
			// Authentication failed
			return null;
		}
	}




}