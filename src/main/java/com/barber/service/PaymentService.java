package com.barber.service;

import com.barber.entity.*;
import java.util.Collection;
import java.util.List;
import org.springframework.data.jpa.domain.Specification;

public interface PaymentService {

	List<Payment> findAll(Specification<Payment> specification);

	Payment save(Payment payment);

	Payment update(Payment payment);

	Payment findById(Integer id);

	void deleteById(Integer id);

}