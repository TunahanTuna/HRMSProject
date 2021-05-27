package javacamp.hrms.dataAccess.abstracts;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import javacamp.hrms.entities.concretes.JobPosition;

public interface JobPositionsDao extends JpaRepository<JobPosition, Integer> {

	Optional<JobPosition> finByTitle(String title);
	
}
