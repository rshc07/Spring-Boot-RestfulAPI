package com.employeeDB.RestfulAPI.entity;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

@Data
@Document(collection = "employees")
public class Employee {
    @Id
    private String id;
    private String employeeId;
    private String employeeName;
    private String employeeEmail;
    private String location;
}
