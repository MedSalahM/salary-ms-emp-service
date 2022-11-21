package com.mms.empsfp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mms.empsfp.model.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, Long>{

	
	@Query(nativeQuery = true,value = "select * from employee order by id desc limit 15")
	List<Employee> latest();
	
}
