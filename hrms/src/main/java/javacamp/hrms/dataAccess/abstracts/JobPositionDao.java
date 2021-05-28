package javacamp.hrms.dataAccess.abstracts;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javacamp.hrms.entities.concretes.JobPosition;


@EnableJpaRepositories
public interface JobPositionDao extends JpaRepository<JobPosition, Integer> {
	
	JobPosition findByPositionName(String positionName);
	
}
