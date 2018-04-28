package control;

import java.io.IOException;
import java.sql.Connection;

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
 * Servlet implementation class ServletExibirProfessor
 */
@WebServlet("/exibirProfessor")
public class ServletExibirProfessor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletExibirProfessor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		int idProfessor = Integer.parseInt(request.getParameter("idProfessor"));
				
		// Obter uma conexao com o BD
		Connection conexao = Conexao.getConexao();
		
		ProfessorDAO pd = new ProfessorDAO(conexao);
		
		Professor p = pd.getUnicoProfessor(idProfessor);
		
		request.getSession().setAttribute("professor", p);
		
		// Repassar o request/respose para o JSP
		RequestDispatcher rd = request.getRequestDispatcher("exibirprofessor.JSP");

		rd.forward(request, response);
	}

}
