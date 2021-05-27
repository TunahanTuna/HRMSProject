package javacamp.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import javacamp.hrms.entities.abstracts.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = false)
@Data
@Entity
//@NoArgsConstructor
//@AllArgsConstructor
@PrimaryKeyJoinColumn(name = "id")
@Table(name = "employers")
public class Employer extends User{
	
	@Column(name = "company_name")
	private String company_name;
	
	@Column(name = "web_site")
	private String web_site;
	
	@Column(name = "phone_number")
	private String phone_number;
	
	public Employer (String company_name, String web_site, String phone_number, String mail, String password) {
		super(mail,password);
		this.company_name = company_name;
		this.phone_number = phone_number;
		this.web_site = web_site;
	}
	
}
