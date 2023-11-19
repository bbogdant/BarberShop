package com.barber.service;

import com.barber.entity.*;
import java.util.Collection;
import java.util.List;
import org.springframework.data.jpa.domain.Specification;

public interface AppointmentService {

	List<Appointment> findAll(Specification<Appointment> specification);

	Appointment save(Appointment appointment);

	Appointment update(Appointment appointment);

	Appointment findById(Integer id);

	void deleteById(Integer id);

}