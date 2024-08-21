package com.thales.developer_api.service;

import com.thales.developer_api.model.Employee;
import com.thales.developer_api.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class for managing employee-related business logic.
 * <p>
 * This service class is responsible for handling business operations related to employees
 * by interacting with the {@link EmployeeRepository}. It provides methods to retrieve
 * a list of all employees and to fetch details of a specific employee by their ID.
 * </p>
 */
@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    /**
     * Constructs a new {@link EmployeeService} instance with the specified {@link EmployeeRepository}.
     *
     * @param employeeRepository the repository used to access employee data
     */
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    /**
     * Retrieves a list of all employees.
     *
     * @return a {@link List} of {@link Employee} objects representing all employees
     */
    public List<Employee> getAllEmployees() {
        List<Employee> employees = employeeRepository.getAllEmployees();
        employees.forEach(employee -> employee.setEmployeeAnualSalary(employee.getEmployeeSalary() * 12));
        return employees;
    }

    /**
     * Retrieves details of a specific employee by their ID.
     *
     * @param id the ID of the employee to retrieve
     * @return an {@link Employee} object representing the employee with the specified ID
     * @throws IllegalArgumentException if no employee with the specified ID is found
     */
    public Employee getEmployeeById(int id) {
        Employee employee = employeeRepository.getEmployeeById(id);
        if (employee != null) {
            employee.setEmployeeAnualSalary(employee.getEmployeeSalary() * 12);
        }
        return employee;
    }
}