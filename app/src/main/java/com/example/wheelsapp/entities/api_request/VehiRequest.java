package com.example.wheelsapp.entities.api_request;

import java.util.Date;

public class VehiRequest {
    private String idUser;
    private String soat;
    private Integer puestos;
    private String propertyCard;
    private String description;
    private String photo;
    private boolean isActive;
    private String model;

    public VehiRequest() {
    }

    public VehiRequest(String idUser, Integer puestos, String description, String model) {
        this.idUser = idUser;
        this.soat = "SOAT TBD";
        this.puestos = puestos;
        this.propertyCard = "PROPERTY CARD TBD";
        this.description = description;
        this.photo = "PHOTO TBD";
        this.isActive = true;
        this.model = model;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getSoat() {
        return soat;
    }

    public void setSoat(String soat) {
        this.soat = soat;
    }

    public Integer getPuestos() {
        return puestos;
    }

    public void setPuestos(Integer puestos) {
        this.puestos = puestos;
    }

    public String getPropertyCard() {
        return propertyCard;
    }

    public void setPropertyCard(String propertyCard) {
        this.propertyCard = propertyCard;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
