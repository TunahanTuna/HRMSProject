package javacamp.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javacamp.hrms.business.abstracts.CvExperienceService;
import javacamp.hrms.core.utilities.results.*;
import javacamp.hrms.entities.concretes.CvExperience;

@RestController
@RequestMapping("/api/cvExperience")
public class CvExperienceController {

	private CvExperienceService cvExperienceService;

	@Autowired
	public CvExperienceController(CvExperienceService cvExperienceService) {
		this.cvExperienceService = cvExperienceService;
	}
	
	@GetMapping("/getAllByCandidateIdOrderByEndYearDesc")
	public 	DataResult<List<CvExperience>> getAllByCandidateIdOrderByEndYearDesc(@RequestParam int id){
		return this.cvExperienceService.getAllByCandidateIdOrderByEndYearDesc(id);
	}

	@GetMapping("/getAll")
	public 	DataResult<List<CvExperience>> getAll(){
		return this.cvExperienceService.getAll();
	}
	
	@PostMapping("/add")
	public 	Result add(@RequestBody CvExperience cvExperience){
		return this.cvExperienceService.add(cvExperience);
	}
	@PostMapping("/update")
	public 	Result update(@RequestBody CvExperience cvExperience){
		return this.cvExperienceService.update(cvExperience);
	}
	@PostMapping("/delete")
	public 	Result delete(@RequestParam int id){
		return this.cvExperienceService.delete(id);
	}
}
