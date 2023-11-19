package com.barber.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.time.*;
import java.util.*;
import javax.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@Table(name = "payment")
@RequiredArgsConstructor
public class Payment implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@ManyToOne
	@JoinColumn(name = "appointment_id", referencedColumnName = "id")
	private Appointment appointmentId;
	@Column(name = "amount")
	private Double amount;
	@Column(name = "payment_method")
	private String paymentMethod;
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Payment payment = (Payment) o;
		return id.equals(payment.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}


}