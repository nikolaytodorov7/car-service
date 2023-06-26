package todorov.nikolay.carservice.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import todorov.nikolay.carservice.controller.EmployeeController;
import todorov.nikolay.carservice.service.EmployeeService;

@Controller
public class EmployeeControllerImpl implements EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @Override
    public String indexPage(Long employeeId, Model model) {
        return employeeService.indexPage(employeeId, model);
    }
}
