package todorov.nikolay.carservice.model;

import java.time.LocalDate;

public class CarDTO {
    private Long carBrandId;
    private String model;
    private String licensePlate;
    private LocalDate yearOfManufacture;
    private Long clientId;

    public CarDTO() {
    }

    public CarDTO(Car car, Long carBrandId, Long clientId) {
        this.carBrandId = carBrandId;
        this.model = car.getModel();
        this.licensePlate = car.getLicensePlate();
        this.yearOfManufacture = car.getYearOfManufacture();
        this.clientId = clientId;
    }

    public Long getCarBrandId() {
        return carBrandId;
    }

    public void setCarBrandId(Long carBrandId) {
        this.carBrandId = carBrandId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public LocalDate getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setYearOfManufacture(LocalDate yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }
}
