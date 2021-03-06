package javacamp.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javacamp.hrms.entities.concretes.Employer;


@EnableJpaRepositories
public interface EmployerDao extends JpaRepository<Employer, Integer> {

}
