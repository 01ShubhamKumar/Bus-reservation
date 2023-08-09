package com.Bustickets.tickets.service.Impl;

import com.Bustickets.tickets.entity.Route;
import com.Bustickets.tickets.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
@Service
public class RouteServiceImpl implements RouteService {
    @Autowired
    private RouteRepository routeRepository;
    @Override
    public Route createRoute(Route route) {
        route.setCreatedAt(new Date());
        route.setUpdatedAt(new Date());
        return routeRepository.save(route);
    }
}