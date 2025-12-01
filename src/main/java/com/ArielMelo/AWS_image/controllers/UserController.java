package com.ArielMelo.AWS_image.controllers;

import com.ArielMelo.AWS_image.dtos.UserRequestDTO;
import com.ArielMelo.AWS_image.dtos.UserResponseDTO;
import org.apache.catalina.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.ArielMelo.AWS_image.Service.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserResponseDTO> criar(@RequestBody UserRequestDTO dto){
        return ResponseEntity.ok(userService.create(dto));
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> findall(){
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok(userService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDTO> uptade(
            @PathVariable Long id,
            @RequestBody UserRequestDTO dto
    ){
        return ResponseEntity.ok(userService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
