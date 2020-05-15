package com.concordia.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {
	
	@Autowired
	private ProjectRepository projectrespoistory;
	
	
	public Project saveOrUpdate(Project project) {
		
		return projectrespoistory.save(project);
	
	}
	
	

}
