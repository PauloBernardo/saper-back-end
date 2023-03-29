package com.saper.backend.controller;

import com.saper.backend.dto.TeamRequestDTO;
import com.saper.backend.dto.TeamUpdateDTO;
import com.saper.backend.service.TeamService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/teams")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TeamController {
    @Autowired
    TeamService teamService;

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(
            @PathVariable(name = "id") Long id){

        return teamService.findById(id);
    }

    @GetMapping
    public ResponseEntity<Object> findAll(){
        return teamService.findAll();
    }

    @PostMapping
    public ResponseEntity<Object> save(
            @RequestBody TeamRequestDTO teamRequestDTO){
        return teamService.save(teamRequestDTO);
    }

    @PutMapping("/{id}")
    public  ResponseEntity<Object> update(
            @PathVariable(name = "id") Long id,
            @RequestBody @Valid TeamUpdateDTO teamUpdateDTO){
        return teamService.update(id, teamUpdateDTO);
    }


}
