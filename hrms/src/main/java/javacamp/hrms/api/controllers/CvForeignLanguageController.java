package javacamp.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javacamp.hrms.business.abstracts.CvForeignLanguageService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.entities.concretes.CvForeignLanguage;

@RestController
@RequestMapping("/api/cvForeignLanguager")
public class CvForeignLanguageController {
	
	private CvForeignLanguageService cvForeignLanguageService;

	@Autowired
	public CvForeignLanguageController(CvForeignLanguageService cvForeignLanguageService) {
		this.cvForeignLanguageService = cvForeignLanguageService;
	}
	
	@GetMapping("/getAllByCandidate_id")
	public DataResult<List<CvForeignLanguage>> getAllByCandidate_id(int id){
		return this.cvForeignLanguageService.getAllByCandidate_id(id);
	}

}
