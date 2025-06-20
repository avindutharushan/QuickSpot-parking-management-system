package lk.ijse.userservice.controller;

import jakarta.validation.Valid;
import lk.ijse.userservice.dto.UserDTO;
import lk.ijse.userservice.service.UserService;
import lk.ijse.userservice.util.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> saveUser(@RequestBody @Valid UserDTO userDTO) {
        userService.saveUser(userDTO);
        return ResponseEntity.ok(new Response("User saved successfully", true));
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> updateUser(@RequestBody @Valid UserDTO userDTO) {
        userService.updateUser(userDTO);
        return ResponseEntity.ok(new Response("User updated successfully", true));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok(new Response("User deleted successfully", true));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }


    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/exists/{id}")
    public ResponseEntity<Boolean> isUserExist(@PathVariable Long id) {
        boolean exists = userService.isUserExist(id);
        return ResponseEntity.ok(exists);
    }


}
