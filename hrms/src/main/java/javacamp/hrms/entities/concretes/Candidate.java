package javacamp.hrms.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import javacamp.hrms.entities.abstracts.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
//@NoArgsConstructor
//@AllArgsConstructor
@PrimaryKeyJoinColumn(name = "id")
@Table(name = "candidates")
public class Candidate extends User {
	
	@Column(name = "first_name")
	private String first_name;
	
	@Column(name = "last_name")
	private String last_name;
	
	@Column(name = "nationality_id")
	private String nationality_id;
	
	@Column(name = "birthdate")
	private Date birthdate;
	
	public Candidate (String first_name, String last_name, String nationality_id, Date birthdate, String mail, String password) {
		super(mail,password);
		this.first_name = first_name;
		this.last_name = last_name;
		this.nationality_id = nationality_id;
		this.birthdate = birthdate;
	}
}

