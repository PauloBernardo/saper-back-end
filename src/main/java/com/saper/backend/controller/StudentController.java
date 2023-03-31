package com.saper.backend.controller;

import com.saper.backend.dto.StudentRequestDTO;
import com.saper.backend.dto.StudentUpdateDTO;
import com.saper.backend.model.Client;
import com.saper.backend.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/students")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping
    public ResponseEntity<Object> save(StudentRequestDTO studentRequestDTO, @RequestParam("file") MultipartFile file) throws IOException {
        return studentService.save(studentRequestDTO, file);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(
            @PathVariable(name = "id") Long id){
        return studentService.findById(id);
    }

    @GetMapping
    public ResponseEntity<Object> findAll(){
        return studentService.findAll();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(
            @PathVariable(name = "id") Long id,
            @RequestBody StudentUpdateDTO studentUpdateDTO){
        return studentService.update(id, studentUpdateDTO);
    }

    @PostMapping("/enrollment/{student_id}/{team_id}")
    public  ResponseEntity<Object> enroll(
            @PathVariable(name = "student_id") Long student_id,
            @PathVariable(name = "team_id") Long team_id){
        return studentService.enroll(student_id, team_id);
    }
}
