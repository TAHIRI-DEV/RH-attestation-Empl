package com.DGAPR.RH.Controller;
import com.DGAPR.RH.Model.Attestation;
import com.DGAPR.RH.Service.AttestationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/attestations")
public class AttestationController {
    @Autowired
    private AttestationService attestationService;

//  @Autowired
//    private EmployeeService employeeService;

    @GetMapping("/generate/{employeeId}")
    public String showAttestationForm(@PathVariable Long employeeId, Model model) {
        Attestation attestation = new Attestation();
        model.addAttribute("attestation", attestation);
        model.addAttribute("employeeId", employeeId);
        return "attestations/generate";
    }

    @PostMapping("/generate/{employeeId}")
    public String generateAttestation(
            @PathVariable Long employeeId,
            @ModelAttribute Attestation attestation) {
        attestationService.generateAttestation(attestation, employeeId);
        return "redirect:/employees/" + employeeId;
    }
}