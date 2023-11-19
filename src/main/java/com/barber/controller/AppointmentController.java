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
@RequestMapping("/appointments")
@RequiredArgsConstructor
public class AppointmentController {
	private final AppointmentService appointmentService;

	@GetMapping
	@ApiOperation(value = "", nickname = "getAllAppointments")
	public ResponseEntity<List<Appointment>> getAllAppointments(@RequestParam(name = "q", required = false) Specification<Appointment> specification) {
		return ResponseEntity.ok(appointmentService.findAll(specification));
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "", nickname = "getAppointmentById")
	public ResponseEntity<Appointment> getAppointmentById(@PathVariable Integer id) {
		return ResponseEntity.ok(appointmentService.findById(id));
	}

	@PostMapping
	@ApiOperation(value = "", nickname = "saveAppointment")
	public ResponseEntity<Appointment> saveAppointment(@RequestBody Appointment appointment) {
		return ResponseEntity.status(HttpStatus.CREATED).body(appointmentService.save(appointment));
	}

	@PutMapping
	@ApiOperation(value = "", nickname = "updateAppointment")
	public ResponseEntity<Appointment> updateAppointment(@RequestBody Appointment appointment) {
		return ResponseEntity.ok(appointmentService.update(appointment));
	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "", nickname = "deleteAppointmentById")
	public void deleteAppointmentById(@PathVariable Integer id) {
		appointmentService.deleteById(id);
	}

}

