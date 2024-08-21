package com.thales.developer_api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents an employee in the system.
 * <p>
 * This class holds details about an employee including their ID, name, salary, age, profile image,
 * and annual salary. It provides getter and setter methods to access and modify these attributes.
 * </p>
 */
public class Employee {

    /**
     * The unique identifier of the employee.
     */
    @JsonProperty("id")
    private int id;

    /**
     * The name of the employee.
     */
    @JsonProperty("employee_name")
    private String employeeName;

    /**
     * The monthly salary of the employee.
     */
    @JsonProperty("employee_salary")
    private int employeeSalary;

    /**
     * The age of the employee.
     */
    @JsonProperty("employee_age")
    private int employeeAge;

    /**
     * The URL or path to the profile image of the employee.
     */
    @JsonProperty("profile_image")
    private String profileImage;

    /**
     * The annual salary of the employee, calculated as monthly salary multiplied by 12.
     */
    @JsonProperty("employee_anual_salary")
    private double employeeAnualSalary;

    /**
     * Gets the unique identifier of the employee.
     *
     * @return the unique identifier of the employee
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the unique identifier of the employee.
     *
     * @param id the unique identifier to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the name of the employee.
     *
     * @return the name of the employee
     */
    public String getEmployeeName() {
        return employeeName;
    }

    /**
     * Sets the name of the employee.
     *
     * @param employeeName the name to set
     */
    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    /**
     * Gets the monthly salary of the employee.
     *
     * @return the monthly salary of the employee
     */
    public int getEmployeeSalary() {
        return employeeSalary;
    }

    /**
     * Sets the monthly salary of the employee.
     *
     * @param employeeSalary the salary to set
     */
    public void setEmployeeSalary(int employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    /**
     * Gets the age of the employee.
     *
     * @return the age of the employee
     */
    public int getEmployeeAge() {
        return employeeAge;
    }

    /**
     * Sets the age of the employee.
     *
     * @param employeeAge the age to set
     */
    public void setEmployeeAge(int employeeAge) {
        this.employeeAge = employeeAge;
    }

    /**
     * Gets the profile image of the employee.
     *
     * @return the profile image URL or path of the employee
     */
    public String getProfileImage() {
        return profileImage;
    }

    /**
     * Sets the profile image of the employee.
     *
     * @param profileImage the profile image URL or path to set
     */
    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    /**
     * Gets the annual salary of the employee.
     * <p>
     * This is calculated as the monthly salary multiplied by 12.
     * </p>
     *
     * @return the annual salary of the employee
     */
    public double getEmployeeAnualSalary() {
        return employeeAnualSalary;
    }

    /**
     * Sets the annual salary of the employee.
     *
     * @param employeeAnualSalary the annual salary to set
     */
    public void setEmployeeAnualSalary(double employeeAnualSalary) {
        this.employeeAnualSalary = employeeAnualSalary;
    }
}