package com.concordia.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.validation.FieldError;



@RestController
@RequestMapping("/api/project")
public class ProjectController {

	@Autowired
	private ProjectService projectservice;
	
	@Autowired
	private MapErrorValidatorService mapErrorService;

	@PostMapping("")
	public ResponseEntity<?> createNewProject(@Valid @RequestBody Project project,BindingResult result){
		
		
		
		if(result.hasErrors()) {
			return new ResponseEntity<Map<String,String>>(mapErrorService.MapErrorValidator(result),HttpStatus.BAD_REQUEST);
		}
		
		Project newProject = projectservice.saveOrUpdate(project);
		return new ResponseEntity<Project>(newProject,HttpStatus.CREATED);
	}
	
	@GetMapping("/try")
	public String display() {
		
	return "Good Morning!";
	
	}
	
	
	
	@GetMapping("/{projectId}")
	public ResponseEntity<?> getProjectByIdentifier(@PathVariable String projectId) {
		
		Project newProject = projectservice.findProjectsByIdentifier(projectId);
		return new ResponseEntity(newProject,HttpStatus.OK);
		
		
	
	}
	
	
	@GetMapping("/all")
	public ResponseEntity<?> findAllProjects(){
		
		return new ResponseEntity(projectservice.findAllProjects(),HttpStatus.OK);
		
	}
	
	
	@DeleteMapping("/{projectId}")
	public ResponseEntity<?> deleteProject(@PathVariable String projectId){
		
		projectservice.deleteProject(projectId);
		return new ResponseEntity("Project with ID '"+projectId+"' deleted",HttpStatus.OK);
	
	}
	

}

