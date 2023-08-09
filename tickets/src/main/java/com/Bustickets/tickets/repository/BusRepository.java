package com.Bustickets.tickets.repository;

import com.Bustickets.tickets.entity.Bus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusRepository extends JpaRepository<Bus, Long> {
}