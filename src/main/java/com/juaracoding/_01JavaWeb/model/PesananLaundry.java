package com.juaracoding._01JavaWeb.model;

import javax.persistence.*;

import java.util.Date;
@Entity
@Table(name = "MstPesananLaundry")
public class PesananLaundry {

	@Id
	@Column(name = "IDPesanan",unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPesanan;

	@ManyToOne
	@JoinColumn(name = "IDPembayaran")
	private Pembayaran idPembayaran;

	@ManyToOne
	@JoinColumn(name = "IDListHarga")
	private PaketLayanan idPaketLayanan;

	@ManyToOne
	@JoinColumn(name = "IDUsers")
	private Userz idusers;

	@ManyToOne()
	@JoinColumn(name = "IDStatus")
	private Status idStatus;

	/*
	 * Audit Trails
	 * */
	@Column(name = "CreatedDate")
	private Date createdAt = new Date();

	@Column(name = "ModifiedDate")
	private Date modifiedDate;

	@Column(name = "CreatedBy")
	private byte createdBy = 1;

	@Column(name = "ModifiedBy")
	private Integer modifiedBy;

	@Column(name = "IsDelete")
	private byte isDelete = 0;

	public Long getIdPesanan() {
		return idPesanan;
	}

	public void setIdPesanan(Long idPesanan) {
		this.idPesanan = idPesanan;
	}

	public Pembayaran getIdPembayaran() {
		return idPembayaran;
	}

	public void setIdPembayaran(Pembayaran idPembayaran) {
		this.idPembayaran = idPembayaran;
	}

	public PaketLayanan getIdPaketLayanan() {
		return idPaketLayanan;
	}

	public void setIdPaketLayanan(PaketLayanan idPaketLayanan) {
		this.idPaketLayanan = idPaketLayanan;
	}

	public Userz getIdusers() {
		return idusers;
	}

	public void setIdusers(Userz idusers) {
		this.idusers = idusers;
	}

	public Status getIdStatus() {
		return idStatus;
	}

	public void setIdStatus(Status idStatus) {
		this.idStatus = idStatus;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public byte getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(byte createdBy) {
		this.createdBy = createdBy;
	}

	public Integer getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(Integer modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public byte getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(byte isDelete) {
		this.isDelete = isDelete;
	}
}