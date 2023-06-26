package todorov.nikolay.carservice.service;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

public interface EmployeeService {
    String indexPage(@PathVariable Long employeeId, Model model);
}
