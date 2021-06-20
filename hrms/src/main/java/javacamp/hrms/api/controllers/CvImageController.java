package javacamp.hrms.api.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javacamp.hrms.business.abstracts.CandidateService;
import javacamp.hrms.business.abstracts.CvImageService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.Candidate;
import javacamp.hrms.entities.concretes.CvImage;

@RestController
@RequestMapping("/api/cvImage")
@CrossOrigin
public class CvImageController {

	private CvImageService cvImageService;
	private CandidateService candidateService;
	
	@Autowired
	public CvImageController(CvImageService cvImageService, CandidateService candidateService) {
		this.cvImageService = cvImageService;
		this.candidateService = candidateService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<CvImage>> getAll(){
		return this.cvImageService.getAll();
	}
	
	@GetMapping("/getByImageId")
	public DataResult<CvImage> getByImageId(@RequestParam int id){
		return this.cvImageService.getByImageId(id);
	}
	@GetMapping("/getByCandidate_id")
	public DataResult<CvImage> getByCandidate_id(@RequestParam int id){
		return this.cvImageService.getByCandidate_id(id);
	}
	
	@PostMapping("/add")
	public Result add(@RequestParam int id, @RequestParam MultipartFile filePath) throws IOException {
		Candidate candidate = this.candidateService.getById(id).getData();
		CvImage cvImage = new CvImage();
		cvImage.setCandidate(candidate);		
		return this.cvImageService.add(cvImage, filePath);
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody CvImage cvImage) {
		return this.cvImageService.update(cvImage);
	}
	
	@PostMapping("/delete")
	public Result update(@RequestParam int id) {
		return this.cvImageService.delete(id);
	}
	
	
	
}
