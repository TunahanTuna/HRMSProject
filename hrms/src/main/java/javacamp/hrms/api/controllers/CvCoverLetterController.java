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

import javacamp.hrms.business.abstracts.CvCoverLetterService;
import javacamp.hrms.core.utilities.results.*;
import javacamp.hrms.entities.concretes.*;

@RestController
@RequestMapping("/api/cvCoverLetter")
@CrossOrigin
public class CvCoverLetterController {

	private  CvCoverLetterService cvCoverLetterService;

	@Autowired
	public CvCoverLetterController(CvCoverLetterService cvCoverLetterService) {
		this.cvCoverLetterService = cvCoverLetterService;
	}
	
	@GetMapping("/getById")
	DataResult<CvCoverLetter> getById(@RequestParam int id){
		return this.cvCoverLetterService.getById(id);
	}
	
	@GetMapping("/getAll")
	DataResult<List<CvCoverLetter>> getAll(){
		return this.cvCoverLetterService.getAll();
	}
	
	@GetMapping("/getAllByCandidate_id")
	DataResult<List<CvCoverLetter>> getAllByCandidate_id(@RequestParam int id){
		return this.cvCoverLetterService.getAllByCandidate_id(id);
	}
	
	@PostMapping("/add")
	public 	Result add(@RequestBody CvCoverLetter cvCoverLetter){
		return this.cvCoverLetterService.add(cvCoverLetter);
	}
	@PostMapping("/update")
	public 	Result update(@RequestBody CvCoverLetter cvCoverLetter){
		return this.cvCoverLetterService.update(cvCoverLetter);
	}
	@PostMapping("/delete")
	public 	Result delete(@RequestParam int id){
		return this.cvCoverLetterService.delete(id);
	}
	
}
