package javacamp.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "advert_forms")
@NoArgsConstructor
@AllArgsConstructor
public class AdvertForm {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "min_pay")
	private int minPay;
	
	@Column(name = "max_pay")
	private int maxPay;
	
	@Column(name = "open_position_number")
	private int openPositionNumber;
	
	@Column(name = "deadline_date")
	private LocalDate deadlineDate;
	
	@Column(name = "publish_date")
	private LocalDate publishDate;
	
	@Column(name = "create_date")
	private LocalDate createDate;
	
	@Column(name = "is_active")
	private boolean isActive;
	
	@ManyToOne
	@JoinColumn(name = "job_position_id")
	private JobPosition jobPosition;
	
	@ManyToOne
	@JoinColumn(name = "city_id")
	private City city;
	
	@ManyToOne
	@JoinColumn(name = "employer_id")
	private Employer employer;
	
	
	
}