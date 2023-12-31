package com.Bustickets.tickets.conroller;

;

import com.Bustickets.tickets.payload.BusDTO;
import com.Bustickets.tickets.payload.BusOperatorDTO;
import com.Bustickets.tickets.payload.RouteDTO;
import com.Bustickets.tickets.payload.ScheduleDTO;
import com.Bustickets.tickets.service.BusOperatorService;
import com.Bustickets.tickets.service.BusService;
import com.Bustickets.tickets.service.Impl.RouteService;
import com.Bustickets.tickets.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class BookingController {
    @Autowired
    private BusOperatorService busOperatorService;
    @Autowired
    private BusService busService;
    @Autowired
    private RouteService routeService;
    @Autowired
    private ScheduleService scheduleService;
    //http://localhost:8080/api/busoperators
    @PostMapping("/busoperators")
    public ResponseEntity<BusOperatorDTO> createBusOperator(@RequestBody
                                                            BusOperatorDTO busOperatorDTO){
        BusOperatorDTO busOperator =

                busOperatorService.createBusOperator(busOperatorDTO);
        return new ResponseEntity<>(busOperator, HttpStatus.CREATED);
    }
    //http://localhost:8080/api/1/buses
    @PostMapping("/{busoperatorId}/buses")
    public ResponseEntity<BusDTO> createBus(@PathVariable long
                                                    busoperatorId, @RequestBody BusDTO busDTO){
        BusDTO bus = busService.createBus(busoperatorId, busDTO);
        return new ResponseEntity<>(bus,HttpStatus.CREATED);
    }
    //http://localhost:8080/api/routes
    @PostMapping("/routes")
    public ResponseEntity<RouteDTO> createRoute(@RequestBody RouteDTO
                                                        routeDTO){
        RouteDTO route = routeService.createRoute(routeDTO);
        return new ResponseEntity<>(route,HttpStatus.CREATED);
    }
    //http://localhost:8080/api/1/1/schedule
    @PostMapping("/{busId}/{routeId}/schedule")
    public ResponseEntity<ScheduleDTO> createSchedule(@PathVariable long
                                                               busId, @PathVariable long routeId, @RequestBody ScheduleDTO scheduleDTO){
        ScheduleDTO schedule = scheduleService.createSchedule(busId, routeId, scheduleDTO);
        return new ResponseEntity<>(schedule,HttpStatus.CREATED);
    }
}

