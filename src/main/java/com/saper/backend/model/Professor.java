package com.saper.backend.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "registration")
    String registration;

    @OneToOne(targetEntity = Client.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id")
    Client client;

    @OneToMany(targetEntity = Team.class)
    @JoinColumn(name = "professor_id")
    Set<Team> teams;


    public Professor() {
    }

    public Professor(Long id, String registration, Client client, Set<Team> teams) {
        this.id = id;
        this.registration = registration;
        this.client = client;
        this.teams = teams;
    }

    public Set<Team> getTeams() {
        return teams;
    }

    public void setTeams(Set<Team> teams) {
        this.teams = teams;
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

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
