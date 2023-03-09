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

import com.juaracoding._01JavaWeb.utils.ConstantMessage;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "MstPaketLayanan")
public class PaketLayanan {

    @Id
    @Column(name = "IDListHarga",unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idListHarga;

    @NotEmpty(message = ConstantMessage.WARNING_NAMA_PAKET_EMPTY)
    @NotBlank(message = ConstantMessage.WARNING_NAMA_PAKET_BLANK)
    @Column(name = "NamaLayanan")
    private String namaLayanan;

    @NotEmpty(message = ConstantMessage.WARNING_HARGA_PAKET_EMPTY)
    @NotNull(message = ConstantMessage.WARNING_HARGA_PAKET_NULL)
    @NotBlank(message = ConstantMessage.WARNING_HARGA_PAKET_BLANK)
    @Column(name = "Harga",nullable = false)
    private Long harga;

    @NotEmpty(message = ConstantMessage.WARNING_TIPE_PAKET_EMPTY)
    @NotNull(message = ConstantMessage.WARNING_TIPE_PAKET_NULL)
    @NotBlank(message = ConstantMessage.WARNING_TIPE_PAKET_BLANK)
    @Column(name = "Tipe",nullable = false)
    private byte tipeLayanan;

    public Long getIdListHarga() {
        return idListHarga;
    }

    public void setIdListHarga(Long idListHarga) {
        this.idListHarga = idListHarga;
    }

    public String getNamaLayanan() {
        return namaLayanan;
    }

    public void setNamaLayanan(String namaLayanan) {
        this.namaLayanan = namaLayanan;
    }

    public Long getHarga() {
        return harga;
    }

    public void setHarga(Long harga) {
        this.harga = harga;
    }

    public byte getTipeLayanan() {
        return tipeLayanan;
    }

    public void setTipeLayanan(byte tipeLayanan) {
        this.tipeLayanan = tipeLayanan;
    }
}

