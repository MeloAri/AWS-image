package com.ArielMelo.AWS_image.controllers;

import com.ArielMelo.AWS_image.dtos.TarefaRequestDTO;
import com.ArielMelo.AWS_image.dtos.TarefaResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.ArielMelo.AWS_image.Service.TarefaService;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    private final TarefaService tarefaService;

    public TarefaController(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    @PostMapping
    public ResponseEntity<TarefaResponseDTO> create(@RequestBody TarefaRequestDTO dto){
        return ResponseEntity.ok(tarefaService.create(dto));
    }

    @GetMapping
    public ResponseEntity<List<TarefaResponseDTO>> findAll(){
        return ResponseEntity.ok(tarefaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TarefaResponseDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok(tarefaService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TarefaResponseDTO> update(
            @PathVariable Long id,
            @RequestBody TarefaRequestDTO dto
    ){
        return ResponseEntity.ok(tarefaService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        tarefaService.delete(id);
        return ResponseEntity.noContent().build();
    }


}
