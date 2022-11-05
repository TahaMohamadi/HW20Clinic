package service.clinic;

import base.service.BaseService;
import entity.Clinic;

import java.util.List;
import java.util.Optional;

public interface ClinicService extends BaseService<Clinic> {
    List<Clinic> findAllClinics();
     Clinic findByClinicId(Long id);
}
