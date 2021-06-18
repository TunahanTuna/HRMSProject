package javacamp.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="advertform_work_type")
public class AdvertFormWorkType {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="worktype_id")
	private int id;
	
	@Column(name="work_type")
	private String workType;
	
	@JsonIgnore
	@OneToMany(mappedBy = "advertFormWorkType")
	private List<AdvertForm> adverts;
}
