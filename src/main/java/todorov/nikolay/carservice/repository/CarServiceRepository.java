package todorov.nikolay.carservice.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import todorov.nikolay.carservice.model.CarBrand;
import todorov.nikolay.carservice.model.CarService;
import todorov.nikolay.carservice.model.CarServicing;
import todorov.nikolay.carservice.model.ServiceType;

import java.util.List;
import java.util.Set;

@Mapper
public interface CarServiceRepository {
    @Select("""
            SELECT *
            FROM tbl_car_service cs
            INNER JOIN tbl_service_employee se ON cs.id = se.car_service_id
            WHERE se.employee_id = #{employeeId}""")
    List<CarService> getAvailableCarServicesByEmployeeId(Long employeeId);

    @Select("""
            SELECT cs.id,
            	s.name AS carServiceName,
            	cb.name AS carBrandName,
            	c.model AS carModel,
            	c.license_plate AS carLicensePlate,
            	c.year_of_manufacture AS carYearOfManufacture,
            	st.name AS serviceType,
            	cs.price,
            	cs.repaired
            FROM tbl_car_servicing cs
            INNER JOIN tbl_car_service s ON cs.car_service_id = s.id
            INNER JOIN tbl_car c ON cs.car_id = c.id
            INNER JOIN tbl_car_brand cb ON c.car_brand_id = cb.id
            INNER JOIN tbl_service_type st ON cs.service_type_id = st.id
            WHERE s.id = #{id}
            ORDER BY (cs.repaired IS true) ASC""")
    List<CarServicing> getAllCarsInCarServiceByServiceId(Long id);

    @Select("""
            SELECT cs.id,
            	s.name AS carServiceName,
            	cb.name AS carBrandName,
            	c.model AS carModel,
            	c.license_plate AS carLicensePlate,
            	c.year_of_manufacture AS carYearOfManufacture,
            	st.name AS serviceType,
            	cs.price,
            	cs.repaired
            FROM tbl_car_servicing cs
            INNER JOIN tbl_car_service s ON cs.car_service_id = s.id
            INNER JOIN tbl_car c ON cs.car_id = c.id
            INNER JOIN tbl_car_brand cb ON c.car_brand_id = cb.id
            INNER JOIN tbl_service_type st ON cs.service_type_id = st.id
            WHERE s.id = #{id}
            	AND cs.repaired = 0""")
    List<CarServicing> getAllCarsInCarServiceForRepairByServiceId(Long id);

    @Select("""
            SELECT cs.id,
            	s.name AS carServiceName,
            	cb.name AS carBrandName,
            	c.model AS carModel,
            	c.license_plate AS carLicensePlate,
            	c.year_of_manufacture AS carYearOfManufacture,
            	st.name AS serviceType,
            	cs.price,
            	cs.repaired
            FROM tbl_car_servicing cs
            INNER JOIN tbl_car_service s ON cs.car_service_id = s.id
            INNER JOIN tbl_car c ON cs.car_id = c.id
            INNER JOIN tbl_car_brand cb ON c.car_brand_id = cb.id
            INNER JOIN tbl_service_type st ON cs.service_type_id = st.id
            WHERE s.id = #{id}
            	AND cb.name = #{carBrand}
            	AND cs.repaired = 1""")
    List<CarServicing> getAllCarsInCarServiceForRepairByServiceIdAndCarBrand(Long id, CarBrand carBrand);

    @Select("""
            SELECT cs.id,
            	s.name AS carServiceName,
            	cb.name AS carBrandName,
            	c.model AS carModel,
            	c.license_plate AS carLicensePlate,
            	c.year_of_manufacture AS carYearOfManufacture,
            	st.name AS serviceType,
            	cs.price,
            	cs.repaired
            FROM tbl_car_servicing cs
            INNER JOIN tbl_car_service s ON cs.car_service_id = s.id
            INNER JOIN tbl_car c ON cs.car_id = c.id
            INNER JOIN tbl_car_brand cb ON c.car_brand_id = cb.id
            INNER JOIN tbl_service_type st ON cs.service_type_id = st.id
            WHERE s.id = #{id}
            	AND st.name = #{serviceType}
            	AND cs.repaired = 1""")
    List<CarServicing> getAllCarsInCarServiceForRepairByServiceIdAndServiceType(Long id, ServiceType serviceType);

    @Select("""
            SELECT cs.id,
            	s.name AS carServiceName,
            	cb.name AS carBrandName,
            	c.model AS carModel,
            	c.license_plate AS carLicensePlate,
            	c.year_of_manufacture AS carYearOfManufacture,
            	st.name AS serviceType,
            	cs.price,
            	cs.repaired
            FROM tbl_car_servicing cs
            INNER JOIN tbl_car_service s ON cs.car_service_id = s.id
            INNER JOIN tbl_car c ON cs.car_id = c.id
            INNER JOIN tbl_car_brand cb ON c.car_brand_id = cb.id
            INNER JOIN tbl_service_type st ON cs.service_type_id = st.id
            WHERE s.id = #{id}
            	AND year(c.year_of_manufacture) = #{yearOfManufacture}
            	AND cs.repaired = 1""")
    List<CarServicing> getAllCarsInCarServiceForRepairByServiceIdAndYearOfManufacture(Long id, Long yearOfManufacture);

    @Select("""
            SELECT *
            FROM tbl_car_service""")
    List<CarService> getAllServices();

    @Select("""
            SELECT name
            FROM tbl_service_type""")
    List<String> getAllServiceTypes();

    @Select("""
            SELECT *
            FROM tbl_service_type
            WHERE name = #{name}""")
    Long getServiceTypeIdByName(String name);

    @Select("""
            SELECT car_brand_id
            FROM tbl_car_service_brand
            WHERE car_service_id = #{carServiceId}""")
    Set<Long> getCarBrandsForServiceById(Long carServiceId);
}
