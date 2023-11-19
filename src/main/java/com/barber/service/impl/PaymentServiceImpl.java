package com.barber.service.impl;

import com.barber.entity.*;
import com.barber.repository.PaymentRepository;
import com.barber.service.PaymentService;
import java.util.List;
import java.util.NoSuchElementException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {
	private final PaymentRepository paymentRepository;

	@Override
	public List<Payment> findAll(Specification<Payment> specification) {
		return paymentRepository.findAll(specification);
	}

	@Override
	public Payment findById(Integer id) {
		return paymentRepository.findById(id)
				.orElseThrow(() -> new NoSuchElementException("PaymentService.notFound"));
	}

	@Override
	public Payment save(Payment payment) {
		return paymentRepository.save(payment);
	}

	@Override
	public Payment update(Payment payment) {
		return paymentRepository.save(payment);
	}

	@Override
	public void deleteById(Integer id) {
		paymentRepository.deleteById(id);
	}


}