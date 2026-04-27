package com.hms.appointmnets.controller;

import com.hms.appointmnets.entity.Appointments;
import com.hms.appointmnets.service.AppointmentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AppointmentsController {

    @Autowired
    private AppointmentsService appointmentsService;

    @PostMapping
    public ResponseEntity<Appointments> createAppointment(
            @RequestBody Appointments appointment,
            @RequestHeader("Authorization") String authorizationHeader
    ) {

        return ResponseEntity.ok(
                appointmentsService.save(appointment, authorizationHeader)
        );
    }

    @GetMapping("/appointments")
    public List<Appointments> getAllAppointments(){
        return appointmentsService.getAllAppointments();
    }
}
