package com.Bustickets.tickets.repository;

import com.Bustickets.tickets.entity.UserOffer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserOfferRepository extends JpaRepository<UserOffer, Long> {
}
