package com.saper.backend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.Set;

@Entity
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    // Professor responsável
    @ManyToOne(targetEntity = Box.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "professor_id")
    @NotNull()
    Professor professor;

    // Alunos matriculados
    @ManyToMany(
            targetEntity = Student.class,
            mappedBy = "teams")
    Set<Student> students;

    @Column(name = "schedule")
    String schedule; //TODO: Mudar para DayOfWeek end LocalTime
    // 35_19 : terça e quinta às 19
    // 246_17 : segunda quarta e sexta, às 17

    @ManyToOne(targetEntity = Box.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "box_id")
    Box box;

    public Team() {
    }

    public Team(Long id, Set<Student> students, String schedule, Box box) {
        this.id = id;
        this.students = students;
        this.schedule = schedule;
        this.box = box;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public Box getBox() {
        return box;
    }

    public void setBox(Box box) {
        this.box = box;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
}
