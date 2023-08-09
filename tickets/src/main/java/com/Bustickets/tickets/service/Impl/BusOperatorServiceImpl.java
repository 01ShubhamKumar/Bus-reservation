package com.Bustickets.tickets.service.Impl;


import com.Bustickets.tickets.entity.BusOperator;
import com.Bustickets.tickets.repository.BusOperatorRepository;
import com.Bustickets.tickets.service.BusOperatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
@Service
public class BusOperatorServiceImpl implements BusOperatorService {
    @Autowired
    private BusOperatorRepository busOperatorRepository;
    @Override
    public BusOperator createBusOperator(BusOperator busOperator) {
        busOperator.setCreatedAt(new Date());
        busOperator.setUpdatedAt(new Date());
        return busOperatorRepository.save(busOperator);
    }
}
