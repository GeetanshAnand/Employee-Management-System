package com.geetansh.emproject;

import java.util.List;

public interface EmpService {
    String createEmployee(Employee employee);
    List<Employee> readEmployees();
    boolean deleteEmployee(Long id);
    String updateEmployee(Long id, Employee employee);
}
