package com.ArielMelo.AWS_image.dtos;

import com.ArielMelo.AWS_image.enums.StatusTarefa;

public record TarefaRequestDTO(
        String titulo,
        String descricao,
        Long userId
) {}
