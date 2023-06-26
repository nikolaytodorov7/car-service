package todorov.nikolay.carservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import todorov.nikolay.carservice.model.CarService;
import todorov.nikolay.carservice.repository.CarServiceRepository;
import todorov.nikolay.carservice.service.EmployeeService;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private static final String SERVICES_ATTRIBUTE = "services";
    private static final String INDEX_EMPLOYEE_TEMPLATE = "index-employee";

    @Autowired
    CarServiceRepository carServiceRepository;

    @Override
    public String indexPage(Long employeeId, Model model) {
        List<CarService> services = carServiceRepository.getAvailableCarServicesByEmployeeId(employeeId);
        model.addAttribute(SERVICES_ATTRIBUTE, services);
        return INDEX_EMPLOYEE_TEMPLATE;
    }
}
