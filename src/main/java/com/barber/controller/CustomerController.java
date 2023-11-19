package com.barber.controller;


import com.barber.entity.*;
import com.barber.service.*;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import lombok.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class CustomerController {
	private final CustomerService customerService;

	@GetMapping
	@ApiOperation(value = "", nickname = "getAllCustomers")
	public ResponseEntity<List<Customer>> getAllCustomers(@RequestParam(name = "q", required = false) Specification<Customer> specification) {
		return ResponseEntity.ok(customerService.findAll(specification));
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "", nickname = "getCustomerById")
	public ResponseEntity<Customer> getCustomerById(@PathVariable Integer id) {
		return ResponseEntity.ok(customerService.findById(id));
	}

	@PostMapping
	@ApiOperation(value = "", nickname = "saveCustomer")
	public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer) {
		return ResponseEntity.status(HttpStatus.CREATED).body(customerService.save(customer));
	}

	@PutMapping
	@ApiOperation(value = "", nickname = "updateCustomer")
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) {
		return ResponseEntity.ok(customerService.update(customer));
	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "", nickname = "deleteCustomerById")
	public void deleteCustomerById(@PathVariable Integer id) {
		customerService.deleteById(id);
	}

}

