package com.juaracoding._01JavaWeb.model;/*
Created By IntelliJ IDEA 2022.2.3 (Community Edition)
IntelliJ IDEA 2022.3.2 (Community Edition)
Build #IC-223.8617.56, built on January 26, 2023
@Author USER a.k.a. Deby Utari
Java Developer
Created on 09/03/2023 16:25
@Last Modified 09/03/2023 16:25
Version 1.0
*/


import javax.persistence.*;

@Entity
@Table(name= "MstStatus")
public class Status {

    @Id
    @Column(name="IDStatus",unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idStatus;

    @Column(name="Status")
    private Long status;

    public Long getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(Long idStatus) {
        this.idStatus = idStatus;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }
}
