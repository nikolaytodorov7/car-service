package todorov.nikolay.carservice.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/employee")
public interface EmployeeController {
    @GetMapping("/{employeeId}")
    String indexPage(@PathVariable Long employeeId, Model model);
}
