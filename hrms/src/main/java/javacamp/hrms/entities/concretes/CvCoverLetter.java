package javacamp.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cv_cover_letter")
public class CvCoverLetter {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name = "cover_letter_id")
	private int id;
	
	@Column(name = "content") 
	@NotNull
	@NotBlank
	private String content;
	
	@ManyToOne()
	@JsonIgnore
	@JoinColumn(name = "candidate_id")
	private Candidate candidate;
}
