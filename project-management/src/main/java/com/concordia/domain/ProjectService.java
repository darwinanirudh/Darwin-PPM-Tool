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
			throw new ProjectIdExeption("Project ID '"+project.getProjectIdentifier().toUpperCase()+"' already exists");
		}
	}
	
	

}
