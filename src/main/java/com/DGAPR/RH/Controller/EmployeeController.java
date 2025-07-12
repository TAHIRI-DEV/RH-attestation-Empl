
package com.DGAPR.RH.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import com.DGAPR.RH.Model.Employee;
import com.DGAPR.RH.Service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    // private EmployeeService employeeService;

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "employee/create";
    }

    @PostMapping("/create")
    public String createEmployee(@ModelAttribute Employee employee, Model model) {
        // employeeService.saveEmployee(employee);
        model.addAttribute("message", "Employee created successfully!");
        return "redirect:/employees/list";
    }

    @GetMapping("/list")
    public String listEmployees(Model model) {
        model.addAttribute("employees", employeeService.getAllEmployees());
        return "employee/list";
    }

    @GetMapping("/edit")
    public String showEditForm(@ModelAttribute("id") Long id, Model model) {
        Employee employee = employeeService.getEmployeeById(id);
        model.addAttribute("employee", employee);
        return "employee/edit";
    }

    @PostMapping("/edit")
    public String updateEmployee(@ModelAttribute Employee employee, Model model) {
        employeeService.updateEmployee(employee);
        model.addAttribute("message", "Employee updated successfully!");
        return "redirect:/employees/list";
    }

    @GetMapping("/delete")
    public String deleteEmployee(@ModelAttribute("id") Long id, Model model) {
        employeeService.deleteEmployee(id);
        model.addAttribute("message", "Employee deleted successfully!");
        return "redirect:/employees/list";
    }

    @GetMapping("/view")
    public String viewEmployee(@ModelAttribute("id") Long id, Model model) {
        Employee employee = employeeService.getEmployeeById(id);
        model.addAttribute("employee", employee);
        return "employee/view";
    }
}