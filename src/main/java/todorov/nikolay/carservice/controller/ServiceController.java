package todorov.nikolay.carservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import todorov.nikolay.carservice.model.CarBrand;
import todorov.nikolay.carservice.model.ServiceType;

@RequestMapping("/service")
public interface ServiceController {
    @GetMapping("/cars/all/{serviceId}")
    String getAllCarsInCarServiceByServiceId(@PathVariable Long serviceId, Model model);

    @GetMapping("/cars/all/repair/{serviceId}")
    String getAllCarsInCarServiceForRepairByServiceId(@PathVariable Long serviceId, Model model);

    @GetMapping("/cars/all/brand/{serviceId}/{carBrand}")
    String getAllCarsInCarServiceForRepairByServiceIdAndCarBrand(
            @PathVariable Long serviceId, @PathVariable CarBrand carBrand, Model model);

    @GetMapping("/cars/all/type/{serviceId}/{serviceType}")
    String getAllCarsInCarServiceForRepairByServiceIdAndServiceType(
            @PathVariable Long serviceId, @PathVariable ServiceType serviceType, Model model);

    @GetMapping("/cars/all/year/{serviceId}/{yearOfManufacture}")
    String getAllCarsInCarServiceForRepairByServiceIdAndYearOfManufacture(
            @PathVariable Long serviceId, @PathVariable Long yearOfManufacture, Model model);

    @Transactional
    @PutMapping("/cars/repair/{id}/{price}")
    ResponseEntity<String> repairCar(@PathVariable Long id, @PathVariable Double price);

    @Transactional
    @PostMapping("/cars/service/{serviceId}/{carId}/{serviceType}")
    ResponseEntity<String> sendCarToService(
            @PathVariable Long serviceId, @PathVariable Long carId, @PathVariable ServiceType serviceType);

    @GetMapping("/cars/service/brand/{serviceId}/{carId}")
    Boolean canServiceWorkWithBrand(Long serviceId, Long carId);
}
