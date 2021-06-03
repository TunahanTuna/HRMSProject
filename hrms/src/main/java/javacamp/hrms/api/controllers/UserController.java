package javacamp.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javacamp.hrms.business.abstracts.UserService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.entities.abstracts.User;

@RestController
@RequestMapping("/api/users")
public class UserController {

		private UserService userService;

		@Autowired
		public UserController(UserService userService) {
			super();
			this.userService = userService;

		}


		@GetMapping("/getall")
		public DataResult<List<User>> getAll(){
			return this.userService.getAll();
		}
		
		@GetMapping("/getUserByEmail")
		public DataResult<User> getUserByEmail(String email){
			return this.userService.getUserByEmail(email);
		}

}
