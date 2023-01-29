package com.secretariaObras.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table
public class UsuariosAdministrativo {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@NotNull
	private int IdUsuarioAdministrativo;
	@Column(unique=true)
	@NotNull
private String NomedoUsuario;
	@Column
	@NotNull
private String SenhadoUsuario;
	
	public UsuariosAdministrativo() {
		
	}
	public int getIdUsuarioAdministrativo() {
		return IdUsuarioAdministrativo;
	}
	public void setIdUsuarioAdministrativo(int idUsuarioAdministrativo) {
		IdUsuarioAdministrativo = idUsuarioAdministrativo;
	}
	public String getNomedoUsuario() {
		return NomedoUsuario;
	}
	public void setNomedoUsuario(String nomedoUsuario) {
		NomedoUsuario = nomedoUsuario;
	}
	public String getSenhadoUsuario() {
		return SenhadoUsuario;
	}
	public void setSenhadoUsuario(String senhadoUsuario) {
		Criptografia crip = new Criptografia();
		
		String senhacriptografada=crip.criptografar(senhadoUsuario);
		SenhadoUsuario = senhacriptografada;
	}
	@Override
	public String toString() {
		return "UsuariosAdministrativo [IdUsuarioAdministrativo=" + IdUsuarioAdministrativo + ", NomedoUsuario="
				+ NomedoUsuario + ", SenhadoUsuario=" + SenhadoUsuario + "]";
	}



}
