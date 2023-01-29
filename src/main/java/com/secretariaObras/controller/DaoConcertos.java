package com.secretariaObras.controller;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.secretariaObras.model.Concerto;
import com.secretariaObras.model.DaoGeneric;
import com.secretariaObras.model.JPAUtil;
import com.secretariaObras.model.Reclamacoes;
import com.secretariaObras.model.UsuariosdeConcertos;


public class DaoConcertos {
	private boolean administrador=false;
	private boolean paginalogin=true;
	private boolean registrousuario=false;
	private boolean senhaerrada=false;
	private boolean usuarioinexistente=false;
	private boolean usuarioexistente=false;
	private boolean senhasdiferentes=false;
	private boolean reclamacaonaoexiste=false;
	private boolean sucessoreclamacao=false;
	private boolean concertojaexiste=false;
	private boolean paginadeconcerto=false;
	private Reclamacoes rec;
	public boolean logar(UsuariosdeConcertos admin) {
		ArrayList<UsuariosdeConcertos> lista = new ArrayList<UsuariosdeConcertos>();
		System.out.println(admin);
		try {
			lista=DaoGeneric.ListToEspecificAtribute(admin,"NomedoUsuario","=",admin.getNomedoUsuario());
//			verificação de usuario
			
//				senha correta
				if(lista.get(0).getSenhadoUsuario().equals(admin.getSenhadoUsuario())) {
					paginalogin=false;
					administrador=true;
					paginadeconcerto=true;
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
	public void Registrar(UsuariosdeConcertos admin, String senharegistro1, String senharegistro2) {
		if(senharegistro1.equals(senharegistro2)) {
		ArrayList<UsuariosdeConcertos> lista = new ArrayList<UsuariosdeConcertos>();
		ArrayList<UsuariosdeConcertos> lista2 = new ArrayList<UsuariosdeConcertos>();
		
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
	public boolean persistirConcerto(int numerodaReclamacao, Double valor) {
		EntityManager em = JPAUtil.getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		rec=em.find(Reclamacoes.class,numerodaReclamacao);
		if(rec==null) {
			reclamacaonaoexiste=true;
			et.commit();
			em.close();
			return false;
		}
		else {
			if(rec.getConcerto()==null) {
				Concerto con = new Concerto();
				con.setValordoconserto(valor);
				con.setNumerodareclamacao(numerodaReclamacao);
				DaoGeneric.persist(con);
				rec.setConcerto(con);
				sucessoreclamacao=true;
				et.commit();
				em.close();
				administrador=false;
				return true;
			}
			else {
				concertojaexiste=true;
				et.commit();
				em.close();
				return false;
			}
		}
	}
	
	public boolean isReclamacaonaoexiste() {
		return reclamacaonaoexiste;
	}
	public void setReclamacaonaoexiste(boolean reclamacaonaoexiste) {
		this.reclamacaonaoexiste = reclamacaonaoexiste;
	}
	public boolean isSucessoreclamacao() {
		return sucessoreclamacao;
	}
	public void setSucessoreclamacao(boolean sucessoreclamacao) {
		this.sucessoreclamacao = sucessoreclamacao;
	}
	public boolean isConcertojaexiste() {
		return concertojaexiste;
	}
	public void setConcertojaexiste(boolean concertojaexiste) {
		this.concertojaexiste = concertojaexiste;
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
	public boolean isSenhasdiferentes() {
		return senhasdiferentes;
	}
	public void setSenhasdiferentes(boolean senhasdiferentes) {
		this.senhasdiferentes = senhasdiferentes;
	}
	public boolean isPaginadeconcerto() {
		return paginadeconcerto;
	}
	public void setPaginadeconcerto(boolean paginadeconcerto) {
		this.paginadeconcerto = paginadeconcerto;
	}
	
}
