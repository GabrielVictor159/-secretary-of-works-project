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
public class UsuariosdeConcertos {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@NotNull
	private int IdUsuariodeConcertos;
	@Column
	@NotNull
private String NomedoUsuario;
	@Column
	@NotNull
private String SenhadoUsuario;
	public int getIdUsuariodeConcertos() {
		return IdUsuariodeConcertos;
	}
	public void setIdUsuariodeConcertos(int idUsuariodeConcertos) {
		IdUsuariodeConcertos = idUsuariodeConcertos;
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
		return "UsuariosdeConcertos [IdUsuariodeConcertos=" + IdUsuariodeConcertos + ", NomedoUsuario=" + NomedoUsuario
				+ ", SenhadoUsuario=" + SenhadoUsuario + "]";
	}
	
}
