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
			
			System.out.println(conexao);
			
			ps = conexao.prepareStatement(sql);

			// Executar o SQL
			rs = ps.executeQuery();

			// Criar cliente com base no rs
			rs.first();
			
			while (rs.next()) {
				Professor p = new Professor(rs.getInt("idProfessor"), rs.getString("nomeProfessor"), 
						LocalDate.parse(rs.getString("dataNasc"), formatter) , rs.getString("nomeMae"), rs.getInt("titulação"));

				professores.add(p);
			}
			
			for (int i = 0; i < professores.size(); i++) {
				System.out.println(professores.get(i).getIdProfessor());
				
			}
			
			rs.close();
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return professores;

	}

}
