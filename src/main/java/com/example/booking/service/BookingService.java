package com.example.booking.service;

import com.example.booking.model.Appointment;
import com.example.booking.repository.AppointmentRepository;
import com.example.booking.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    private final AppointmentRepository appointmentRepository;
    private final CustomerRepository customerRepository;

    public BookingService(AppointmentRepository appointmentRepository, CustomerRepository customerRepository) {
        this.appointmentRepository = appointmentRepository;
        this.customerRepository = customerRepository;
    }

    public List<Appointment> findAll() {
        return appointmentRepository.findAll();
    }

    public Optional<Appointment> findById(Long id) {
        return appointmentRepository.findById(id);
    }

    public Appointment save(Appointment appointment) {
        if (appointment.getCustomer() != null && appointment.getCustomer().getId() != null) {
            customerRepository.findById(appointment.getCustomer().getId())
                    .ifPresent(appointment::setCustomer);
        }
        return appointmentRepository.save(appointment);
    }

    public void deleteById(Long id) {
        appointmentRepository.deleteById(id);
    }
}
