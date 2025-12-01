package com.ArielMelo.AWS_image.repositories;

import com.ArielMelo.AWS_image.entities.Tarefa;
import com.ArielMelo.AWS_image.enums.StatusTarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.scheduling.config.Task;

import java.util.List;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
    List<Tarefa> findByUserId(Long userId);

    List<Tarefa> findByStatus(StatusTarefa status);

    List<Tarefa> findByUserIdAndStatus(Long userId, StatusTarefa status);

}
