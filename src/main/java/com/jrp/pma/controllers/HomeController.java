package com.jrp.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jrp.pma.dao.EmployeeRepository;
import com.jrp.pma.dao.ProjectRepository;
import com.jrp.pma.dto.EmployeeProject;
import com.jrp.pma.dto.ProjectCount;
import com.jrp.pma.entities.Project;;
@Controller
public class HomeController {
	
	@Autowired
	ProjectRepository projRepso;
	
	@Autowired
	EmployeeRepository empRepso;
	
	@GetMapping("/")
	public String displayHome(Model model) throws JsonProcessingException
	{
		List<Project> project= projRepso.findAll();
		List<ProjectCount> projectData= projRepso.projectCount();
		ObjectMapper objectMapper = new ObjectMapper();
		String jasonString = objectMapper.writeValueAsString(projectData);
		List<EmployeeProject> employeeProjectCnt= empRepso.employeeProjects();
		model.addAttribute("projectStatusCnt", jasonString);
		model.addAttribute("project", project);
		model.addAttribute("employeeProjectCnt", employeeProjectCnt);
		return "Main/home";
	}
}
