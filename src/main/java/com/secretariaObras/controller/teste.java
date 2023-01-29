package com.secretariaObras.controller;






import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.secretariaObras.model.DaoGeneric;
import com.secretariaObras.model.Endereco;
import com.secretariaObras.model.Reclamacoes;
import com.secretariaObras.model.UsuariosAdministrativo;


public class teste implements DaoGeneric{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Reclamacoes rec = new Reclamacoes();
		Endereco end = new Endereco();
		Reclamacoes a = new Reclamacoes();
		UsuariosAdministrativo admin = new UsuariosAdministrativo();
		ArrayList<UsuariosAdministrativo> lista = new ArrayList<UsuariosAdministrativo>();
		ArrayList<UsuariosAdministrativo> lista2 = new ArrayList<UsuariosAdministrativo>();
		rec=DaoGeneric.SearchToId(rec,615);
		System.out.println(rec);
	}

}
