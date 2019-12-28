package com.mahe.rest.webservices.restfulwebservices.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {

	@GetMapping(path="/employee")
	public Employee retrieveEmployee(){
		
		Employee emp = new Employee("Mahe","Duraiswami",100000);
		
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("firstName","lastName");
		
		FilterProvider filters = new SimpleFilterProvider().addFilter("exclude-salary",filter);
	
		MappingJacksonValue mapping = new MappingJacksonValue(emp);

		mapping.setFilters(filters);
		
		return emp;
		
	}
	
	@GetMapping(path="/employee-list")
	public List<Employee> retrieveAllEmployees() {
		return Arrays.asList(new Employee("Mahe","Duraiswami",100000),new Employee("Shiva","Duraiswami",200000));
	}
}
