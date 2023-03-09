package com.juaracoding._01JavaWeb.model;/*
Created By IntelliJ IDEA 2022.2.3 (Community Edition)
IntelliJ IDEA 2022.3.2 (Community Edition)
Build #IC-223.8617.56, built on January 26, 2023
@Author USER a.k.a. Deby Utari
Java Developer
Created on 09/03/2023 16:20
@Last Modified 09/03/2023 16:20
Version 1.0
*/

import javax.persistence.*;

@Entity
@Table(name = "MstPembayaran")
public class Pembayaran {

    public long getIdPembayaran() {
        return idPembayaran;
    }

    public void setIdPembayaran(long idPembayaran) {
        this.idPembayaran = idPembayaran;
    }

    @Id
    @Column(name = "IDPembayaran",unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idPembayaran;

    @Column(name = "Pembayaran")
    private String Pembayaran;


    public String getPembayaran() {
        return Pembayaran;
    }

    public void setPembayaran(String pembayaran) {
        Pembayaran = pembayaran;
    }
}


