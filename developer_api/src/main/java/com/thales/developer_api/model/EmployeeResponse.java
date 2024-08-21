package com.thales.developer_api.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;

import java.util.List;

/**
 * Represents the response structure for employee-related API calls.
 * <p>
 * This class models the JSON response structure from the employee API, including the status of the request,
 * the list of {@link Employee} objects, and a message detailing the result.
 * </p>
 */
@Data
public class EmployeeResponse {

    /**
     * The status of the API response, typically indicating success or failure.
     */
    private String status;

    /**
     * A list of {@link Employee} objects or a single {@link Employee} object, deserialized using
     * {@link EmployeeOrListDeserializer}.
     * <p>
     * This field can be either a list of employees or a single employee depending on the API response.
     * </p>
     */
    @JsonDeserialize(using = EmployeeOrListDeserializer.class)
    private List<Employee> data;

    /**
     * A message providing additional information about the API response, such as error details or success confirmation.
     */
    private String message;
}