package com.saper.backend.dto;

import com.saper.backend.model.Professor;

public class ProfessorResponseDTO {
    Long id;
    String registration;
    Long client_id;

    public ProfessorResponseDTO() {
    }

    public ProfessorResponseDTO(Professor professor) {
        id = professor.getId();
        registration = professor.getRegistration();
        client_id = professor.getClient().getId();
    }

    public ProfessorResponseDTO(Long id, String registration, Long client_id) {
        this.id = id;
        this.registration = registration;
        this.client_id = client_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public Long getClient_id() {
        return client_id;
    }

    public void setClient_id(Long client_id) {
        this.client_id = client_id;
    }
}
