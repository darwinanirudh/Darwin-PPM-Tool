package com.concordia.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {
	
	@Autowired
	private ProjectRepository projectrespoistory;
	
	
	public Project saveOrUpdate(Project project) {
		
		try {
			project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
		return projectrespoistory.save(project);
		}
		catch(Exception exp) {
			throw new ProjectIdException("Project ID '"+project.getProjectIdentifier().toUpperCase()+"' already exists");
		}
	}
	
	
	public Project findProjectsByIdentifier(String projectId) {
		
		Project project =  projectrespoistory.findByProjectIdentifier(projectId.toUpperCase());
		
		if(project == null) {
			throw new ProjectIdException("Project ID '"+projectId+"' does not exist");
		}
		
		return project;
	}
	
	public Iterable<Project> findAllProjects(){
		
		return projectrespoistory.findAll();
		
		
	}
	
	
	public void deleteProject(String projectId) {
		
		Project project =  projectrespoistory.findByProjectIdentifier(projectId.toUpperCase());
		
		if(project == null) {
			
			throw new ProjectIdException("Project with ID '"+projectId+"' does not exist");
		}
		
		projectrespoistory.delete(project);
		
	}
	
	
	
	
	
}
