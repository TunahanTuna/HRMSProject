package javacamp.hrms.entities.concretes;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.LastModifiedDate;

import lombok.Data;

@Data
@Entity
@Table(name = "job_positions")
public class JobPosition {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "u_id")
	private String u_id;
	
	@Column(name = "position_name")
	private String positionName;
	
	@Column(name="created_date")
    private LocalDateTime created_date= LocalDateTime.now();
    
    @LastModifiedDate
    @Column(name="updated_date")
    private LocalDateTime updated_date;
    
    @Column(name="status")
    private boolean status;
	
}
