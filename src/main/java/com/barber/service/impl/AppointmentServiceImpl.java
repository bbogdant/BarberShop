package com.barber.service.impl;

import com.barber.entity.*;
import com.barber.repository.AppointmentRepository;
import com.barber.service.AppointmentService;
import java.util.List;
import java.util.NoSuchElementException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {
	private final AppointmentRepository appointmentRepository;

	@Override
	public List<Appointment> findAll(Specification<Appointment> specification) {
		return appointmentRepository.findAll(specification);
	}

	@Override
	public Appointment findById(Integer id) {
		return appointmentRepository.findById(id)
				.orElseThrow(() -> new NoSuchElementException("AppointmentService.notFound"));
	}

	@Override
	public Appointment save(Appointment appointment) {
		return appointmentRepository.save(appointment);
	}

	@Override
	public Appointment update(Appointment appointment) {
		return appointmentRepository.save(appointment);
	}

	@Override
	public void deleteById(Integer id) {
		appointmentRepository.deleteById(id);
	}


}