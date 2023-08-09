package com.Bustickets.tickets.repository;

import com.Bustickets.tickets.entity.UserPaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserPaymentMethodRepository  extends JpaRepository<UserPaymentMethod, Long> {
}
