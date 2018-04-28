package control;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.Conexao;
import dao.ProfessorDAO;
import model.Professor;

/**
 * Servlet implementation class ServeletListarProfessores
 */
@WebServlet("/listarProfessores")
public class ServeletListarProfessores extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServeletListarProfessores() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {	
		
		// Obter uma conexao com o BD
		Connection conexao = Conexao.getConexao();
		
	
		// Instanciar objeto CadastraTransacaoDAO
		ProfessorDAO p = new ProfessorDAO(conexao);
		
		// Obter conta
		ArrayList<Professor> professores = p.getProfessor();
		
		// Criar atributo novo
		request.setAttribute("professores", professores);

		RequestDispatcher rd = request.getRequestDispatcher("listarProfessores.jsp");
		rd.forward(request, response);
	
	}

}
