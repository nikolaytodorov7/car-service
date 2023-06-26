package todorov.nikolay.carservice.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import todorov.nikolay.carservice.controller.ClientController;
import todorov.nikolay.carservice.model.Car;
import todorov.nikolay.carservice.service.ClientService;

@Controller
public class ClientControllerImpl implements ClientController {
    @Autowired
    ClientService clientService;

    @Override
    public String indexPage(Long clientId, Model model) {
        return clientService.indexPage(clientId, model);
    }

    @Override
    public String getCars(Long clientId, Model model) {
        return clientService.getCars(clientId, model);
    }

    @Override
    public ResponseEntity<String> deleteCar(Long carId) {
        return clientService.deleteCar(carId);
    }

    @Override
    public void buyCar(Long clientId, Car car) {
        clientService.buyCar(clientId, car);
    }
}
