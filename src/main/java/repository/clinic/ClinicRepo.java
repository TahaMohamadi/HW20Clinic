package repository.clinic;

import base.repository.BaseRepository;
import entity.Clinic;

import java.util.List;

public interface ClinicRepo extends BaseRepository<Clinic> {
      List<Clinic> findAllClinics();

}
