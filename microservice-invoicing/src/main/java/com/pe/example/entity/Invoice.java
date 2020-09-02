package com.pe.example.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "invoice")
public class Invoice implements Serializable{

	@Id
	@Column(name = "id_invoice")
	private Long idInvoice;
	@Column(name = "type_doc", length = 15)
	private String typeDoc;
	@Column(name = "number_doc", length = 10)
	private String numberDoc;
	@Column(name = "amount", length = 10, scale = 2)
	private double amount;
	@Column(name="state", length = 1)
	private String state;
	
	public Invoice() {}
	
	public Invoice(Long id_invoice, double amount, String state) {
		this.idInvoice=id_invoice;
		this.amount=amount;
		this.state=state;
	}

	public Long getIdInvoice() {
		return idInvoice;
	}

	public void setIdInvoice(Long idInvoice) {
		this.idInvoice = idInvoice;
	}

	public String getTypeDoc() {
		return typeDoc;
	}

	public void setTypeDoc(String typeDoc) {
		this.typeDoc = typeDoc;
	}

	public String getNumberDoc() {
		return numberDoc;
	}

	public void setNumberDoc(String numberDoc) {
		this.numberDoc = numberDoc;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
		
}
