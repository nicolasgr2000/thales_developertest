package com.thales.developer_api.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EmployeeTest {
    @Test
    void testEmployeeConstructorAndGetters() {
        Employee employee = new Employee();
        employee.setId(1);
        employee.setEmployeeName("John Doe");
        employee.setEmployeeSalary(50000);
        employee.setEmployeeAge(30);
        employee.setProfileImage("profile.jpg");

        assertEquals(1, employee.getId());
        assertEquals("John Doe", employee.getEmployeeName());
        assertEquals(50000, employee.getEmployeeSalary());
        assertEquals(30, employee.getEmployeeAge());
        assertEquals("profile.jpg", employee.getProfileImage());
    }
}
