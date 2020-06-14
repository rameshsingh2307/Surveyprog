package com.jrp.pma.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.jrp.pma.dto.EmployeeProject;
import com.jrp.pma.entities.Employee;
import com.jrp.pma.entities.Project;

public interface EmployeeRepository extends CrudRepository<Employee, Long>{
	@Override
	public List<Employee> findAll();	
	
	@Query(nativeQuery=true, value="select e.first_name as firstName, e.last_name as lastName, count(e.employee_id) as projectCount from employee e left join project_employee pe on e.employee_id=pe.employee_id group by e.first_name, e.last_name order by projectCount desc")
	public List<EmployeeProject> employeeProjects();
}