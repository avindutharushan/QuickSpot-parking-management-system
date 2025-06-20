package lk.ijse.userservice.service;

import lk.ijse.userservice.dto.UserDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    void updateUser(UserDTO userDTO);
    void saveUser(UserDTO userDTO);
    void deleteUser(Long id);
    List<UserDTO> getAllUsers();
    UserDTO getUserById(Long id);
    boolean isUserExist(Long id);

}