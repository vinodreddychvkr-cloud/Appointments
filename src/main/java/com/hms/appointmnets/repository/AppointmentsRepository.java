package com.hms.appointmnets.repository;

import com.hms.appointmnets.entity.Appointments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentsRepository extends JpaRepository<Appointments,Integer> {

}
