package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import model.Professor;

public class ProfessorDAO {

	// Atributo
	private Connection conexao;

	// Metodo construtor
	public ProfessorDAO(Connection conexao) {
		this.conexao = conexao;
	}
	
	// Metodo que retorna Todos os Professores
	public ArrayList<Professor> getProfessor(){
		
		// Formato data e Hora
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
		// Instanciar os objetos
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Professor> professores = new ArrayList<Professor>();
		
		try {

			// Preparar o SQL
			String sql = "SELECT * FROM faculdade.professor order by NomeProfessor;";
			
			//System.out.println(conexao);
			
			ps = conexao.prepareStatement(sql);

			// Executar o SQL
			rs = ps.executeQuery();

			// Criar cliente com base no rs
			rs.first();
			
			while (rs.next()) {
				Professor p = new Professor(rs.getInt("idProfessor"), rs.getString("NomeProfessor"), 
						LocalDate.parse(rs.getString("DataNasc"), formatter) , rs.getString("NomeMae"), rs.getInt("Titulacao"));

				professores.add(p);
			}
			
			rs.close();
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return professores;

	}
	
	public Professor getUnicoProfessor(int idProfessor){
		
		// Formato data e Hora
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
		// Instanciar os objetos
		PreparedStatement ps = null;
		ResultSet rs = null;
		Professor resultado = null;
		
		try {

			// Preparar o SQL
			String sql = "SELECT * FROM faculdade.professor WHERE idProfessor= ?;";
			
			//System.out.println(conexao);
			
			ps = conexao.prepareStatement(sql);
			// Setar os parametros do SQL
			ps.setInt(1, idProfessor);

			// Executar o SQL
			rs = ps.executeQuery();

			// Criar cliente com base no rs
			rs.first();

			resultado = new Professor(rs.getInt("idProfessor"), rs.getString("NomeProfessor"), 
					LocalDate.parse(rs.getString("DataNasc"), formatter) , rs.getString("NomeMae"), rs.getInt("Titulacao"));
			
			rs.close();
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return resultado;

	}


}
