package model;

import java.time.LocalDate;

public class Professor {

	// Atributos
	private int idProfessor;
	private String nomeProfessor;
	private LocalDate dataNasc;
	private String nomeMae;
	private int titulação;
	
	// Metodo construtor
	public Professor(int idProfessor, String nomeProfessor, LocalDate dataNasc, String nomeMae, int titulação) {
		super();
		this.idProfessor = idProfessor;
		this.nomeProfessor = nomeProfessor;
		this.dataNasc = dataNasc;
		this.nomeMae = nomeMae;
		this.titulação = titulação;
	}
	// Metodos Get's Set's
	public int getIdProfessor() {
		return idProfessor;
	}
	public void setIdProfessor(int idProfessor) {
		this.idProfessor = idProfessor;
	}
	public String getNomeProfessor() {
		return nomeProfessor;
	}
	public void setNomeProfessor(String nomeProfessor) {
		this.nomeProfessor = nomeProfessor;
	}
	public LocalDate getDataNasc() {
		return dataNasc;
	}
	public void setDataNasc(LocalDate dataNasc) {
		this.dataNasc = dataNasc;
	}
	public String getNomeMae() {
		return nomeMae;
	}
	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}
	public int getTitulação() {
		return titulação;
	}
	public void setTitulação(int titulação) {
		this.titulação = titulação;
	}
}
