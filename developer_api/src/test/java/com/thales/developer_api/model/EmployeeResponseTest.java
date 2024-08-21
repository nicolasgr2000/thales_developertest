package com.thales.developer_api.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class EmployeeResponseTest {
    @Test
    void testEmployeeResponse() {
        EmployeeResponse response = new EmployeeResponse();
        response.setStatus("success");

        List<Employee> employees = new ArrayList<>();
        Employee employee = new Employee();
        employee.setId(1);
        employee.setEmployeeName("John Doe");
        employees.add(employee);

        response.setData(employees);
        response.setMessage("Successfully fetched data");

        assertEquals("success", response.getStatus());
        assertEquals(1, response.getData().size());
        assertEquals("John Doe", response.getData().get(0).getEmployeeName());
        assertEquals("Successfully fetched data", response.getMessage());
    }
}
