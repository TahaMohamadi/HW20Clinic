package repository.drug;

import base.repository.BaseRepository;
import entity.Drug;

public interface DrugRepo extends BaseRepository<Drug> {
    Drug findByName(String name);
}
