package com.thales.developer_api.controller;

import com.thales.developer_api.model.Employee;
import com.thales.developer_api.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

/**
 * Controller class for managing employee-related RESTful web services.
 * <p>
 * This class is responsible for handling HTTP requests related to employees,
 * delegating the actual processing to the {@link EmployeeService} class.
 * It provides endpoints to retrieve a list of all employees or to fetch details
 * of a specific employee by their ID.
 * </p>
 * <p>
 * Endpoints:
 * <ul>
 *     <li><code>GET /api/employees</code> - Retrieves a list of all employees.</li>
 *     <li><code>GET /api/employee/{id}</code> - Retrieves details of a specific employee by ID.</li>
 * </ul>
 * </p>
 */
@RestController
@RequestMapping("/api")
public class EmployeeController {

    private final EmployeeService employeeService;

    /**
     * Constructs a new {@link EmployeeController} instance with the specified {@link EmployeeService}.
     *
     * @param employeeService the service used to manage employee data
     */
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    /**
     * Handles HTTP GET requests to retrieve a list of all employees.
     *
     * @return a {@link ResponseEntity} containing a {@link List} of {@link Employee} objects representing all employees
     */
    @GetMapping("/employees")
    public ResponseEntity<Object> getAllEmployees() {
        try {
            List<Employee> employees = employeeService.getAllEmployees();
            if (employees.isEmpty()) {
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(employees);
        } catch (HttpClientErrorException e) {
            return handleHttpClientErrorException(e);
        } catch (Exception e) {
            return handleGenericException(e);
        }
    }

    /**
     * Handles HTTP GET requests to retrieve details of a specific employee by their ID.
     *
     * @param id the ID of the employee to retrieve
     * @return a {@link ResponseEntity} containing an {@link Employee} object representing the employee with the specified ID
     */
    @GetMapping("/employee/{id}")
    public ResponseEntity<Object> getEmployeeById(@PathVariable int id) {
        try {
            Employee employee = employeeService.getEmployeeById(id);
            if (employee == null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(employee);
        } catch (HttpClientErrorException e) {
            return handleHttpClientErrorException(e);
        } catch (Exception e) {
            return handleGenericException(e);
        }
    }

    /**
     * Handles {@link HttpClientErrorException} and returns an appropriate response.
     *
     * @param e the exception to handle
     * @return a {@link ResponseEntity} with an error message and appropriate HTTP status code
     */
    private ResponseEntity<Object> handleHttpClientErrorException(HttpClientErrorException e) {
        if (e.getStatusCode() == HttpStatus.TOO_MANY_REQUESTS) {
            return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS)
                    .body("Too many requests. Please try again later.");
        }
        return ResponseEntity.status(e.getStatusCode()).body(e.getResponseBodyAsString());
    }

    /**
     * Handles generic exceptions and returns a response with a 500 Internal Server Error status.
     *
     * @param e the exception to handle
     * @return a {@link ResponseEntity} with an error message and a 500 Internal Server Error status code
     */
    private ResponseEntity<Object> handleGenericException(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("An unexpected error occurred: " + e.getMessage());
    }
}