package com.jrp.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jrp.pma.entities.Employee;
import com.jrp.pma.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	//@Autowired
	//EmployeeRepository empResp;
	@Autowired
	EmployeeService empServ;
	@GetMapping
	public String employeeDisplay(Model model)
	{
		List<Employee> emp = empServ.findAll();
		model.addAttribute("employee", emp);
		return "/Employees/employee-list";
	}
	@RequestMapping(value="/emp", method=RequestMethod.POST)
	public String employeeForm()
	{
		return "";
	}
	
	@RequestMapping("/new")
	public String employeeForm(Model model)
	{
		Employee emp = new Employee();
		model.addAttribute("emp", emp);
		return "Employees/employeeForm";
	}
	@RequestMapping("/saveEmp")
	public String createEmp(Employee emp)
	{
		empServ.save(emp);
		return "redirect:/employee/new";
	}
	System.out.println("This is modified");
}
