package service.appointment.impl;

import base.service.impl.BaseServiceImpl;
import entity.Appointment;
import entity.Patient;
import repository.appointment.AppointmentRepo;
import repository.appointment.impl.AppointmentRepoImpl;
import service.appointment.AppointmentService;
import util.Hibernate;

import java.util.List;

public class AppointmentServiceImpl extends BaseServiceImpl<Appointment, AppointmentRepo> implements AppointmentService {
    private final AppointmentRepo appointmentRepo = new AppointmentRepoImpl(Hibernate.getEntityManagerFactory().createEntityManager());

    public AppointmentServiceImpl(AppointmentRepo repository) {
        super(repository);
    }

    @Override
    public List<Appointment> findByPatient(Patient patient) {
        try{
            return appointmentRepo.findByPatient(patient);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
