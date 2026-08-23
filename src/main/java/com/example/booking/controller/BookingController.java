package com.example.booking.controller;

import com.example.booking.model.Appointment;
import com.example.booking.repository.CustomerRepository;
import com.example.booking.service.BookingService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class BookingController {

    private final BookingService bookingService;
    private final CustomerRepository customerRepository;

    public BookingController(BookingService bookingService, CustomerRepository customerRepository) {
        this.bookingService = bookingService;
        this.customerRepository = customerRepository;
    }

    @GetMapping("/")
    public String root() {
        return "redirect:/appointments";
    }

    @GetMapping("/appointments")
    public String listAppointments(Model model) {
        model.addAttribute("appointments", bookingService.findAll());
        return "appointments/list";
    }

    @GetMapping("/appointments/new")
    public String newAppointmentForm(Model model) {
        model.addAttribute("appointment", new Appointment());
        model.addAttribute("customers", customerRepository.findAll());
        return "appointments/form";
    }

    @PostMapping("/appointments")
    public String createAppointment(@Valid @ModelAttribute Appointment appointment, BindingResult br, Model model) {
        if (br.hasErrors()) {
            model.addAttribute("customers", customerRepository.findAll());
            return "appointments/form";
        }
        bookingService.save(appointment);
        return "redirect:/appointments";
    }

    @GetMapping("/appointments/delete/{id}")
    public String deleteAppointment(@PathVariable Long id) {
        bookingService.deleteById(id);
        return "redirect:/appointments";
    }
}
