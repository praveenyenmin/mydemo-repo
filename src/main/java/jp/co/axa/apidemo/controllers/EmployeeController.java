package jp.co.axa.apidemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jp.co.axa.apidemo.entities.Employee;
import jp.co.axa.apidemo.service.EmployeeService;
import jp.co.axa.apidemo.valueobjects.GenericResponse;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@GetMapping("/employees")
	public ResponseEntity<GenericResponse> getEmployees() {
		 
		return employeeService.retrieveEmployees();
	}

	@GetMapping("/employees/{employeeId}")
	public ResponseEntity<GenericResponse> getEmployee(@PathVariable(name = "employeeId") Long employeeId) {
		return employeeService.getEmployee(employeeId);
	}

	@PostMapping("/employees")
	public ResponseEntity<GenericResponse> saveEmployee(Employee employee) {
		return employeeService.saveEmployee(employee);
	}

	@DeleteMapping("/employees/{employeeId}")
	public ResponseEntity<GenericResponse> deleteEmployee(@PathVariable(name = "employeeId") Long employeeId) {
		return employeeService.deleteEmployee(employeeId);
	}

	@PutMapping("/employees/{employeeId}")
	public ResponseEntity<GenericResponse> updateEmployee(@RequestBody Employee employee, @PathVariable(name = "employeeId") Long employeeId) {
		return employeeService.updateEmployee(employee, employeeId);

	}

}
