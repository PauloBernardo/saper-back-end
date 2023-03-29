package com.saper.backend.controller;

import com.saper.backend.dto.ProfessorRequestDTO;
import com.saper.backend.dto.ProfessorUpdateDTO;
import com.saper.backend.service.ProfessorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/professors")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProfessorController {

    @Autowired
    ProfessorService professorService;

    @PostMapping
    public ResponseEntity<Object> save(
            @RequestBody @Valid ProfessorRequestDTO professorRequestDTO){
        return professorService.save(professorRequestDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(
            @PathVariable(name = "id") Long id){
        return professorService.findById(id);
    }

    @GetMapping
    public ResponseEntity<Object> findAll(){
        return professorService.findAll();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(
            @PathVariable(name = "id") Long id,
            @RequestBody ProfessorUpdateDTO professorUpdateDTO){
        return professorService.update(id, professorUpdateDTO);
    }

    @PostMapping("/enrollment/{professor_id}/{team_id}")
    public  ResponseEntity<Object> enroll(
            @PathVariable(name = "professor_id") Long professor_id,
            @PathVariable(name = "team_id") Long team_id){
        return professorService.enroll(professor_id, team_id);
    }
}
