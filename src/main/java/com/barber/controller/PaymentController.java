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
@RequestMapping("/payments")
@RequiredArgsConstructor
public class PaymentController {
	private final PaymentService paymentService;

	@GetMapping
	@ApiOperation(value = "", nickname = "getAllPayments")
	public ResponseEntity<List<Payment>> getAllPayments(@RequestParam(name = "q", required = false) Specification<Payment> specification) {
		return ResponseEntity.ok(paymentService.findAll(specification));
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "", nickname = "getPaymentById")
	public ResponseEntity<Payment> getPaymentById(@PathVariable Integer id) {
		return ResponseEntity.ok(paymentService.findById(id));
	}

	@PostMapping
	@ApiOperation(value = "", nickname = "savePayment")
	public ResponseEntity<Payment> savePayment(@RequestBody Payment payment) {
		return ResponseEntity.status(HttpStatus.CREATED).body(paymentService.save(payment));
	}

	@PutMapping
	@ApiOperation(value = "", nickname = "updatePayment")
	public ResponseEntity<Payment> updatePayment(@RequestBody Payment payment) {
		return ResponseEntity.ok(paymentService.update(payment));
	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "", nickname = "deletePaymentById")
	public void deletePaymentById(@PathVariable Integer id) {
		paymentService.deleteById(id);
	}

}

