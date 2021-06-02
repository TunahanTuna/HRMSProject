package javacamp.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "cv_experiences")
@NoArgsConstructor
@AllArgsConstructor
public class CvExperience {

	@Column(name = "workplace")
	@NotNull
	@NotBlank
	private String workplace;
	
	@Column(name = "position")
	@NotNull
	@NotBlank
	private String position;
	
	@Column(name = "starating_year")
	@NotNull
	@NotBlank
	private String startingYear;
	
	@Column(name = "end_year")
	private String endYear;
	
	@ManyToOne()
	@JoinColumn(name = "candidate_id")
	private Candidate candidate;
}