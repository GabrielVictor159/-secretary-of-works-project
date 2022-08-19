package vamo.controller;

import java.util.ArrayList;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import vamo.model.DaoGeneric;
import vamo.model.Endereco;
import vamo.model.Reclamacoes;

@ManagedBean(name = "Lista")
@ApplicationScoped
public class ListaReclamacoesBean {
	private DaoAdministrativo daoadministrativo = new DaoAdministrativo();
	private Endereco endereco = new Endereco();
	private Reclamacoes reclamacao = new Reclamacoes();
	private ArrayList<Reclamacoes> reclamacoes = new ArrayList<Reclamacoes>();
	public void carregarReclamacoes() {
		reclamacoes = DaoGeneric.ListAll(reclamacao);
	}

	public void eliminarcoluna(Reclamacoes reclamacao) {
		reclamacoes.remove(reclamacao);
		DaoGeneric.Delete(reclamacao, reclamacao.getNumero());
	}

	public void editar(Reclamacoes reclama) {
		reclama.setEditing(true);
		if(reclama.getEndereco()!=null) {
		reclama.setConcertoediting(true);
		}
	}

	public void update(Reclamacoes rec) {
		DaoAdministrativo.updatereclamacao(rec);
		rec.setEditing(false);
		if(rec.getEndereco()!=null) {
			rec.setConcertoediting(false);
			}
	}

	public DaoAdministrativo getDaoadministrativo() {
		return daoadministrativo;
	}

	public void setDaoadministrativo(DaoAdministrativo daoadministrativo) {
		this.daoadministrativo = daoadministrativo;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Reclamacoes getReclamacao() {
		return reclamacao;
	}

	public void setReclamacao(Reclamacoes reclamacao) {
		this.reclamacao = reclamacao;
	}

	public ArrayList<Reclamacoes> getReclamacoes() {
		return reclamacoes;
	}

	public void setReclamacoes(ArrayList<Reclamacoes> reclamacoes) {
		this.reclamacoes = reclamacoes;
	}
	
}
