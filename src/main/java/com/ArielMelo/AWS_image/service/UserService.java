package com.ArielMelo.AWS_image.Service;

import com.ArielMelo.AWS_image.dtos.UserRequestDTO;
import com.ArielMelo.AWS_image.dtos.UserResponseDTO;
import com.ArielMelo.AWS_image.entities.User;
import com.ArielMelo.AWS_image.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // CREATE
    @Transactional
    public UserResponseDTO create(UserRequestDTO dto) {
        User user = new User();
        user.setName(dto.name());
        user.setPassword(dto.password());

        userRepository.save(user);

        return new UserResponseDTO(user.getId(), user.getName());
    }

    // FIND ALL
    @Transactional(readOnly = true)
    public List<UserResponseDTO> findAll() {
        return userRepository.findAll()
                .stream()
                .map(user -> new UserResponseDTO(user.getId(), user.getName()))
                .toList();
    }

    // FIND BY ID
    @Transactional(readOnly = true)
    public UserResponseDTO findById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("Usuário não encontrado"));

        return new UserResponseDTO(user.getId(), user.getName());
    }

    // UPDATE
    @Transactional
    public UserResponseDTO update(Long id, UserRequestDTO dto) {
        User user = userRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("Usuário não encontrado"));

        user.setName(dto.name());
        user.setPassword(dto.password());

        userRepository.save(user);

        return new UserResponseDTO(user.getId(), user.getName());
    }

    // DELETE
    @Transactional
    public void delete(Long id) {
        if (!userRepository.existsById(id)) {
            throw new EntityNotFoundException("Usuário não encontrado");
        }

        userRepository.deleteById(id);
    }
}
