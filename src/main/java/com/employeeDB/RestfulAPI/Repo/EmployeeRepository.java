package com.employeeDB.RestfulAPI.Repo;
import com.employeeDB.RestfulAPI.entity.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeRepository extends MongoRepository<Employee, String> {
    Employee findByEmployeeId(String employeeId);
}
