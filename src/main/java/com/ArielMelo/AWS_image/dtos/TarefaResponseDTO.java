package com.ArielMelo.AWS_image.dtos;

import com.ArielMelo.AWS_image.enums.StatusTarefa;

public record TarefaResponseDTO(
        Long id,
        String title,
        String description,
        StatusTarefa status,
        java.time.LocalDate criadaEm,
        java.time.LocalDate atualizadaEm,
        Long userId
) {
}
