package com.saper.backend.dto;

public class StudentUpdateDTO {
    boolean paid;
    String name;

    public StudentUpdateDTO(boolean paid, String name) {
        this.paid = paid;
        this.name = name;
    }

    public StudentUpdateDTO() {
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
