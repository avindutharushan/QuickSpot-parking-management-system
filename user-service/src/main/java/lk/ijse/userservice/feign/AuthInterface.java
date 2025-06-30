package lk.ijse.userservice.feign;

import lk.ijse.userservice.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "auth-service", url = "http://localhost:8080/auth-service")
public interface AuthInterface {

    @PostMapping(path = "/api/v1/auth/validate")
    ResponseEntity<String> generateToken(@RequestBody UserDTO userDTO);
}
