package com.jrp.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jrp.pma.dao.EmployeeRepository;
import com.jrp.pma.dao.ProjectRepository;
import com.jrp.pma.dto.ProjectCount;
import com.jrp.pma.entities.Employee;
import com.jrp.pma.entities.Project;

@Controller
@RequestMapping("/projects")
public class ProjectController {
	@Autowired
	ProjectRepository proResp;
	
	@Autowired
	EmployeeRepository empRepo;
	
	@GetMapping
	public String displayProject(Model model)
	{
		List<Project> project = proResp.findAll();
		model.addAttribute("project",project);
		return "Project/project-list";
	}
	@RequestMapping("/new")
	public String projectForm(Model model)
	{
		Project projectOne = new Project();
		List <Employee> employees = empRepo.findAll();
		model.addAttribute("project", projectOne);
		model.addAttribute("allEmployees", employees);
		return "Project/new-project";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String creatProject(Project project, Model model)
	{
			//this method will handle saving..
		proResp.save(project);
		
		
		return "redirect:/projects/new";
	}		
}
