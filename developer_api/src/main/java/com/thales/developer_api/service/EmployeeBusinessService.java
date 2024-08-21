package com.thales.developer_api.service;

import com.thales.developer_api.model.Employee;
import org.springframework.stereotype.Component;

/**
 * Business logic class for calculating employee-related information.
 * <p>
 * This class contains business logic related to employee data processing,
 * such as calculating the annual salary.
 * </p>
 */
@Component
public class EmployeeBusinessService {

    /**
     * Calculates the annual salary for a given employee.
     *
     * @param employee the employee for whom the annual salary needs to be calculated
     * @return the employee with updated annual salary
     */
    public Employee calculateAnnualSalary(Employee employee) {
        if (employee != null) {
            double annualSalary = employee.getEmployeeSalary() * 12;
            employee.setEmployeeAnualSalary(annualSalary);
        }
        return employee;
    }
}
