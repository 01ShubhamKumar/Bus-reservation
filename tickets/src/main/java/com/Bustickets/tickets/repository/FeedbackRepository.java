package com.Bustickets.tickets.repository;

import com.Bustickets.tickets.entity.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
}
