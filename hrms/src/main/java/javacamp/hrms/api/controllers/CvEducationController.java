package javacamp.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javacamp.hrms.business.abstracts.CvEducationService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.CvEducation;

@RestController
@RequestMapping("/api/cvEducation")
@CrossOrigin
public class CvEducationController {

	private CvEducationService cvEducationService;

	@Autowired
	public CvEducationController(CvEducationService cvEducationService) {
		this.cvEducationService = cvEducationService;
	}
	
	@GetMapping("/getById")
	public DataResult<CvEducation> getById(@RequestParam int id){
		return this.cvEducationService.getById(id);
	}
	@GetMapping("/getAllByCandidate_idOrderByGraduationYearDesc")
	public DataResult<List<CvEducation>> getAllByCandidate_idOrderByGraduationYearDesc(@RequestParam int id){
		return this.cvEducationService.getAllByCandidateIdOrderByGraduationYearDesc(id);
	}
	
	@GetMapping("/getAll")
	public DataResult<List<CvEducation>> getAll(){
		return this.cvEducationService.getAll();
	}
	
	@PostMapping("/add")
	public 	Result add(@RequestBody CvEducation cvEducation) {
		return this.cvEducationService.add(cvEducation);
	}

	@PostMapping("/update")
	public Result update(@RequestBody CvEducation cvEducation){
		return this.cvEducationService.update(cvEducation);
	}
	
	@PostMapping("/delete")
	public Result delete(@RequestParam int id){
		return this.cvEducationService.delete(id);
	}
	
}
