package vamo.model;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
@Entity
@Table
public class Concerto {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@NotNull
	 private  int idconcerto;
	@Column(nullable=false)
	@NotNull
private int numerodareclamacao;
	@Column(nullable=false)
private String data=new SimpleDateFormat("yyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
	@Column(nullable=false)
	@NotNull
private double valordoconserto;
	
	 
public Concerto() {
		
	}
public int getIdconcerto() {
		return idconcerto;
	}
	public void setIdconcerto(int idconcerto) {
		this.idconcerto = idconcerto;
	}
public int getNumerodareclamacao() {
	return numerodareclamacao;
}
public void setNumerodareclamacao(int numerodareclamacao) {
	this.numerodareclamacao = numerodareclamacao;
}
public String getData() {
	return data;
}
public void setData(String data) {
	this.data = data;
}
public double getValordoconserto() {
	return valordoconserto;
}
public void setValordoconserto(double valordoconserto) {
	this.valordoconserto = valordoconserto;
}
@Override
public String toString() {
	return "Concerto [idconcerto=" + idconcerto + ", numerodareclamacao=" + numerodareclamacao + ", data=" + data
			+ ", valordoconserto=" + valordoconserto + "]";
}


}
