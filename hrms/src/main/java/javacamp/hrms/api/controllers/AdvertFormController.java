package javacamp.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	@GetMapping("/getAll")
	public DataResult<List<AdvertForm>> getAll(){
		return this.advertFormService.getAll();
	}
	
	
}
