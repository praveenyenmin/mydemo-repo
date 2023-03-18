package jp.co.axa.apidemo.service.impl;

import jp.co.axa.apidemo.constant.ApplicationConstant;
import jp.co.axa.apidemo.entities.Employee;
import jp.co.axa.apidemo.repositories.EmployeeRepository;
import jp.co.axa.apidemo.service.EmployeeService;
import jp.co.axa.apidemo.valueobjects.GenericResponse;
import jp.co.axa.apidemo.valueobjects.Library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public void setEmployeeRepository(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	public ResponseEntity<GenericResponse> retrieveEmployees() {
		List<Employee> employees = employeeRepository.findAll();
		return ResponseEntity.status(HttpStatus.OK)
				.body(Library.recordResponse(ApplicationConstant.RECORD_FOUND, employees));
	}

	public ResponseEntity<GenericResponse> getEmployee(Long employeeId) {
		Optional<Employee> optEmp = employeeRepository.findById(employeeId);
		return ResponseEntity.status(HttpStatus.OK)
				.body(Library.recordResponse(ApplicationConstant.RECORD_FOUND, optEmp.get()));
	}

	public ResponseEntity<GenericResponse> saveEmployee(Employee employee) {
		employeeRepository.save(employee);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(Library.messageResponse(ApplicationConstant.RECORD_CREATED));
	}

	public ResponseEntity<GenericResponse> deleteEmployee(Long employeeId) {
		employeeRepository.deleteById(employeeId);
		return ResponseEntity.status(HttpStatus.OK)
				.body(Library.messageResponse(ApplicationConstant.RECORD_DELETE));
	}

	public ResponseEntity<GenericResponse> updateEmployee(Employee employee, Long employeeId) {
		Optional<Employee> optEmp = employeeRepository.findById(employeeId);
		if (optEmp.isPresent()) {
			employeeRepository.save(employee);
			return ResponseEntity.status(HttpStatus.OK)
					.body(Library.messageResponse(ApplicationConstant.RECORD_UPDATE));
		}
		return ResponseEntity.status(HttpStatus.OK)
				.body(Library.messageResponse(ApplicationConstant.NO_RECORD));
	}
}