package todorov.nikolay.carservice.repository;

import org.apache.ibatis.annotations.*;
import todorov.nikolay.carservice.model.Car;
import todorov.nikolay.carservice.model.CarDTO;
import todorov.nikolay.carservice.model.CarServicingDTO;

import java.util.List;

@Mapper
public interface CarRepository {
    @Select("""
            SELECT id
            FROM tbl_car_brand
            WHERE name = #{name}""")
    Long getCarBrandIdByName(String name);

    @Select("""
            SELECT c.id,
            	cb.name AS brand,
            	c.model,
            	c.license_plate,
            	c.year_of_manufacture
            FROM tbl_car c
            INNER JOIN tbl_car_brand cb ON cb.id = c.car_brand_id
            WHERE c.client_id = #{clientId}""")
    List<Car> getAllCarsByClientId(Long clientId);

    @Update("""
            UPDATE tbl_car_servicing
            SET repaired = 1,
            	price = #{price}
            WHERE id = #{id}""")
    void repairCar(Long id, Double price);

    @Insert("""
            INSERT INTO tbl_car_servicing (
            	car_service_id,
            	car_id,
            	service_type_id,
            	price,
            	repaired
            	)
            VALUES (
            	#{carServiceId},
            	#{carId},
            	#{serviceTypeId},
            	0,
            	0
            	)""")
    void sendCarToService(CarServicingDTO carServicingDTO);

    @Delete("""
            DELETE
            FROM tbl_car
            WHERE id = #{id}""")
    void deleteCarById(Long id);

    @Select("""
            SELECT *
            FROM tbl_car
            WHERE id = #{id}""")
    Car getCarById(Long id);

    @Insert("""
            INSERT INTO tbl_car (
            	car_brand_id,
            	model,
            	license_plate,
            	year_of_manufacture,
            	client_id
            	)
            VALUES (
            	#{carBrandId},
            	#{model},
            	#{licensePlate},
            	#{yearOfManufacture},
            	#{clientId}
            	)""")
    void insertCar(CarDTO car);
}
