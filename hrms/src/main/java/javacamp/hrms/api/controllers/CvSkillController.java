package javacamp.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javacamp.hrms.business.abstracts.CvSkillService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.CvSkill;

@RestController
@RequestMapping("/api/cvSkill")
public class CvSkillController {

	private CvSkillService cvSkillService;

	@Autowired
	public CvSkillController(CvSkillService cvSkillService) {
		this.cvSkillService = cvSkillService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CvSkill cvSkill) {
		return this.cvSkillService.add(cvSkill);
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody CvSkill cvSkill) {
		return this.cvSkillService.update(cvSkill);
	}
	
	@PostMapping("/delete")
	public Result delete(@RequestParam int id) {
		return this.cvSkillService.delete(id);
	}
	
	@GetMapping("/getAll")
	public DataResult<List<CvSkill>> getAll() {
		return this.cvSkillService.getAll();
	}
	
	@GetMapping("/getAllByCandidate_id")
	public DataResult<List<CvSkill>> getAllByCandidate_id(@RequestParam int id) {
		return this.cvSkillService.getAllByCandidate_id(id);
	}
	
	@GetMapping("/getById")
	public DataResult<CvSkill> getById(@RequestParam int id) {
		return this.cvSkillService.getById(id);
	}
}
