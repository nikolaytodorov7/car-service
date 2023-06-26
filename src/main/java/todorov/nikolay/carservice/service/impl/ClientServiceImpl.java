package todorov.nikolay.carservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import todorov.nikolay.carservice.model.Car;
import todorov.nikolay.carservice.model.CarDTO;
import todorov.nikolay.carservice.model.CarService;
import todorov.nikolay.carservice.repository.CarRepository;
import todorov.nikolay.carservice.repository.CarServiceRepository;
import todorov.nikolay.carservice.service.ClientService;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {
    private static final String CLIENT_CARS_TEMPLATE = "client-cars";
    private static final String INDEX_CARS_TEMPLATE = "index-client";
    private static final String SERVICES_ATTRIBUTE = "services";
    private static final String CARS_ATTRIBUTE = "cars";
    private static final String SERVICE_TYPES_ATTRIBUTE = "serviceTypes";

    @Autowired
    CarRepository carRepository;

    @Autowired
    CarServiceRepository carServiceRepository;

    @Override
    public String indexPage(Long clientId, Model model) {
        List<Car> cars = carRepository.getAllCarsByClientId(clientId);
        List<CarService> services = carServiceRepository.getAllServices();
        model.addAttribute(CARS_ATTRIBUTE, cars);
        model.addAttribute(SERVICES_ATTRIBUTE, services);
        return INDEX_CARS_TEMPLATE;
    }

    @Override
    public String getCars(Long clientId, Model model) {
        List<Car> cars = carRepository.getAllCarsByClientId(clientId);
        List<CarService> services = carServiceRepository.getAllServices();
        List<String> serviceTypes = carServiceRepository.getAllServiceTypes();
        model.addAttribute(CARS_ATTRIBUTE, cars);
        model.addAttribute(SERVICES_ATTRIBUTE, services);
        model.addAttribute(SERVICE_TYPES_ATTRIBUTE, serviceTypes);
        return CLIENT_CARS_TEMPLATE;
    }

    @Override
    public ResponseEntity<String> deleteCar(Long carId) {
        carRepository.deleteCarById(carId);
        return ResponseEntity.ok("Car deleted successfully.");
    }

    @Override
    public void buyCar(Long clientId, Car car) {
        Long carBrandId = carRepository.getCarBrandIdByName(car.getBrand().name());
        CarDTO carDTO = new CarDTO(car, carBrandId, clientId);
        carRepository.insertCar(carDTO);
    }
}
