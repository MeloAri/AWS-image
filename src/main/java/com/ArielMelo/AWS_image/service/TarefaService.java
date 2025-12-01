package com.ArielMelo.AWS_image.Service;

import com.ArielMelo.AWS_image.dtos.TarefaRequestDTO;
import com.ArielMelo.AWS_image.dtos.TarefaResponseDTO;
import com.ArielMelo.AWS_image.entities.Tarefa;
import com.ArielMelo.AWS_image.entities.User;
import com.ArielMelo.AWS_image.enums.StatusTarefa;
import com.ArielMelo.AWS_image.repositories.TarefaRepository;
import com.ArielMelo.AWS_image.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class TarefaService {

    private final TarefaRepository tarefaRepository;
    private final UserRepository userRepository;

    public TarefaService(TarefaRepository tarefaRepository, UserRepository userRepository) {
        this.tarefaRepository = tarefaRepository;
        this.userRepository = userRepository;
    }

    // CREATE
    @Transactional
    public TarefaResponseDTO create(TarefaRequestDTO dto) {

        User user = userRepository.findById(dto.userId())
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado"));

        Tarefa tarefa = new Tarefa();
        tarefa.setTitulo(dto.titulo());
        tarefa.setDescricao(dto.descricao());
        tarefa.setStatus(StatusTarefa.PENDENTE);
        tarefa.setCriadaEm(LocalDate.from(LocalDateTime.now()));
        tarefa.setAtualizadaEm(LocalDate.from(LocalDateTime.now()));
        tarefa.setUser(user);

        tarefaRepository.save(tarefa);

        return convertToDTO(tarefa);
    }

    // FIND ALL
    @Transactional(readOnly = true)
    public List<TarefaResponseDTO> findAll() {
        return tarefaRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .toList();
    }

    // FIND BY ID
    @Transactional(readOnly = true)
    public TarefaResponseDTO findById(Long id) {
        Tarefa tarefa = tarefaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Tarefa não encontrada"));

        return convertToDTO(tarefa);
    }

    // UPDATE
    @Transactional
    public TarefaResponseDTO update(Long id, TarefaRequestDTO dto) {

        Tarefa tarefa = tarefaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Tarefa não encontrada"));

        tarefa.setTitulo(dto.titulo());
        tarefa.setDescricao(dto.descricao());
        tarefa.setAtualizadaEm(LocalDate.from(LocalDateTime.now()));

        tarefaRepository.save(tarefa);

        return convertToDTO(tarefa);
    }

    // DELETE
    @Transactional
    public void delete(Long id) {
        if (!tarefaRepository.existsById(id)) {
            throw new EntityNotFoundException("Tarefa não encontrada");
        }

        tarefaRepository.deleteById(id);
    }

    // CONVERTER
    private TarefaResponseDTO convertToDTO(Tarefa tarefa) {
        return new TarefaResponseDTO(
                tarefa.getId(),
                tarefa.getTitulo(),
                tarefa.getDescricao(),
                tarefa.getStatus(),
                tarefa.getCriadaEm(),
                tarefa.getAtualizadaEm(),
                tarefa.getUser().getId()
        );
    }
}
