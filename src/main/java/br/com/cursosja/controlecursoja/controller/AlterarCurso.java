package br.com.cursosja.controlecursoja.controller;

import java.io.IOException;

import br.com.cursosja.controlecursoja.model.dao.CursoDao;
import br.com.cursosja.controlecursoja.model.entidade.Curso;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AlterarCurso
 */
public class AlterarCurso extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlterarCurso() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nome = request.getParameter("nome");
		String strValor = request.getParameter("mensalidade");
		
		long id = 0;
		
		try {
			id = Long.parseLong(request.getParameter("id"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		double valor = 0.0;
		try {
			valor = Double.parseDouble(strValor);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		Curso c = new Curso();
		c.setId(id);
		c.setNome(nome);
		c.setValor(valor);
		
		CursoDao dao = new CursoDao();
		boolean retorno = dao.alterar(c);
		
		response.sendRedirect("lista_curso.jsp");
	}

}
