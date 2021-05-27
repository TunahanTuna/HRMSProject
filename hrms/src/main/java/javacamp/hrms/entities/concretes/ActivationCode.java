package javacamp.hrms.entities.concretes;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.LastModifiedDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="activation_codes")
public class ActivationCode {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="user_id")
    private int userId;
    
    @Column(name="u_id")
    private String u_id;
    
    @Column(name="activation_code")
    private String activationCode;
    
    @Column(name="expration_date")
    private LocalDateTime exprationDate;
    
    @Column(name="is_confirmed")
    private boolean is_confirmed;

    @Column(name="confirm_date")
    private String confirm_date;
    
    @Column(name="activation_date")
    private LocalDateTime activation_date;
    
    @Column(name="created_date")
    private LocalDateTime created_date= LocalDateTime.now();
    
    @LastModifiedDate
    @Column(name="updated_date")
    private LocalDateTime updated_date;
    
    @Column(name="status")
    private boolean status;
	
	
    public ActivationCode(int userId, String activationCode) {
        this.userId = userId;
        this.activationCode = activationCode;
    }

    
}
