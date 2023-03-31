package com.saper.backend.dto;

import com.saper.backend.model.Client;
import com.saper.backend.model.FileData;
import com.saper.backend.model.Role;

import java.util.List;

public class ClientResponseDTO {
    String name;
    String login;
    FileData profileImage;

    Long student_id;
    List<Role> roles;

    public ClientResponseDTO() {
    }

    public ClientResponseDTO(String name, String login, Long student_id, List<Role> roles, FileData profileImage) {
        this.name = name;
        this.login = login;
        this.student_id = student_id;
        this.roles = roles;
        this.profileImage = profileImage;
    }

    public ClientResponseDTO(Client client) {
        this.name = client.getName();
        this.login = client.getLogin();
        this.student_id = client.getId();
        this.roles = client.getRoles();
        this.profileImage = client.getProfileImage();
    }

    public Long getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Long student_id) {
        this.student_id = student_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public FileData getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(FileData profileImage) {
        this.profileImage = profileImage;
    }
}
