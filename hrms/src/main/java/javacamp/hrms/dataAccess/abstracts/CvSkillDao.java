package javacamp.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import javacamp.hrms.entities.concretes.CvSkill;

public interface CvSkillDao extends JpaRepository<CvSkill, Integer>{

	CvSkill getBySkillId(int id);
	
	List<CvSkill> getAllByCandidate_id(int id);
	
}
