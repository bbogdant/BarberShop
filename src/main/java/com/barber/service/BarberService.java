package com.barber.service;

import com.barber.entity.*;
import java.util.Collection;
import java.util.List;
import org.springframework.data.jpa.domain.Specification;

public interface BarberService {

	List<Barber> findAll(Specification<Barber> specification);

	Barber save(Barber barber);

	Barber update(Barber barber);

	Barber findById(Integer id);

	void deleteById(Integer id);

}