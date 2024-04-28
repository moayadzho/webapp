package net.javaguides.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import net.javaguides.springboot.model.Appointment;
import net.javaguides.springboot.repository.AppointmentRepository;

import java.util.List;

@Service
public class AppointmentService {
    @Autowired
    private final AppointmentRepository appointmentRepository;

    @Autowired
    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    public void addAppointment(Appointment appointment) {
        appointmentRepository.save(appointment);
    }
}
