    package lk.ijse.vehicleservice.controller;

    import jakarta.validation.Valid;
    import lk.ijse.vehicleservice.dto.VehicleDTO;
    import lk.ijse.vehicleservice.service.VehicleService;
    import lk.ijse.vehicleservice.util.Response;
    import lombok.RequiredArgsConstructor;
    import org.springframework.http.MediaType;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.*;

    import java.util.List;
    /**
     * ---------------------------------------------
     * @author Avindu Tharushanshan
     * @project Quick-Spot-SPMS
     * @github <a href="https://github.com/avindutharushan">...</a>
     * @created 6/13/25
     * ---------------------------------------------
     */

    @RestController
    @RequestMapping("/api/v1/vehicle")
    @RequiredArgsConstructor
    public class VehicleController {

        private final VehicleService vehicleService;

        @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<Response> saveVehicle(@RequestBody @Valid VehicleDTO vehicleDTO) {
            vehicleService.saveVehicle(vehicleDTO);
            return ResponseEntity.ok(new Response("Vehicle saved successfully", true));
        }

        @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<Response> updateVehicle(@RequestBody @Valid VehicleDTO vehicleDTO) {
            vehicleService.updateVehicle(vehicleDTO);
            return ResponseEntity.ok(new Response("Vehicle updated successfully", true));
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Response> deleteVehicle(@PathVariable Long id) {
            vehicleService.deleteVehicle(id);
            return ResponseEntity.ok(new Response("Vehicle deleted successfully", true));
        }

        @GetMapping("/{id}")
        public ResponseEntity<VehicleDTO> getVehicleById(@PathVariable Long id) {
            return ResponseEntity.ok(vehicleService.getVehicleById(id));
        }


        @GetMapping
        public ResponseEntity<List<VehicleDTO>> getAllVehicles() {
            return ResponseEntity.ok(vehicleService.getAllVehicles());
        }
    }
