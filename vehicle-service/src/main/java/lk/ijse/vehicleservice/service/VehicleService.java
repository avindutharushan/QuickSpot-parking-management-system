package lk.ijse.vehicleservice.service;

import lk.ijse.vehicleservice.dto.VehicleDTO;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * ---------------------------------------------
 * @author Avindu Tharushanshan
 * @project Quick-Spot-SPMS
 * @github <a href="https://github.com/avindutharushan">...</a>
 * @created 6/13/25
 * ---------------------------------------------
 */

@Service
public interface VehicleService {
    void updateVehicle(VehicleDTO vehicleDTO);
    void saveVehicle(VehicleDTO vehicleDTO);
    void deleteVehicle(Long id);
    List<VehicleDTO> getAllVehicles();
    VehicleDTO getVehicleById(Long id);
}