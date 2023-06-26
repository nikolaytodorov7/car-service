package todorov.nikolay.carservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import todorov.nikolay.carservice.model.Car;

@RequestMapping("/client")
public interface ClientController {
    @GetMapping("/{clientId}")
    String indexPage(@PathVariable Long clientId, Model model);

    @GetMapping("/cars/{clientId}")
    String getCars(@PathVariable Long clientId, Model model);

    @Transactional
    @DeleteMapping("/cars/delete/{carId}")
    ResponseEntity<String> deleteCar(@PathVariable Long carId);

    @Transactional
    @PostMapping("/buy/car/{clientId}")
    void buyCar(@PathVariable Long clientId, @RequestBody Car car);
}
