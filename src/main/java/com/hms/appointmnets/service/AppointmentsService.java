package com.hms.appointmnets.service;

import com.hms.appointmnets.entity.AppointmentEvent;
import com.hms.appointmnets.entity.Appointments;
import com.hms.appointmnets.kafka.AppointmentProducer;
import com.hms.appointmnets.repository.AppointmentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AppointmentsService {

    @Autowired
    private AppointmentsRepository appointmentsRepository;

    @Autowired
    private AppointmentProducer producer;

    public Appointments save(Appointments empInfo, String jwtToken){

        Appointments saved = appointmentsRepository.save(empInfo);

        AppointmentEvent event = new AppointmentEvent(
                saved.getAptId(),
                saved.getPatientName(),
                saved.getEmailId(),
                LocalDate.now(),
                "CREATED"
        );

        producer.sendEvent(event, jwtToken);

        return saved;
    }

    public List<Appointments> getAllAppointments() {
        return appointmentsRepository.findAll();
    }
}
