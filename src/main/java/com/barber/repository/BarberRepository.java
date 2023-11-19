package com.barber.repository;

import com.barber.entity.Barber;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

@Repository
public interface BarberRepository extends JpaRepository<Barber, Integer>, JpaSpecificationExecutor<Barber> {

}