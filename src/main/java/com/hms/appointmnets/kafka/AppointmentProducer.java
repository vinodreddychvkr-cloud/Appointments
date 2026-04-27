package com.hms.appointmnets.kafka;

import com.hms.appointmnets.entity.AppointmentEvent;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;

@Service
public class AppointmentProducer {

    private static final String TOPIC = "appointment-events";

    @Autowired
    private KafkaTemplate<String, AppointmentEvent> kafkaTemplate;

    public AppointmentProducer(KafkaTemplate<String, AppointmentEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendEvent(AppointmentEvent event, String jwtToken) {

        ProducerRecord<String, AppointmentEvent> record =
                new ProducerRecord<>(TOPIC, event);

        // Add JWT to Kafka header
        record.headers().add(
                "Authorization",
                jwtToken.getBytes(StandardCharsets.UTF_8)
        );

        kafkaTemplate.send(record);
    }
}