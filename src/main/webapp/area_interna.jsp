<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="br.com.cursosja.controlecursoja.model.entidade.Usuario" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="verificaSessao.jsp" />
	<%
		Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
	%>
	<h1>Olá, <%= usuario.getNome() %></h1><br>
	
	<a href="lista_turma.jsp">Listar Turma</a>
	
	<a href="lista_curso.jsp">Listar Curso</a><br>
	
	<a href="lista_professor.jsp">Listar Professor</a><br>
	
	<a href="LogoutServlet">Sair</a>
	
</body>
</html>