package com.hms.appointmnets.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Appointments")
public class Appointments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int aptId;
    private int empId;
    private String patientName;
    private String patientProblem;
    private String mobileNumber;
    private String address;
    private String emailId;
    private String gender;
    private String issueDescription;
    private String doctorComments;
    private String status;

}
