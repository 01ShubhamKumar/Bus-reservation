package com.Bustickets.tickets.service.Impl;

import com.Bustickets.tickets.entity.Bus;
import com.Bustickets.tickets.repository.BusRepository;
import com.Bustickets.tickets.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class BusServiceImpl implements BusService {
    @Autowired
    private BusRepository busRepository;
    @Override
    public Bus createBus(Bus bus) {
        bus.setCreatedAt(new Date());
        bus.setUpdatedAt(new Date());

        return busRepository.save(bus);
    }
}
