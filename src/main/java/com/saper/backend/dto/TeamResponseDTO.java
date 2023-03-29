package com.saper.backend.dto;

import com.saper.backend.model.Team;

public class TeamResponseDTO {
    Long id;
    String  schedule;
    Long box_id;
    Long professor_id;


    public TeamResponseDTO(Long id, String schedule, Long box_id, Long professor_id) {
        this.id = id;
        this.schedule = schedule;
        this.box_id = box_id;
        this.professor_id = professor_id;
    }

    public TeamResponseDTO() {
    }

    public TeamResponseDTO(Team team) {
        id = team.getId();
        schedule = team.getSchedule();
        box_id = team.getBox().getId();
        professor_id = team.getProfessor().getId();
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

    public Long getBox_id() {
        return box_id;
    }

    public void setBox_id(Long box_id) {
        this.box_id = box_id;
    }

    public Long getProfessor_id() {
        return professor_id;
    }

    public void setProfessor_id(Long professor_id) {
        this.professor_id = professor_id;
    }
}
