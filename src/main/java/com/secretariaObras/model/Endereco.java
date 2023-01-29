package com.secretariaObras.model;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
@Entity
@Table
public class Endereco {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@NotNull
private Integer idEndereco;
	@Column(nullable=false)
	@NotNull
private String bairro;
	@Column(nullable=false)
	@NotNull
private String rua;
	@Column(nullable=false)
	@NotNull
private String numero;
	
public Endereco() {
	}
public Integer getIdEndereco() {
	return idEndereco;
}

public void setIdEndereco(Integer idEndereco) {
	this.idEndereco = idEndereco;
}

public String getRua() {
	return rua;
}

public void setRua(String rua) {
	this.rua = rua;
}

public String getBairro() {
	return bairro;
}

public void setBairro(String bairro) {
	this.bairro = bairro;
}

public String getNumero() {
	return numero;
}

public void setNumero(String numero) {
	this.numero = numero;
}

@Override
public String toString() {
	return "rua=" + rua + ", bairro=" + bairro + ", numero=" + numero + "";
}

}
