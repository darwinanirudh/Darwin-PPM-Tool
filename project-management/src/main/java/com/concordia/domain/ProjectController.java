package com.concordia.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<Project> createNewProject(@RequestBody Project project){
		
		Project newProject = projectservice.saveOrUpdate(project);
		return new ResponseEntity<Project>(newProject,HttpStatus.CREATED);
	}
	
	@GetMapping("/try")
	public String display() {
		
	return "Good Morning!";
	
	}
	
	

}

