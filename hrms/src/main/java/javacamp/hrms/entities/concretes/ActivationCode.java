package javacamp.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="activation_codes")
@NoArgsConstructor
@AllArgsConstructor
public class ActivationCode {

	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name="id")
	 private int id;
	 
	 @Column(name="user_id")
	 private int userId;
	 
	 @Column(name="activation_code")
	 private String activationCode;
	 
	 @Column(name="is_confirmed")
	 private boolean isConfirmed;
	 
	 @Column(name="create_date", columnDefinition = "Date defult CURRENT_DATE")
	 private LocalDate createDate = LocalDate.now();
	 
	 public ActivationCode(int userId, String activationCode, boolean isConfirmed, LocalDate createDate) {
		 
		 this.userId = userId;
		 this.activationCode = activationCode;
		 this.isConfirmed = isConfirmed;
		 this.createDate = createDate;
	 }
	 
}
