package javacamp.hrms.entities.concretes;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javacamp.hrms.entities.abstracts.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Table(name="candidates")

public class Candidate extends User{
	
	
	@Column(name="nationality_id")
    private String nationalityId;
	 
	@Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="birthdate",columnDefinition = "DATE")
    private Date birthDate;
    
    
    @OneToMany(mappedBy = "candidate")
    private List<CvEducation> cvEducations;
      
    @OneToMany(mappedBy = "candidate")
    private List<CvExperience> cvExperience;
    
    @OneToMany(mappedBy = "candidate")
    private List<CvForeignLanguage> cvForeignLanguage;
    
    @OneToMany(mappedBy = "candidate")
    private List<CvLink> cvLink;
    
    @OneToMany(mappedBy = "candidate")
    private List<CvSkill> cvSkill;
    
    @OneToMany(mappedBy = "candidate")
    private List<CvCoverLetter> cvCoverLetter;
    
    @OneToOne(mappedBy = "candidate",optional= false, fetch = FetchType.LAZY)
    private CvImage cvImage;


}
