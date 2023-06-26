package todorov.nikolay.carservice.model;

public class CarServicingDTO {
    private Long id;
    private Long carServiceId;
    private Long carId;
    private Long serviceTypeId;
    private Double price;
    private Boolean repaired;

    public CarServicingDTO() {
    }

    public CarServicingDTO(Long carServiceId, Long carId, Long serviceTypeId, Double price, Boolean repaired) {
        this.carServiceId = carServiceId;
        this.carId = carId;
        this.serviceTypeId = serviceTypeId;
        this.price = price;
        this.repaired = repaired;
    }

    public CarServicingDTO(Long id, Long carServiceId, Long carId, Long serviceTypeId, Double price, Boolean repaired) {
        this.id = id;
        this.carServiceId = carServiceId;
        this.carId = carId;
        this.serviceTypeId = serviceTypeId;
        this.price = price;
        this.repaired = repaired;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCarServiceId() {
        return carServiceId;
    }

    public void setCarServiceId(Long carServiceId) {
        this.carServiceId = carServiceId;
    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public Long getServiceTypeId() {
        return serviceTypeId;
    }

    public void setServiceTypeId(Long serviceTypeId) {
        this.serviceTypeId = serviceTypeId;
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
