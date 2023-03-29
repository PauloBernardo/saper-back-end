package com.saper.backend.dto;

import jakarta.validation.constraints.NotBlank;

public class TeamUpdateDTO {

    @NotBlank
    String  schedule;
    Long box_id;
    Long professor_id;

    public TeamUpdateDTO(String schedule, Long box_id, Long professor_id) {
        this.schedule = schedule;
        this.box_id = box_id;
        this.professor_id = professor_id;
    }

    public TeamUpdateDTO() {
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
