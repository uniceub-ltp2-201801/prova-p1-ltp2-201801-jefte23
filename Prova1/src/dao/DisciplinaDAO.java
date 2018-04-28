package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Disciplina;

public class DisciplinaDAO {
	
	// Atributo
	private Connection conexao;

	// Metodo construtor
	public DisciplinaDAO(Connection conexao) {
		this.conexao = conexao;
	}
	
	// Metodo que retorna Todos os Professores
	public ArrayList<Disciplina> getDisciplina() {
		
		// Instanciar os objetos
		PreparedStatement ps = null;
		ResultSet rs = null;

		ArrayList<Disciplina> disciplinas = new ArrayList<Disciplina>();

		try {

			// Preparar o SQL
			String sql = "SELECT * FROM faculdade.disciplina order by nomeDisciplina";
			ps = conexao.prepareStatement(sql);

			// Executar o SQL
			rs = ps.executeQuery();

			// Criar cliente com base no rs
			rs.first();

			while (rs.next()) {
				Disciplina d = new Disciplina(rs.getInt("idDisciplina"), 
						rs.getString("nomeDisciplina"), rs.getInt("cargaHoraria"), rs.getInt("idProfessor")); 
				disciplinas.add(d);
			}
			
			
			rs.close();
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return disciplinas;

	}

}
