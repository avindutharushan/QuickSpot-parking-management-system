package lk.ijse.vehicleservice.feign;

import lk.ijse.vehicleservice.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * ---------------------------------------------
 * @author Avindu Tharushanshan
 * @project Quick-Spot-SPMS
 * @github <a href="https://github.com/avindutharushan">...</a>
 * @created 6/13/25 - 9:05 PM
 * ---------------------------------------------
 */
@FeignClient(name = "user-service")
public interface UserServiceClient{

    @GetMapping("/api/v1/user/{id}")
    ResponseEntity<UserDTO> getUserById(@PathVariable Long id);

    @GetMapping("/api/v1/user/exists/{id}")
     ResponseEntity<Boolean> isUserExist(@PathVariable Long id);
}
