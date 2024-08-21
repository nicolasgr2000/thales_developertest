package com.thales.developer_api.repository;

import com.thales.developer_api.model.Employee;
import com.thales.developer_api.model.EmployeeResponse;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Repository class for accessing employee data from the external REST API.
 * <p>
 * This class uses {@link RestTemplate} to make HTTP requests to the external employee API and
 * process the responses into {@link Employee} objects.
 * </p>
 */
@Repository
public class EmployeeRepository {

    private final RestTemplate restTemplate;

    private static final String BASE_URL = "http://dummy.restapiexample.com/api/v1";

    /**
     * Initializes a new instance of the {@link EmployeeRepository} class with a new {@link RestTemplate}.
     */
    public EmployeeRepository() {
        this.restTemplate = new RestTemplate();
    }

    /**
     * Retrieves a list of all employees from the external API.
     * <p>
     * Sends an HTTP GET request to the "/employees" endpoint and parses the response into a list of {@link Employee} objects.
     * </p>
     *
     * @return A list of {@link Employee} objects representing all employees retrieved from the API.
     */
    public List<Employee> getAllEmployees() {
        String url = BASE_URL + "/employees";
        EmployeeResponse response = restTemplate.getForObject(url, EmployeeResponse.class);
        return response.getData();
    }

    /**
     * Retrieves an employee by ID from the external API.
     * <p>
     * Sends an HTTP GET request to the "/employee/{id}" endpoint with the specified employee ID and parses the response
     * into a single {@link Employee} object.
     * </p>
     *
     * @param id The ID of the employee to retrieve.
     * @return An {@link Employee} object representing the employee with the specified ID, or {@code null} if not found.
     */
    public Employee getEmployeeById(int id) {
        String url = BASE_URL + "/employee/" + id;
        EmployeeResponse response = restTemplate.getForObject(url, EmployeeResponse.class);
        return response.getData().get(0);
    }
}