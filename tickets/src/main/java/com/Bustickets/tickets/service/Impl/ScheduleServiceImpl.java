package com.Bustickets.tickets.service.Impl;

import com.Bustickets.tickets.entity.Schedule;
import com.Bustickets.tickets.repository.ScheduleRepository;
import com.Bustickets.tickets.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ScheduleServiceImpl implements ScheduleService {
    @Autowired
    private ScheduleRepository scheduleRepository;

    @Override
    public Schedule createSchedule(Schedule schedule) {
        schedule.setCreatedAt(new Date());
        schedule.setUpdatedAt(new Date());
        return scheduleRepository.save(schedule);
    }
}