package jp.co.axa.apidemo.service;

import org.springframework.http.ResponseEntity;

import jp.co.axa.apidemo.entities.Employee;
import jp.co.axa.apidemo.valueobjects.GenericResponse;

public interface EmployeeService {

	public ResponseEntity<GenericResponse> retrieveEmployees();

	public ResponseEntity<GenericResponse> getEmployee(Long employeeId);

	public ResponseEntity<GenericResponse> saveEmployee(Employee employee);

	public ResponseEntity<GenericResponse> deleteEmployee(Long employeeId);

	public ResponseEntity<GenericResponse> updateEmployee(Employee employee, Long employeeId);
}