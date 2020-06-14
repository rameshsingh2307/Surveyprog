package com.jrp.pma.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.jrp.pma.dto.ProjectCount;
import com.jrp.pma.entities.Project;

public interface ProjectRepository extends CrudRepository<Project, Long>{
	@Override
	public List<Project> findAll();
	@Query(nativeQuery = true, value="select stage as stage, count(stage) as projectCount from project group by stage")
	public List<ProjectCount> projectCount();
}
