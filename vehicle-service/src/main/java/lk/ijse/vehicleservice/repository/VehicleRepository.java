package lk.ijse.vehicleservice.repository;

import lk.ijse.vehicleservice.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * ---------------------------------------------
 * @author Avindu Tharushanshan
 * @project Quick-Spot-SPMS
 * @github <a href="https://github.com/avindutharushan">...</a>
 * @created 6/13/25
 * ---------------------------------------------
 */

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
//    @Query("SELECT v FROM Vehicle v WHERE v.licensePlate = ?1")
    boolean existsByLicensePlate(String licensePlate);
}