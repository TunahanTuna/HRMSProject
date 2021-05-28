package javacamp.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javacamp.hrms.entities.concretes.ActivationCode;


@EnableJpaRepositories
public interface ActivationCodeDao extends JpaRepository<ActivationCode, Integer>{

}
