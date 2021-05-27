package javacamp.hrms.entities.abstracts;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import org.springframework.data.annotation.LastModifiedDate;

import lombok.Data;

@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "users")
public abstract class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "u_id")
	private String u_id;
	
	@Column(name = "email")
	private String mail;
	
	@Column(name = "password")
	private String password;
	
	@Column(name="created_date")
    private LocalDateTime createdDate= LocalDateTime.now();

    @LastModifiedDate
    @Column(name="updated_date")
    private LocalDateTime updatedDate;

    @Column(name="status")
    private boolean status;
	
	public User (String mail, String password) {
		this.mail = mail;
		this.password = password;
	}
}
