package com.secretariaObras.controller;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import com.secretariaObras.model.Concerto;
import com.secretariaObras.model.DaoGeneric;
import com.secretariaObras.model.UsuariosdeConcertos;


@ManagedBean(name = "concertos")
@ViewScoped
public class ConcertosBean {
	private DaoConcertos daoconcertos = new DaoConcertos();
	private UsuariosdeConcertos admin = new UsuariosdeConcertos();
	private Concerto con = new Concerto();
	private String senharegistro1, senharegistro2;
	private int numerodareclamacao;
	private double valordareclamacao;
	public String logar() {
		boolean logando;
		logando=daoconcertos.logar(admin);
		return "";
	}
	public String registro() {
		daoconcertos.setPaginalogin(false);
		daoconcertos.setRegistrousuario(true);
		return "";
	}
	
	
	public String acessarlogin() {
		daoconcertos.setPaginalogin(true);
		daoconcertos.setRegistrousuario(false);
		return "";
	}
	public String registrar() {
			admin.setSenhadoUsuario(senharegistro1);
			daoconcertos.Registrar(admin,senharegistro1,senharegistro2);
			
		return "";
	}
	public String Persistir() {
		Boolean test=daoconcertos.persistirConcerto(numerodareclamacao,valordareclamacao);
		if(test==true) {
			ArrayList<Concerto> listCon = new ArrayList<Concerto>();
			listCon = DaoGeneric.ListToEspecificAtribute(con,"numerodareclamacao","=",numerodareclamacao);
			con=listCon.get(0);
		}
		return "";
	}
	public int getNumerodareclamacao() {
		return numerodareclamacao;
	}
	public void setNumerodareclamacao(int numerodareclamacao) {
		this.numerodareclamacao = numerodareclamacao;
	}
	public DaoConcertos getDaoconcertos() {
		return daoconcertos;
	}
	public void setDaoconcertos(DaoConcertos daoconcertos) {
		this.daoconcertos = daoconcertos;
	}
	public UsuariosdeConcertos getAdmin() {
		return admin;
	}
	public void setAdmin(UsuariosdeConcertos admin) {
		this.admin = admin;
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
	public double getValordareclamacao() {
		return valordareclamacao;
	}
	public void setValordareclamacao(double valordareclamacao) {
		this.valordareclamacao = valordareclamacao;
	}
	public Concerto getCon() {
		return con;
	}
	public void setCon(Concerto con) {
		this.con = con;
	}
	
}
