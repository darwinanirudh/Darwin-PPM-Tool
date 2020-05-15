package com.concordia.domain;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

	@Autowired
	private ProjectService projectservice;

	@PostMapping("")
	public ResponseEntity<?> createNewProject(@Valid @RequestBody Project project,BindingResult result){
		
		if(result.hasErrors()) {
			return new ResponseEntity<String>("Invalid Object::Project Entity Object",HttpStatus.BAD_REQUEST);
		}
		
		Project newProject = projectservice.saveOrUpdate(project);
		return new ResponseEntity<Project>(newProject,HttpStatus.CREATED);
	}
	
	@GetMapping("/try")
	public String display() {
		
	return "Good Morning!";
	
	}
	
	

}

