package todorov.nikolay.carservice.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import todorov.nikolay.carservice.controller.ServiceController;
import todorov.nikolay.carservice.model.CarBrand;
import todorov.nikolay.carservice.model.ServiceType;
import todorov.nikolay.carservice.service.ServiceCarService;

@Controller
public class ServiceControllerImpl implements ServiceController {
    @Autowired
    ServiceCarService serviceCarService;

    @Override
    public String getAllCarsInCarServiceByServiceId(Long serviceId, Model model) {
        return serviceCarService.getAllCarsInCarServiceByServiceId(serviceId, model);
    }

    @Override
    public String getAllCarsInCarServiceForRepairByServiceId(Long serviceId, Model model) {
        return serviceCarService.getAllCarsInCarServiceForRepairByServiceId(serviceId, model);
    }

    @Override
    public String getAllCarsInCarServiceForRepairByServiceIdAndCarBrand(Long serviceId, CarBrand carBrand, Model model) {
        return serviceCarService.getAllCarsInCarServiceForRepairByServiceIdAndCarBrand(serviceId, carBrand, model);
    }

    @Override
    public String getAllCarsInCarServiceForRepairByServiceIdAndServiceType(Long serviceId, ServiceType serviceType, Model model) {
        return serviceCarService.getAllCarsInCarServiceForRepairByServiceIdAndServiceType(serviceId, serviceType, model);
    }

    @Override
    public String getAllCarsInCarServiceForRepairByServiceIdAndYearOfManufacture(Long serviceId, Long yearOfManufacture, Model model) {
        return serviceCarService.getAllCarsInCarServiceForRepairByServiceIdAndYearOfManufacture(serviceId, yearOfManufacture, model);
    }

    @Override
    public ResponseEntity<String> repairCar(Long id, Double price) {
        return serviceCarService.repairCar(id, price);
    }

    @Override
    public ResponseEntity<String> sendCarToService(Long serviceId, Long carId, ServiceType serviceType) {
        return serviceCarService.sendCarToService(serviceId, carId, serviceType);
    }

    @Override
    public Boolean canServiceWorkWithBrand(Long serviceId, Long carId) {
        return serviceCarService.canServiceWorkWithBrand(serviceId, carId);
    }
}