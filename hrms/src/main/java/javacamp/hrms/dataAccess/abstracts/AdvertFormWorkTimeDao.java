package javacamp.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import javacamp.hrms.entities.concretes.AdvertFormWorkTime;

public interface AdvertFormWorkTimeDao extends JpaRepository<AdvertFormWorkTime, Integer> {

}
