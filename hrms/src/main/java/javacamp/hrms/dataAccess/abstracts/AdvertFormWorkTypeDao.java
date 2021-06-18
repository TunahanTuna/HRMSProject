package javacamp.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import javacamp.hrms.entities.concretes.AdvertFormWorkType;

public interface AdvertFormWorkTypeDao extends JpaRepository<AdvertFormWorkType, Integer> {

}
