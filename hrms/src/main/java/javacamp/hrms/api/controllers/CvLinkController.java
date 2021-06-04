package javacamp.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javacamp.hrms.business.abstracts.CvLinkService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.*;

@RestController
@RequestMapping("/api/cvLink")
public class CvLinkController {

	private CvLinkService cvLinkService;

	@Autowired
	public CvLinkController(CvLinkService cvLinkService) {
		this.cvLinkService = cvLinkService;
	}
	
	@GetMapping("/getAll")
	DataResult<List<CvLink>> getAll(){
		return this.cvLinkService.getAll();
	}
	
	@GetMapping("/getAllByCandidateId")
	DataResult<List<CvLink>> getAllByCandidateId(@RequestParam int id){
		return this.cvLinkService.getAllByCandidateId(id);
	}
	
	@GetMapping("/getAllById")
	DataResult<CvLink> getAllById(@RequestParam int id){
		return this.cvLinkService.getAllById(id);
	}
	
	
	@PostMapping("/add")
	public Result add(@RequestBody CvLink cvLink){
		return this.cvLinkService.add(cvLink);
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody CvLink cvLink){
		return this.cvLinkService.update(cvLink);
	}
	
	@PostMapping("/delete")
	public Result delete(@RequestParam int id){
		return this.cvLinkService.delete(id);
	}
	
	
}
