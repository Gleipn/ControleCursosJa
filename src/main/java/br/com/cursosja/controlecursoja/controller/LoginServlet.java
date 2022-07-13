package br.com.cursosja.controlecursoja.controller;

import java.io.IOException;

import br.com.cursosja.controlecursoja.model.dao.UsuarioDao;
import br.com.cursosja.controlecursoja.model.entidade.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		UsuarioDao dao = new UsuarioDao();
		
		Usuario usr = dao.logar(login, senha);
		
		String destino = "";
		if(usr != null) {
			//$_SESSION => PHP
			HttpSession sessao = request.getSession();
			sessao.setAttribute("usuarioLogado", usr);
			
			//System.out.println(usr.getLogin());
			destino = "area_interna.jsp";
		} else {
			System.out.println("Usuário inexistente");
			destino = "login.jsp";
		}
		
		response.sendRedirect(destino);
	}

}
