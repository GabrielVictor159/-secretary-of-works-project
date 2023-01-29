package com.secretariaObras.controller;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.secretariaObras.model.Concerto;
import com.secretariaObras.model.DaoGeneric;
import com.secretariaObras.model.Endereco;
import com.secretariaObras.model.JPAUtil;
import com.secretariaObras.model.Reclamacoes;
import com.secretariaObras.model.UsuariosAdministrativo;

public class DaoAdministrativo {
	private boolean administrador=false;
	private boolean paginalogin=true;
	private boolean registrousuario=false;
	private boolean senhaerrada=false;
	private boolean usuarioinexistente=false;
	private boolean usuarioexistente=false;
	private boolean senhasdiferentes=false;
	public boolean logar(UsuariosAdministrativo admin) {
		ArrayList<UsuariosAdministrativo> lista = new ArrayList<UsuariosAdministrativo>();
		System.out.println(admin);
		try {
			lista=DaoGeneric.ListToEspecificAtribute(admin,"NomedoUsuario","=",admin.getNomedoUsuario());
//			verificação de usuario
			
//				senha correta
				if(lista.get(0).getSenhadoUsuario().equals(admin.getSenhadoUsuario())) {
					paginalogin=false;
					administrador=true;
					return true;
				}
//				senha errada
				else {
					senhaerrada=true;
					return false;
				}
			}
//			usuario inexistente
		
		catch(java.lang.IndexOutOfBoundsException e) {
			usuarioinexistente=true;
			return false;
		}

	}
	public void Registrar(UsuariosAdministrativo admin, String senharegistro1, String senharegistro2) {
		if(senharegistro1.equals(senharegistro2)) {
		ArrayList<UsuariosAdministrativo> lista = new ArrayList<UsuariosAdministrativo>();
		ArrayList<UsuariosAdministrativo> lista2 = new ArrayList<UsuariosAdministrativo>();
		
//		verificação de usuario
			lista=DaoGeneric.ListToEspecificAtribute(admin,"NomedoUsuario","=",admin.getNomedoUsuario());
			if(lista.equals(lista2)) {
//		usuario existe
			DaoGeneric.persist(admin);
			}
			else {
				usuarioexistente=true;
				lista=lista2;
			}
		}
		else {
			senhasdiferentes=true;
		}
		}
	
public static void updatereclamacao(Reclamacoes rec) {
	EntityManager em = JPAUtil.getEntityManager();
	EntityTransaction et = em.getTransaction();
	et.begin();
	var en = em.find(Endereco.class, rec.getEndereco().getIdEndereco());
	en.setBairro(rec.getEndereco().getBairro());
	en.setRua(rec.getEndereco().getRua());
	en.setNumero(rec.getEndereco().getNumero());
	Reclamacoes reclamar =em.find(Reclamacoes.class, rec.getNumero());
	reclamar.setNumero(rec.getNumero());
	reclamar.setEndereco(en);
	if(rec.getConcerto()!=null) {
		Concerto co = em.find(Concerto.class, rec.getConcerto().getIdconcerto());
		co.setData(rec.getConcerto().getData());
		co.setValordoconserto(rec.getConcerto().getValordoconserto());
		reclamar.setConcerto(co);
	}
	reclamar.setLocalidade(rec.getLocalidade());
	reclamar.setTamanho(rec.getTamanho());
	reclamar.setData(rec.getData());
	et.commit();
	em.close();
}

public boolean isSenhasdiferentes() {
	return senhasdiferentes;
}
public void setSenhasdiferentes(boolean senhasdiferentes) {
	this.senhasdiferentes = senhasdiferentes;
}
public boolean isAdministrador() {
	return administrador;
}
public void setAdministrador(boolean administrador) {
	this.administrador = administrador;
}
public boolean isPaginalogin() {
	return paginalogin;
}
public void setPaginalogin(boolean paginalogin) {
	this.paginalogin = paginalogin;
}
public boolean isRegistrousuario() {
	return registrousuario;
}
public void setRegistrousuario(boolean registrousuario) {
	this.registrousuario = registrousuario;
}
public boolean isSenhaerrada() {
	return senhaerrada;
}
public void setSenhaerrada(boolean senhaerrada) {
	this.senhaerrada = senhaerrada;
}
public boolean isUsuarioinexistente() {
	return usuarioinexistente;
}
public void setUsuarioinexistente(boolean usuarioinexistente) {
	this.usuarioinexistente = usuarioinexistente;
}
public boolean isUsuarioexistente() {
	return usuarioexistente;
}
public void setUsuarioexistente(boolean usuarioexistente) {
	this.usuarioexistente = usuarioexistente;
}

}
