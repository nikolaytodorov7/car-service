package todorov.nikolay.carservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import todorov.nikolay.carservice.model.*;
import todorov.nikolay.carservice.repository.CarRepository;
import todorov.nikolay.carservice.repository.CarServiceRepository;
import todorov.nikolay.carservice.service.ServiceCarService;

import java.util.List;
import java.util.Set;

@Service
public class ServiceCarServiceImpl implements ServiceCarService {
    private static final String CAR_SERVICINGS_ATTRIBUTE = "carServicings";
    private static final String TITLE_ATTRIBUTE = "title";
    private static final String SERVICE_CARS_LIST_TEMPLATE = "service-cars-list";

    @Autowired
    CarServiceRepository carServiceRepository;

    @Autowired
    CarRepository carRepository;

    @Override
    public String getAllCarsInCarServiceByServiceId(Long serviceId, Model model) {
        List<CarServicing> carServicings = carServiceRepository.getAllCarsInCarServiceByServiceId(serviceId);
        model.addAttribute(CAR_SERVICINGS_ATTRIBUTE, carServicings);
        model.addAttribute(TITLE_ATTRIBUTE, "All cars in service");
        return SERVICE_CARS_LIST_TEMPLATE;
    }

    @Override
    public String getAllCarsInCarServiceForRepairByServiceId(Long serviceId, Model model) {
        List<CarServicing> carServicings = carServiceRepository.getAllCarsInCarServiceForRepairByServiceId(serviceId);
        model.addAttribute(CAR_SERVICINGS_ATTRIBUTE, carServicings);
        model.addAttribute(TITLE_ATTRIBUTE, "All cars in service for repair");
        return SERVICE_CARS_LIST_TEMPLATE;
    }

    @Override
    public String getAllCarsInCarServiceForRepairByServiceIdAndCarBrand(Long serviceId, CarBrand carBrand, Model model) {
        List<CarServicing> carServicings = carServiceRepository.getAllCarsInCarServiceForRepairByServiceIdAndCarBrand(serviceId, carBrand);
        model.addAttribute(CAR_SERVICINGS_ATTRIBUTE, carServicings);
        model.addAttribute(TITLE_ATTRIBUTE, "All cars in service by car brand");
        return SERVICE_CARS_LIST_TEMPLATE;
    }

    @Override
    public String getAllCarsInCarServiceForRepairByServiceIdAndServiceType(Long serviceId, ServiceType serviceType, Model model) {
        List<CarServicing> carServicings = carServiceRepository.getAllCarsInCarServiceForRepairByServiceIdAndServiceType(serviceId, serviceType);
        model.addAttribute(CAR_SERVICINGS_ATTRIBUTE, carServicings);
        model.addAttribute(TITLE_ATTRIBUTE, "All cars in service by service type");
        return SERVICE_CARS_LIST_TEMPLATE;
    }

    @Override
    public String getAllCarsInCarServiceForRepairByServiceIdAndYearOfManufacture(Long serviceId, Long yearOfManufacture, Model model) {
        List<CarServicing> carServicings = carServiceRepository.getAllCarsInCarServiceForRepairByServiceIdAndYearOfManufacture(serviceId, yearOfManufacture);
        model.addAttribute(CAR_SERVICINGS_ATTRIBUTE, carServicings);
        model.addAttribute(TITLE_ATTRIBUTE, "All cars in service by year of manufacture");
        return SERVICE_CARS_LIST_TEMPLATE;
    }

    @Override
    public ResponseEntity<String> repairCar(Long id, Double price) {
        carRepository.repairCar(id, price);
        return ResponseEntity.ok("Car repaired successfully.");
    }

    @Override
    public ResponseEntity<String> sendCarToService(Long serviceId, Long carId, ServiceType serviceType) {
        Long serviceTypeId = carServiceRepository.getServiceTypeIdByName(serviceType.name());
        CarServicingDTO carServicingDTO = new CarServicingDTO(serviceId, carId, serviceTypeId, 0D, false);
        carRepository.sendCarToService(carServicingDTO);
        return ResponseEntity.ok("Car sent to service.");

    }

    @Override
    public Boolean canServiceWorkWithBrand(Long serviceId, Long carId) {
        Car carById = carRepository.getCarById(carId);
        Set<Long> brandsForService = carServiceRepository.getCarBrandsForServiceById(serviceId);
        Long carBrandId = carRepository.getCarBrandIdByName(carById.getBrand().name());
        return brandsForService.contains(carBrandId);
    }
}
