package repository.appointment.impl;

import base.repository.impl.BaseRepositoryImpl;
import entity.Appointment;
import jakarta.persistence.EntityManager;
import repository.appointment.AppointmentRepo;

public class AppointmentRepoImpl extends BaseRepositoryImpl<Appointment> implements AppointmentRepo {
    public AppointmentRepoImpl(EntityManager em) {
        super(em);
    }

    public Class<Appointment> getEntityClass() {
        return Appointment.class;
    }
}
