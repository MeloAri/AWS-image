package com.ArielMelo.AWS_image.repositories;

import com.ArielMelo.AWS_image.entities.Tarefa;
import com.ArielMelo.AWS_image.entities.User;
import com.ArielMelo.AWS_image.enums.StatusTarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.scheduling.config.Task;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);
}
