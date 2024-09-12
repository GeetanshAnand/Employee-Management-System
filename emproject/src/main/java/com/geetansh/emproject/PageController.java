package com.geetansh.emproject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {

    @GetMapping("/employee_list")
    public String showEmployeeList() {
        return "employee_list";  // Make sure this matches the name of your HTML file in the templates directory
    }

    @GetMapping("/add_employee")
    public String showAddEmployeeForm() {
        return "add_employee";  // Make sure this matches the name of your HTML file in the templates directory
    }

    @GetMapping("/edit_employee")
    public String showEditEmployeeForm(@RequestParam Long id, Model model) {
        model.addAttribute("employeeId", id);
        return "edit_employee";  // Make sure this matches the name of your HTML file in the templates directory
    }

    @GetMapping("/about_project")
    public String aboutProject() {
        return "about_project"; // This refers to about_project.html in the templates folder
    }
}
