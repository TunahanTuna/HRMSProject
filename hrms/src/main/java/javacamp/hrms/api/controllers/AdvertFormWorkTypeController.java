package javacamp.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javacamp.hrms.business.abstracts.AdvertFormWorkTypeService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.entities.concretes.AdvertFormWorkType;

@RestController
@RequestMapping("/api/advertFormWorkTypeController")
@CrossOrigin
public class AdvertFormWorkTypeController {
	private AdvertFormWorkTypeService advertFormWorkTypeService;

	@Autowired
	public AdvertFormWorkTypeController(AdvertFormWorkTypeService advertFormWorkTypeService) {
		this.advertFormWorkTypeService = advertFormWorkTypeService;
	}

	@GetMapping("/getAll")
	public DataResult<List<AdvertFormWorkType>> getAll(){
		return this.advertFormWorkTypeService.getAll();
	}

}
