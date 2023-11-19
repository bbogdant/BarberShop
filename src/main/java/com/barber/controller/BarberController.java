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
@RequestMapping("/barbers")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class BarberController {
	private final BarberService barberService;

	@GetMapping
	@ApiOperation(value = "", nickname = "getAllBarbers")
	public ResponseEntity<List<Barber>> getAllBarbers(@RequestParam(name = "q", required = false) Specification<Barber> specification) {
		return ResponseEntity.ok(barberService.findAll(specification));
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "", nickname = "getBarberById")
	public ResponseEntity<Barber> getBarberById(@PathVariable Integer id) {
		return ResponseEntity.ok(barberService.findById(id));
	}

	@PostMapping
	@ApiOperation(value = "", nickname = "saveBarber")
	public ResponseEntity<Barber> saveBarber(@RequestBody Barber barber) {
		return ResponseEntity.status(HttpStatus.CREATED).body(barberService.save(barber));
	}

	@PutMapping
	@ApiOperation(value = "", nickname = "updateBarber")
	public ResponseEntity<Barber> updateBarber(@RequestBody Barber barber) {
		return ResponseEntity.ok(barberService.update(barber));
	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "", nickname = "deleteBarberById")
	public void deleteBarberById(@PathVariable Integer id) {
		barberService.deleteById(id);
	}

}

