package com.jrp.pma.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jrp.pma.dao.EmployeeRepository;
import com.jrp.pma.dto.EmployeeProject;
import com.jrp.pma.entities.Employee;

@Service
public class EmployeeService {
	@Autowired
	EmployeeRepository empResp;
	
	public Employee save(Employee emp)
	{
		return empResp.save(emp);
	}
	
	public List<Employee> findAll()
	{
		return empResp.findAll();
	}
	
	public List<EmployeeProject> employeeProject()
	{
		return empResp.employeeProjects();
	}
}
