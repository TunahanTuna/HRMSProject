package javacamp.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javacamp.hrms.entities.concretes.AdvertForm;

public interface AdvertFormDao extends JpaRepository<AdvertForm, Integer>{

	@Query("From AdvertForm where isActive = true") // İlan aktif ise tüm listeyi getirir
	List<AdvertForm> getAllOpenAdverts();
	
	@Query("From AdvertForm where isActive = true Order By publishDate Desc") // ilan aktif ise yayınlanma tarihine göre DESC ile sıralar
	List<AdvertForm> getAllByOrderByPublishDateDesc();
	
	@Query("From AdvertForm where isActive = true and employer_id =:id") // firmaya ait iş ilanlarını getirmek için kullanılır.
	List<AdvertForm> getAllOpenAdvertByEmployer(int id);
	
	AdvertForm getById(int id);
}
