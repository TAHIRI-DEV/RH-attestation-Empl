package com.DGAPR.RH.Service;
import com.DGAPR.RH.Model.Employee;
import com.DGAPR.RH.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmployeeService {
    @Autowired
    private  final EmployeeRepository employeeRepository ;

    public EmployeeService() {
        this.employeeRepository = null; // This will be overridden by Spring's dependency injection
    }
    // Constructor injection for EmployeeRepository
    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public void saveEmployee(Employee employee) {
        assert employeeRepository != null;
        employeeRepository.save(employee);
    }

    public  Employee getEmployeeById(Long id) {
        assert employeeRepository != null;
        return employeeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Employee not found with id: " + id));

    }

    public Object getAllEmployees() {
        assert employeeRepository != null;
        return employeeRepository.findAll();
    }
    public void deleteEmployee(Long id) {
        assert employeeRepository != null;
        employeeRepository.deleteById(id);
    }
    public void updateEmployee(Employee employee) {
        assert employeeRepository != null;
        employeeRepository.save(employee);
    }

    public EmployeeRepository getEmployeeRepository() {
        return employeeRepository;
    }




}
