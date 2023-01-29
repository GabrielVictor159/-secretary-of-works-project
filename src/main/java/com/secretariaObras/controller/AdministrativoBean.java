package com.secretariaObras.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.secretariaObras.model.UsuariosAdministrativo;


@ManagedBean(name = "consulta")
@ViewScoped
public class AdministrativoBean {
	private DaoAdministrativo daoadministrativo = new DaoAdministrativo();
	private UsuariosAdministrativo admin = new UsuariosAdministrativo();
	private String senharegistro1, senharegistro2;
	
	public String logar() {
		boolean logando;
		logando=daoadministrativo.logar(admin);
		return "";
	}
	public String acessarregistrodeusuario() {
		daoadministrativo.setPaginalogin(false);
		daoadministrativo.setRegistrousuario(true);
		return "";
	}
	public String acessarlogin() {
		daoadministrativo.setPaginalogin(true);
		daoadministrativo.setRegistrousuario(false);
		return "";
	}
	public String registrar() {
			admin.setSenhadoUsuario(senharegistro1);
			daoadministrativo.Registrar(admin,senharegistro1,senharegistro2);
			
		return "";
	}
	
	public String getSenharegistro1() {
		return senharegistro1;
	}

	public void setSenharegistro1(String senharegistro1) {
		this.senharegistro1 = senharegistro1;
	}

	public String getSenharegistro2() {
		return senharegistro2;
	}

	public void setSenharegistro2(String senharegistro2) {
		this.senharegistro2 = senharegistro2;
	}

	public DaoAdministrativo getDaoadministrativo() {
		return daoadministrativo;
	}

	public void setDaoadministrativo(DaoAdministrativo daoadministrativo) {
		this.daoadministrativo = daoadministrativo;
	}

	public UsuariosAdministrativo getAdmin() {
		return admin;
	}

	public void setAdmin(UsuariosAdministrativo admin) {
		this.admin = admin;
	}

	
}
