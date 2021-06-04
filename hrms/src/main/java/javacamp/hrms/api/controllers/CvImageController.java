package javacamp.hrms.api.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javacamp.hrms.business.abstracts.CandidateService;
import javacamp.hrms.business.abstracts.CvImageService;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.Candidate;
import javacamp.hrms.entities.concretes.CvImage;

@RestController
@RequestMapping("/api/cvImage")
public class CvImageController {

	private CvImageService cvImageService;
	private CandidateService candidateService;
	
	@Autowired
	public CvImageController(CvImageService cvImageService, CandidateService candidateService) {
		this.cvImageService = cvImageService;
		this.candidateService = candidateService;
	}
	@PostMapping("/add")
	public Result add(@RequestParam int id, @RequestParam MultipartFile filePath) throws IOException {
		Candidate candidate = this.candidateService.getById(id).getData();
		CvImage cvImage = new CvImage();
		cvImage.setCandidate(candidate);		
		return this.cvImageService.add(cvImage, filePath);
	}
	
	
}
