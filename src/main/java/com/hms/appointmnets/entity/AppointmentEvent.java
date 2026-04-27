package com.hms.appointmnets.entity;

import java.time.LocalDate;

public class AppointmentEvent {

    private int appointmentId;
    private String patientName;
    private String doctorName;
    private LocalDate appointmentDate;
    private String status;

    public AppointmentEvent() {}

    public AppointmentEvent(int appointmentId, String patientName,
                            String doctorName, LocalDate appointmentDate,
                            String status) {
        this.appointmentId = appointmentId;
        this.patientName = patientName;
        this.doctorName = doctorName;
        this.appointmentDate = appointmentDate;
        this.status = status;
    }

    public int getAppointmentId() { return appointmentId; }
    public void setAppointmentId(int appointmentId) { this.appointmentId = appointmentId; }

    public String getPatientName() { return patientName; }
    public void setPatientName(String patientName) { this.patientName = patientName; }

    public String getDoctorName() { return doctorName; }
    public void setDoctorName(String doctorName) { this.doctorName = doctorName; }

    public LocalDate getAppointmentDate() { return appointmentDate; }
    public void setAppointmentDate(LocalDate appointmentDate) { this.appointmentDate = appointmentDate; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}