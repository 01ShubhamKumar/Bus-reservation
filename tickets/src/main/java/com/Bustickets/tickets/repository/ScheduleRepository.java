package com.Bustickets.tickets.repository;

import com.Bustickets.tickets.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
}

