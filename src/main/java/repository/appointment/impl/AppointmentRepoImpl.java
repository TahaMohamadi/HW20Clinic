package repository.appointment.impl;

import base.repository.impl.BaseRepositoryImpl;
import entity.Appointment;
import entity.Patient;
import jakarta.persistence.EntityManager;
import repository.appointment.AppointmentRepo;
import util.Hibernate;

import java.util.List;

public class AppointmentRepoImpl extends BaseRepositoryImpl<Appointment> implements AppointmentRepo {
    public AppointmentRepoImpl(EntityManager em) {
        super(em);
    }

    public Class<Appointment> getEntityClass() {
        return Appointment.class;
    }

    @Override
    public List<Appointment> findByPatient(Patient patient) {
        String jpql = """
                select a from Appointment a where a.patient = :patient
                """;
        return (Hibernate.getEntityManagerFactory().createEntityManager().createQuery(jpql, Appointment.class).setParameter("patient", patient).getResultList());
    }
}
