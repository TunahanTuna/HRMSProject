package javacamp.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javacamp.hrms.business.abstracts.AdvertFormWorkTimeService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.entities.concretes.AdvertFormWorkTime;

@RestController
@RequestMapping("/api/advertFormWorkTime")
@CrossOrigin
public class AdvertFormWorkTimeController {

	private AdvertFormWorkTimeService advertFormWorkTimeService;

	@Autowired
	public AdvertFormWorkTimeController(AdvertFormWorkTimeService advertFormWorkTimeService) {
		this.advertFormWorkTimeService = advertFormWorkTimeService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<AdvertFormWorkTime>> getAll(){
		return this.advertFormWorkTimeService.getAll();
	}
	
}
