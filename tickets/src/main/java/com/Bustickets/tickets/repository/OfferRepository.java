package com.Bustickets.tickets.repository;

import com.Bustickets.tickets.entity.Offer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfferRepository extends JpaRepository<Offer, Long> {
}
