package com.Bustickets.tickets.repository;

import com.Bustickets.tickets.entity.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRepository extends JpaRepository<Passenger, Long>
{
}