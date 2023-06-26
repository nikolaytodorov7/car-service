package todorov.nikolay.carservice.model;

public class CarServicing {
    public Long id;
    public String carServiceName;
    public String carBrandName;
    public String carModel;
    public String carLicensePlate;
    public String carYearOfManufacture;
    public ServiceType serviceType;
    public Double price;
    public Boolean repaired;
//
//    public CarServicing(String carServicing){
//        System.out.println(carServicing);
//    }
//    public CarServicing() {
//    }
//
//    public CarServicing(Long id, String carServiceName, String carBrandName, String carModel, String carLicensePlate, String carYearOfManufacture, ServiceType serviceType, Double price, Boolean repaired) {
//        this.id = id;
//        this.carServiceName = carServiceName;
//        this.carBrandName = carBrandName;
//        this.carModel = carModel;
//        this.carLicensePlate = carLicensePlate;
//        this.carYearOfManufacture = carYearOfManufacture;
//        this.serviceType = serviceType;
//        this.price = price;
//        this.repaired = repaired;
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCarServiceName() {
        return carServiceName;
    }

    public void setCarServiceName(String carServiceName) {
        this.carServiceName = carServiceName;
    }

    public String getCarBrandName() {
        return carBrandName;
    }

    public void setCarBrandName(String carBrandName) {
        this.carBrandName = carBrandName;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getCarLicensePlate() {
        return carLicensePlate;
    }

    public void setCarLicensePlate(String carLicensePlate) {
        this.carLicensePlate = carLicensePlate;
    }

    public String getCarYearOfManufacture() {
        return carYearOfManufacture;
    }

    public void setCarYearOfManufacture(String carYearOfManufacture) {
        this.carYearOfManufacture = carYearOfManufacture;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Boolean getRepaired() {
        return repaired;
    }

    public void setRepaired(Boolean repaired) {
        this.repaired = repaired;
    }
}
