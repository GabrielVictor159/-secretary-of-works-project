package vamo.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@Entity
@Table
public class Reclamacoes{
	@Id
	@NotNull
private int numero;
	@ManyToOne
	@JoinColumn(name = "Endereco_Id", nullable=true)
private Endereco endereco;
	@OneToOne
	@JoinColumn(name = "Concerto_Id")
private Concerto concerto;
	@Column(nullable=false)
	@NotNull
private String data= new SimpleDateFormat("yyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
	@Column(nullable=false)
	@NotNull
private String localidade;
	@Column(nullable=false)
	@NotNull
	@Size(min=1, max=10)
private int tamanho;
	@Transient
	private transient boolean editing=false;
	@Transient
	private transient boolean concertoediting=false;


public Reclamacoes() {
	}


public Reclamacoes(@NotNull int numero,@NotNull @Size(min = 1, max = 10) int tamanho,  @NotNull String localidade) {
	super();
	this.numero = numero;
	this.localidade = localidade;
	this.tamanho = tamanho;
}


public boolean isConcertoediting() {
	return concertoediting;
}


public void setConcertoediting(boolean concertoediting) {
	this.concertoediting = concertoediting;
}


public boolean isEditing() {
	return editing;
}


public void setEditing(boolean editing) {
	this.editing = editing;
}


public int getNumero() {
	return numero;
}
public void setNumero(int numero) {
	this.numero = numero;
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
public String getData() {
	return data;
}
public void setData(@NotNull String data) {
	this.data = data;
}
public String getLocalidade() {
	return localidade;
}
public void setLocalidade(@NotNull String localidade) {
	this.localidade = localidade;
}

public int getTamanho() {
	return tamanho;
}


public void setTamanho(@NotNull @Size(min = 1, max = 10)int tamanho) {
	
	if(tamanho<=10 && tamanho>=1) {this.tamanho = tamanho;
	}
	}



@Override
public String toString() {
	return "Reclamacoes [numero=" + numero  + endereco + " concerto=" + concerto + " data=" + data
			+ " localidade=" + localidade + " tamanho=" + tamanho + "]";
}


}
