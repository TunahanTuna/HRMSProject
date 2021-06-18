package javacamp.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javacamp.hrms.business.abstracts.AdvertFormService;
import javacamp.hrms.core.utilities.results.*;
import javacamp.hrms.entities.concretes.AdvertForm;

@RestController
@RequestMapping("/api/advertform")
@CrossOrigin
public class AdvertFormController {

	private AdvertFormService advertFormService;

	@Autowired
	public AdvertFormController(AdvertFormService advertFormService) {
		this.advertFormService = advertFormService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody AdvertForm AdvertForm){
		return this.advertFormService.add(AdvertForm);
	}
	@PostMapping("/update")
	public Result update(@RequestBody AdvertForm AdvertForm){
		return this.advertFormService.update(AdvertForm);
	}
	
	@PostMapping("/makePassive")
	public Result makePassive(int id){
		return this.advertFormService.makePassive(id);
	}
	
	@GetMapping("/getAll")
	public DataResult<List<AdvertForm>> getAll(){
		return this.advertFormService.getAll();
	}
	
	@GetMapping("/getAllOpenAdverts")
	public DataResult<List<AdvertForm>> getAllOpenAdverts(){
		return this.advertFormService.getAllOpenAdverts();
	}
	
	@GetMapping("/getAllByOrderByPublishDateDesc")
	public DataResult<List<AdvertForm>> getAllByOrderByPublishDateDesc(){
		return this.advertFormService.getAllByOrderByDescPublishDate();
	}
	
	@GetMapping("/getAllOpenJobAdvertByEmployer")
	public DataResult<List<AdvertForm>> getAllOpenAdvertFormByEmployer(int id){
		return this.advertFormService.getAllOpenJobAdvertByEmployer(id);
	}
	
	
}
