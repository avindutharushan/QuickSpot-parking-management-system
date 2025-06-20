package lk.ijse.vehicleservice.service.impl;

import lk.ijse.vehicleservice.dto.UserDTO;
import lk.ijse.vehicleservice.dto.VehicleDTO;
import lk.ijse.vehicleservice.entity.Vehicle;
import lk.ijse.vehicleservice.feign.UserServiceClient;
import lk.ijse.vehicleservice.repository.VehicleRepository;
import lk.ijse.vehicleservice.service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
@RequiredArgsConstructor
public class VehicleServiceImpl implements VehicleService {
    private final VehicleRepository vehicleRepository;
    private final ModelMapper modelMapper;
    @Autowired
    private UserServiceClient userServiceClient;

    @Override
    @Transactional
    public void updateVehicle(VehicleDTO vehicleDTO) {
        Vehicle existing = vehicleRepository.findById(vehicleDTO.getVehicleId())
                .orElseThrow(() -> new RuntimeException("vehicle not found"));

        /*existing.setUsername(userDTO.getUsername());
        existing.setPassword(userDTO.getPassword());
        existing.setEmail(userDTO.getEmail());
        existing.setRole(UserRole.fromString(userDTO.getRole()));*/

        vehicleRepository.save(existing);
    }

    @Transactional
    @Override
    public void saveVehicle(VehicleDTO vehicleDTO) {
        vehicleDTO.setVehicleId(null);

        Boolean isUserExist = userServiceClient.isUserExist(vehicleDTO.getUserId()).getBody();
        if (Boolean.FALSE.equals(isUserExist)) {
            throw new RuntimeException("User not found with ID: " + vehicleDTO.getUserId());
        }

        Vehicle vehicle = modelMapper.map(vehicleDTO, Vehicle.class);
        vehicleRepository.save(vehicle);
    }


    @Override
    public void deleteVehicle(Long id) {
        if (!vehicleRepository.existsById(id)) {
            throw new RuntimeException("Vehicle not found");
        }
        vehicleRepository.deleteById(id);
    }

    @Override
    public List<VehicleDTO> getAllVehicles() {
        return modelMapper.map(vehicleRepository.findAll(), new TypeToken<List<VehicleDTO>>() {}.getType());
    }

    @Override
    public VehicleDTO getVehicleById(Long id) {
        return vehicleRepository.findById(id)
                .map(vehicle -> modelMapper.map(vehicle, VehicleDTO.class))
                .orElseThrow(() -> new RuntimeException("Vehicle not found with id: " + id));
    }

}
