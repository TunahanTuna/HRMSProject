package javacamp.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javacamp.hrms.business.abstracts.AdvertFormService;

@RestController
@RequestMapping("/api/advertform")
public class AdvertFormController {

	private AdvertFormService advertFormService;

	@Autowired
	public AdvertFormController(AdvertFormService advertFormService) {
		this.advertFormService = advertFormService;
	}
	
}
