package net.javaguides.springboot.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import net.javaguides.springboot.model.Appointment;
import net.javaguides.springboot.service.AppointmentService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RestController
public class AppointmentController {
  @Autowired
    private final AppointmentService appointmentService;

    @Autowired
    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @GetMapping("/appointments")
    public String getAllAppointments(Model model) {
        List<Appointment> appointments = appointmentService.getAllAppointments();
        model.addAttribute("appointments", appointments);
        model.addAttribute("newAppointment", new Appointment());
        return "appointments";
    }

    @PostMapping("/appointments/add")
    public String addAppointment(@RequestBody Appointment appointment) {
        appointmentService.addAppointment(appointment);
        return "redirect:/appointments";
    }
}
