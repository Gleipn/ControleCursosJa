package br.com.cursosja.controlecursoja.controller;

import java.io.IOException;

import br.com.cursosja.controlecursoja.model.dao.ProfessorDao;
import br.com.cursosja.controlecursoja.model.entidade.Professor;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AlterarProfessor
 */
public class AlterarProfessor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlterarProfessor() {
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
		String celular = request.getParameter("celular");
		String strValorHora = request.getParameter("valorHora");
		
		long id = 0;
		try {
			id = Long.parseLong(request.getParameter("id"));
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		double valorHora = 0.0;
		try {
			valorHora = Double.parseDouble(strValorHora);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		Professor c = new Professor();
		c.setId(id);
		c.setNome(nome);
		c.setCelular(celular);
		c.setValorHora(valorHora);
		
		ProfessorDao dao = new ProfessorDao();
		boolean retorno = dao.alterar(c);
		
		response.sendRedirect("lista_professor.jsp");
	}

}
