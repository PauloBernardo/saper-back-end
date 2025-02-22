package com.saper.backend.controller;

import com.saper.backend.dto.BoxRequestDTO;
import com.saper.backend.dto.BoxResponseDTO;
import com.saper.backend.model.Box;
import com.saper.backend.service.BoxService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/boxes")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BoxController {

    @Autowired
    BoxService boxService;

    @GetMapping
    public List<BoxResponseDTO> findAll(
            @RequestParam(name = "name", defaultValue = "") String name,
            @RequestParam(name = "min", defaultValue = "0") int min,
            @RequestParam(name = "max", defaultValue = "9999") int max
    ){

        return boxService.findAll(name, min, max);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> find(
            @PathVariable(name = "id") Long id){

        return boxService.findById(id);
    }

    @PostMapping
    public BoxRequestDTO save(@RequestBody @Valid BoxRequestDTO boxRequestDTO){
        return boxService.save(boxRequestDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(
            @RequestBody BoxRequestDTO boxRequestDTO,
            @PathVariable(name = "id") Long id){
        return boxService.update(id, boxRequestDTO);
    }

}
