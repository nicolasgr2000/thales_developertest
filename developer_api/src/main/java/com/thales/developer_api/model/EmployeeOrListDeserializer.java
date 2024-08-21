package com.thales.developer_api.model;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Custom deserializer for {@link List<Employee>} that handles both single {@link Employee}
 * objects and arrays of {@link Employee} objects.
 * <p>
 * This deserializer allows the deserialization of JSON responses where the "data" field can be either
 * a single {@link Employee} object or a list of {@link Employee} objects.
 * </p>
 */
public class EmployeeOrListDeserializer extends JsonDeserializer<List<Employee>> {

    /**
     * Deserializes JSON content into a list of {@link Employee} objects.
     *
     * <p>
     * If the JSON content is an array, it is deserialized into a list of {@link Employee} objects.
     * If the JSON content is a single object, it is deserialized into a list containing a single {@link Employee} object.
     * </p>
     *
     * @param p the parser used to read the JSON content
     * @param ctxt the deserialization context
     * @return a list of {@link Employee} objects
     * @throws IOException if an I/O error occurs or the content is not valid JSON
     */
    @Override
    public List<Employee> deserialize(JsonParser p, DeserializationContext ctxt)
            throws IOException {

        JsonNode node = p.getCodec().readTree(p);
        List<Employee> employees = new ArrayList<>();

        if (node.isArray()) {
            for (JsonNode item : node) {
                employees.add(p.getCodec().treeToValue(item, Employee.class));
            }
        } else if (node.isObject()) {
            employees.add(p.getCodec().treeToValue(node, Employee.class));
        }

        return employees;
    }
}