package todorov.nikolay.carservice.service;

import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import todorov.nikolay.carservice.model.CarBrand;
import todorov.nikolay.carservice.model.ServiceType;

public interface ServiceCarService {
    String getAllCarsInCarServiceByServiceId(Long serviceId, Model model);

    String getAllCarsInCarServiceForRepairByServiceId(Long serviceId, Model model);

    String getAllCarsInCarServiceForRepairByServiceIdAndCarBrand(Long serviceId, CarBrand carBrand, Model model);

    String getAllCarsInCarServiceForRepairByServiceIdAndServiceType(Long serviceId, ServiceType serviceType, Model model);

    String getAllCarsInCarServiceForRepairByServiceIdAndYearOfManufacture(Long serviceId, Long yearOfManufacture, Model model);

    ResponseEntity<String> repairCar(Long id, Double price);

    ResponseEntity<String> sendCarToService(Long serviceId, Long carId, ServiceType serviceType);

    Boolean canServiceWorkWithBrand(Long serviceId, Long carId);
}
