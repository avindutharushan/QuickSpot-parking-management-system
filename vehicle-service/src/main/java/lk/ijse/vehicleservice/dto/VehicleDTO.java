package lk.ijse.vehicleservice.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * ---------------------------------------------
 * @author Avindu Tharushanshan
 * @project Quick-Spot-SPMS
 * @github <a href="https://github.com/avindutharushan">...</a>
 * @created 6/13/25
 * ---------------------------------------------
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehicleDTO {

    private Long vehicleId;

    @NotNull(message = "User ID is required")
    private Long userId;

    @NotBlank(message = "License plate is required")
    private String licensePlate;

    @NotBlank(message = "Make is required")
    private String make;

    @NotBlank(message = "Model is required")
    private String model;
}
