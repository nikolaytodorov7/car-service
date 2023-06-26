package todorov.nikolay.carservice.service;

import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import todorov.nikolay.carservice.model.Car;

public interface ClientService {
    String indexPage( Long clientId, Model model);

    String getCars( Long clientId, Model model);

    ResponseEntity<String> deleteCar( Long carId);

    void buyCar( Long clientId,  Car car);
}
