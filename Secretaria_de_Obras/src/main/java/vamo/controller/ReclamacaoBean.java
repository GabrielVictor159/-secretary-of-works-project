package vamo.controller;

import vamo.model.Concerto;
import vamo.model.DaoGeneric;
import vamo.model.Endereco;
import vamo.model.Reclamacoes;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name="agoravai")
@ViewScoped
public class ReclamacaoBean implements DaoGeneric{
	private Endereco endereco= new Endereco();
	private Concerto concerto= new Concerto();
	private Reclamacoes reclamacoes= new Reclamacoes();
	private List<Endereco> enderecos = new ArrayList<>();
	Random gerador = new Random();
	int numero = gerador.nextInt(100000);
	private Reclamacoes re= new Reclamacoes();
	private Endereco en;
	private boolean mostrardiv1 = true;
	private boolean mostrardiv2 = false;
	private boolean mostrardiv3 = false;
	private boolean mostrardiv4 = false;
	
	public boolean isMostrardiv4() {
		return mostrardiv4;
	}
	public void setMostrardiv4(boolean mostrardiv4) {
		this.mostrardiv4 = mostrardiv4;
	}
	public boolean isMostrardiv3() {
		return mostrardiv3;
	}
	public void setMostrardiv3(boolean mostrardiv3) {
		this.mostrardiv3 = mostrardiv3;
	}
	public boolean isMostrardiv1() {
		return mostrardiv1;
	}
	public void setMostrardiv1(boolean mostrardiv1) {
		this.mostrardiv1 = mostrardiv1;
	}
	public boolean isMostrardiv2() {
		return mostrardiv2;
	}
	public void setMostrardiv2(boolean mostrardiv2) {
		this.mostrardiv2 = mostrardiv2;
	}
	public ReclamacaoBean() {
	}
	public String persistirendereco() {
		this.mostrardiv2=true;
		this.mostrardiv1=false;
		return "";
	}
	public String settamanho() {
		this.mostrardiv2=false;
		this.mostrardiv3=true;
		return "";
	}
	public String localidade(String local) {
		
		reclamacoes.setLocalidade(local);
		reclamacoes.setNumero(numero);
		reclamacoes.setEndereco(endereco);
        DaoGeneric.persist(endereco);
        DaoGeneric.persist(reclamacoes);
        re=DaoGeneric.SearchToId(reclamacoes, numero);
        this.mostrardiv3=false;
        this.mostrardiv4=true;
        return "";
		
	}
	public String apagarregistro() {
        DaoGeneric.Delete(reclamacoes, numero);
		return "index";
	}
	
	public Reclamacoes getRe() {
		return re;
	}
	public void setRe(Reclamacoes re) {
		this.re = re;
	}
	public Endereco getEn() {
		return en;
	}
	public void setEn(Endereco en) {
		this.en = en;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public Concerto getConcerto() {
		return concerto;
	}
	public void setConcerto(Concerto concerto) {
		this.concerto = concerto;
	}
	public Reclamacoes getReclamacoes() {
		return reclamacoes;
	}
	public void setReclamacoes(Reclamacoes reclamacoes) {
		this.reclamacoes = reclamacoes;
	}
	
	
}
