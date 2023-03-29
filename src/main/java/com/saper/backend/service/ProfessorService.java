package com.saper.backend.service;

import com.saper.backend.dto.*;
import com.saper.backend.enums.RoleNames;
import com.saper.backend.exception.exceptions.ConflictStoreException;
import com.saper.backend.model.Client;
import com.saper.backend.model.Role;
import com.saper.backend.model.Professor;
import com.saper.backend.model.Team;
import com.saper.backend.repository.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProfessorService {

    @Autowired
    ProfessorRepository professorRepository;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    TeamRepository teamRepository;

    @Autowired
    RoleRepository roleRepository;

    public ResponseEntity<Object> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(
                professorRepository.findAll().stream().map(ProfessorResponseDTO::new).toList()
        );
    }


    public ResponseEntity<Object> save(ProfessorRequestDTO professorRequestDTO) {

        ClientRequestDTO clientRequestDTO = new ClientRequestDTO();
        BeanUtils.copyProperties(professorRequestDTO, clientRequestDTO);
        Client client = clientRequestDTO.toClient();

        if(clientRepository.existsByLogin(client.getLogin())){
            throw new ConflictStoreException("login already in use");
        }

        Optional<Role> role = roleRepository.findByRole(RoleNames.ROLE_PROFESSOR);
        List<Role> roles = new ArrayList<>();
        roles.add(role.get());
        client.setRoles(roles);

        clientRepository.save(client);

        Professor professor = new Professor();

        professor.setRegistration(String.valueOf(new Date().getTime()));
        professor.setClient(client);

        return ResponseEntity.status(HttpStatus.CREATED).body(new ProfessorResponseDTO(professorRepository.save(professor)));
    }

    public ResponseEntity<Object> findById(Long id) {
        Optional<Professor> professorOptional = professorRepository.findById(id);

        if(professorOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(new ProfessorResponseDTO(professorOptional.get()));
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("professor not found");
        }
    }

    @Transactional
    public ResponseEntity<Object> enroll(Long professor_id, Long team_id) {

        Professor professor = professorRepository.findById(professor_id).orElseThrow(() -> new NoSuchElementException("professor not found"));

        Team team = teamRepository.findById(team_id).orElseThrow(() -> new NoSuchElementException("team not found"));

        if(professor.getTeams().contains(team)){
            throw new ConflictStoreException("professor already enrolled");
        }

        team.setProfessor(professor);
        teamRepository.save(team);

        return ResponseEntity.status(HttpStatus.CREATED).body(new ProfessorResponseDTO(professorRepository.save(professor)));
    }


    public ResponseEntity<Object> update(Long id, ProfessorUpdateDTO professorUpdateDTO) {
        Professor professor = professorRepository.findById(id)
                .orElseThrow(()->new NoSuchElementException("professor not found"));

        return ResponseEntity.status(HttpStatus.OK).body(
                new ProfessorResponseDTO(professorRepository.save(professor))
        );
    }
}
