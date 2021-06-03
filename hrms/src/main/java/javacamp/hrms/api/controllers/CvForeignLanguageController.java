package javacamp.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javacamp.hrms.business.abstracts.CvForeignLanguageService;
import javacamp.hrms.core.utilities.results.*;
import javacamp.hrms.entities.concretes.CvForeignLanguage;

@RestController
@RequestMapping("/api/cvForeignLanguager")
public class CvForeignLanguageController {
	
	private CvForeignLanguageService cvForeignLanguageService;

	@Autowired
	public CvForeignLanguageController(CvForeignLanguageService cvForeignLanguageService) {
		this.cvForeignLanguageService = cvForeignLanguageService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<CvForeignLanguage>> getAll(){
		return this.cvForeignLanguageService.getAll();
	}
	
	@GetMapping("/getAllByCandidate_id")
	public DataResult<List<CvForeignLanguage>> getAllByCandidate_id(@RequestParam int id){
		return this.cvForeignLanguageService.getAllByCandidate_id(id);
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CvForeignLanguage cvForeignLanguage){
		return this.cvForeignLanguageService.add(cvForeignLanguage);
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody CvForeignLanguage cvForeignLanguage){
		return this.cvForeignLanguageService.update(cvForeignLanguage);
	}
	
	@PostMapping("/delete")
	public Result delete(@RequestParam int id){
		return this.cvForeignLanguageService.delete(id);
	}

}
