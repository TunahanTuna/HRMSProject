package javacamp.hrms.entities.concretes;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
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
@PrimaryKeyJoinColumn(name = "id")
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
    
    @JsonIgnore
    @OneToMany(mappedBy = "candidate")
    private List<CvEducation> cvEducations;
    
    @JsonIgnore
    @OneToMany(mappedBy = "candidate")
    private List<CvExperience> cvExperience;
    
    @JsonIgnore
    @OneToMany(mappedBy = "candidate")
    private List<CvForeignLanguage> cvForeignLanguage;
    
    @JsonIgnore
    @OneToMany(mappedBy = "candidate")
    private List<CvLink> cvLink;
    
    @JsonIgnore
    @OneToMany(mappedBy = "candidate")
    private List<CvSkill> cvSkill;
    
    @JsonIgnore
    @OneToMany(mappedBy = "candidate")
    private List<CvCoverLetter> cvCoverLetter;
    
    @JsonIgnore
    @OneToMany(mappedBy = "candidate")
    private List<CvImage> cvImage;


}
