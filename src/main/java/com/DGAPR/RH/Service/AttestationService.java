package com.DGAPR.RH.Service;
import com.DGAPR.RH.Model.Attestation;
import com.DGAPR.RH.Model.Employee;
import com.DGAPR.RH.repository.AttestationRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AttestationService {
    // EmployeeService employeeService = this.employeeService;
    //private final EmployeeService employeeService;

    public AttestationService(AttestationRepository attestationRepository) {

    }

    public void generateAttestation(Attestation attestation, Long employeeId) {

        if (employeeId == null) {
            throw new IllegalArgumentException("Employee ID cannot be null");
        }
        if (attestation == null) {
            throw new IllegalArgumentException("Attestation cannot be null");
        }


        // Retrieve the employee by ID
        Employee employee = EmployeeService.getEmployeeById(employeeId);
        if (employee != null) {
            // Set the employee details in the attestation
            attestation.setEmployee(employee);
            attestation.setDate(new Date());
            // Save the attestation to the repository
            AttestationRepository.save(attestation);
        } else {
            throw new IllegalArgumentException("Employee not found with ID: " + employeeId);
        }

        throw new IllegalStateException("EmployeeService is not initialized");
    }


}
