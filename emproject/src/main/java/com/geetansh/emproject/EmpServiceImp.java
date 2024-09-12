package com.geetansh.emproject;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class EmpServiceImp implements EmpService {

    @Autowired
    private EmpRepository employeeRepository;

    @Override
    public String createEmployee(Employee employee) {
        try {
            EmpEntity employeeEntity = new EmpEntity();
            BeanUtils.copyProperties(employee, employeeEntity);
            employeeRepository.save(employeeEntity);
            return "Saved Successfully";
        } catch (Exception e) {
            e.printStackTrace();  // Log the exception
            return "Error: " + e.getMessage();
        }
    }

    @Override
    public List<Employee> readEmployees() {
        try {
            List<EmpEntity> employeesList = employeeRepository.findAll();
            List<Employee> employees = new ArrayList<>();
            for (EmpEntity employeeEntity : employeesList) {
                Employee emp = new Employee();
                BeanUtils.copyProperties(employeeEntity, emp);
                employees.add(emp);
            }
            return employees;
        } catch (Exception e) {
            e.printStackTrace();  // Log the exception
            return Collections.emptyList();
        }
    }

    @Override
    public boolean deleteEmployee(Long id) {
        try {
            if (employeeRepository.existsById(id)) {
                employeeRepository.deleteById(id);
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();  // Log the exception
            return false;
        }
    }

    @Override
    public String updateEmployee(Long id, Employee employee) {
        try {
            if (employeeRepository.existsById(id)) {
                EmpEntity existingEmployee = employeeRepository.findById(id).get();
                BeanUtils.copyProperties(employee, existingEmployee, "id");
                employeeRepository.save(existingEmployee);
                return "Update Successfully";
            }
            return "Not Found";
        } catch (Exception e) {
            e.printStackTrace();  // Log the exception
            return "Error: " + e.getMessage();
        }
    }
}
