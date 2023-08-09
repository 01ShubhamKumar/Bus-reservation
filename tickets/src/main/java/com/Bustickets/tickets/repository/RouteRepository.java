package com.Bustickets.tickets.repository;

import com.Bustickets.tickets.entity.Route;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RouteRepository extends JpaRepository<Route, Long> {
}