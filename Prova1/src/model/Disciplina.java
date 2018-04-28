package model;

public class Disciplina {
	
	// Atributos
	private int idDisciplina;
	private String NomeDisciplina;
	private int cargaHoraria;
	private int idProfessor;
		


	// Metodo Construtor
	public Disciplina(int idDisciplina, String nomeDisciplina, int cargaHoraria, int idProfessor) {
		super();
		this.idDisciplina = idDisciplina;
		NomeDisciplina = nomeDisciplina;
		this.cargaHoraria = cargaHoraria;
		this.idProfessor = idProfessor;
	}
	
	// Metodos get's e set's
	public int getIdDisciplina() {
		return idDisciplina;
	}
	public void setIdDisciplina(int idDisciplina) {
		this.idDisciplina = idDisciplina;
	}
	public String getNomeDisciplina() {
		return NomeDisciplina;
	}
	public void setNomeDisciplina(String nomeDisciplina) {
		NomeDisciplina = nomeDisciplina;
	}
	public int getCargaHoraria() {
		return cargaHoraria;
	}
	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}
	
	public int getIdProfessor() {
		return idProfessor;
	}

	public void setIdProfessor(int idProfessor) {
		this.idProfessor = idProfessor;
	}

}
