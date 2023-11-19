package com.barber.service.impl;

import com.barber.entity.*;
import com.barber.repository.BarberRepository;
import com.barber.service.BarberService;
import java.util.List;
import java.util.NoSuchElementException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BarberServiceImpl implements BarberService {
	private final BarberRepository barberRepository;

	@Override
	public List<Barber> findAll(Specification<Barber> specification) {
		return barberRepository.findAll(specification);
	}

	@Override
	public Barber findById(Integer id) {
		return barberRepository.findById(id)
				.orElseThrow(() -> new NoSuchElementException("BarberService.notFound"));
	}

	@Override
	public Barber save(Barber barber) {
		return barberRepository.save(barber);
	}

	@Override
	public Barber update(Barber barber) {
		return barberRepository.save(barber);
	}

	@Override
	public void deleteById(Integer id) {
		barberRepository.deleteById(id);
	}


}