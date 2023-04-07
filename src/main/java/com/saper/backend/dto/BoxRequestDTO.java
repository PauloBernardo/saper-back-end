package com.saper.backend.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class BoxRequestDTO {

    @Size(min = 3, max = 10, message = "Name tem tamanho mínimo de 3 e máximo de 10")
    @NotNull(message = "name não pode ser nulo")
    String name;

    @Min(value = 1, message = "Capacidade mínima do box é 5")
    @Max(value = 99, message = "Capacidade máxima do box é 99")
    int capacity;

    @Min(value = -90, message = "Latitude mínima do box é -90")
    @Max(value = 90, message = "Latitude máxima do box é 90")
    Double latitude;

    @Min(value = -180, message = "Logintude mínima do box é -180")
    @Max(value = 180, message = "Logintude máxima do box é 180")
    Double longitude;

    public BoxRequestDTO(String name, int capacity, Double latitude, Double longitude) {
        this.name = name;
        this.capacity = capacity;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public BoxRequestDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
}
