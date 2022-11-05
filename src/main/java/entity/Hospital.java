package entity;

import base.entity.BaseEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Hospital  extends BaseEntity {
private String name;
@OneToMany(mappedBy = "hospital",cascade = CascadeType.MERGE)
private List<Clinic> clinicList = new ArrayList<>();


}
