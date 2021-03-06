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

import javacamp.hrms.business.abstracts.CandidateService;
import javacamp.hrms.core.utilities.results.*;
import javacamp.hrms.entities.concretes.Candidate;
import javacamp.hrms.entities.dtos.CandidateCvDto;

@RestController
@RequestMapping("/api/candidate")
@CrossOrigin
public class CandidateController {
	
	private CandidateService candidateService;

	@Autowired
	public CandidateController(CandidateService candidateService) {
		super();
		this.candidateService = candidateService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<Candidate>> getAll(){
		return this.candidateService.getAll();
	}
	
	@GetMapping("/getCandidateByNationalityId")
	public DataResult<Candidate> getCandidateByNationalityId(@RequestParam String NationaltiyId){
		return this.candidateService.getCandidateByNationalityId(NationaltiyId);
	}
	
	@GetMapping("/getByCandidateCvDtoId")
	public DataResult<CandidateCvDto> getByCandidateCvDtoId(@RequestParam int id){
		return this.candidateService.getByCandidateCvDtoId(id);
	}
	
	@GetMapping("/getByCandidateCvDtoNationalityId")
	public DataResult<CandidateCvDto> getByCandidateCvDtoNationalityId(@RequestParam String nationalityId){
		return this.candidateService.getByCandidateCvDtoNationalityId(nationalityId);
	}
	
	@GetMapping("/getById")
	public DataResult<Candidate> getById(@RequestParam int id){
		return this.candidateService.getById(id);
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Candidate candidate){
		return this.candidateService.add(candidate);
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody Candidate candidate){
		return this.candidateService.update(candidate);
	}
	
	@PostMapping("/delete")
	public Result delete(@RequestParam int id){
		return this.candidateService.delete(id);
	}
	
	
	

}
