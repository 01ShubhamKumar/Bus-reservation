package com.Bustickets.tickets.repository;

import com.Bustickets.tickets.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
