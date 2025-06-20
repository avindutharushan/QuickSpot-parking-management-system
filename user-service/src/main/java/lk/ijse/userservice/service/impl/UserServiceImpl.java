package lk.ijse.userservice.service.impl;

import lk.ijse.userservice.dto.UserDTO;
import lk.ijse.userservice.entity.User;
import lk.ijse.userservice.entity.enums.UserRole;
import lk.ijse.userservice.repository.UserRepository;
import lk.ijse.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Override
    @Transactional
    public void updateUser(UserDTO userDTO) {
        User existing = userRepository.findById(userDTO.getId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        existing.setUsername(userDTO.getUsername());
        existing.setPassword(userDTO.getPassword());
        existing.setEmail(userDTO.getEmail());
        existing.setRole(UserRole.fromString(userDTO.getRole()));

        userRepository.save(existing);
    }

    @Override
    public void saveUser(UserDTO userDTO) {
        if (userDTO.getId() != null && userRepository.existsById(userDTO.getId())) {
            throw new RuntimeException("User already exists");
        }

        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user.setEmail(userDTO.getEmail());
        user.setRole(UserRole.fromString(userDTO.getRole()));

        userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("User not found");
        }
        userRepository.deleteById(id);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return modelMapper.map(userRepository.findAll(), new TypeToken<List<UserDTO>>() {}.getType());
    }

    @Override
    public UserDTO getUserById(Long id) {
        return userRepository.findById(id)
                .map(user -> modelMapper.map(user, UserDTO.class))
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

    @Override
    public boolean isUserExist(Long id) {
        return userRepository.existsById(id);
    }

}
