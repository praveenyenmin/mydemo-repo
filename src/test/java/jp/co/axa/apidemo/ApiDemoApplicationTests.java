//package jp.co.axa.apidemo;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.when;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import jp.co.axa.apidemo.controllers.EmployeeController;
//import jp.co.axa.apidemo.entities.Employee;
//import jp.co.axa.apidemo.service.EmployeeService;
//
//@ExtendWith(MockitoExtension.class)
//public class ApiDemoApplicationTests {
//
//	@InjectMocks
//	private EmployeeController employeeController;
//
//	@Mock
//	EmployeeService employeeService;
//
//	@BeforeEach
//	void setUp() {
//
//	}
//
//	@Test
//	private void getEmployeesTest() {
//		List<Employee> expectedEmpTest = getEmployeeList();
//
//		when(employeeService.retrieveEmployees()).thenReturn(expectedEmpTest);
//		List<Employee> empTest = employeeController.getEmployees();
//		assertEquals(empTest.size(), expectedEmpTest.size());
//	}
//
//	@Test
//	private void saveEmployeeTest() {
//		Employee expectedEmpTest = getEmployeeList().get(0);
//
//		when(employeeService.saveEmployee(any())).doReturn("Entity Saved");
//		String message = employeeController.saveEmployee(expectedEmpTest);
//		assertEquals(message, "Entity Saved");
//
//	}
//
//	@Test
//	private void deleteEmployeeTest() {
//		Employee expectedEmpTest = getEmployeeList().get(0);
//
//		when(employeeService.deleteEmployee(any())).doReturn("Entity Removed");
//		String message = employeeController.deleteEmployee(1L);
//		assertEquals(message, "Entity Removed");
//
//	}
//
//	@Test
//	private void updateEmployeeTest() {
//		Employee expectedEmpTest = getEmployeeList().get(0);
//
//		when(employeeService.getEmployee(any())).doReturn(expectedEmpTest);
//		when(employeeService.updateEmployee(any())).doReturn("Entity Updated");
//
//		String message = employeeController.updateEmployee(expectedEmpTest);
//		assertEquals(message, "Entity Updated");
//	}
//
//	private List<Employee> getEmployeeList() {
//		Employee empObjl = new Employee();
//		empObjl.setName("Chandru");
//		Employee empObj2 = new Employee();
//		empObj2.setName("Praveen");
//		List<Employee> empTest = new ArrayList<Employee>();
//		empTest.add(empObjl);
//		empTest.add(empObj2);
//		return empTest;
//	}
//}