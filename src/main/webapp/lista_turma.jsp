<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="br.com.cursosja.controlecursoja.model.dao.TurmaDao" %>
<%@ page import="br.com.cursosja.controlecursoja.model.entidade.Turma" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.SimpleDateFormat" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Lista de Turmas</h1>
	<a href="incluir_turma.jsp">Incluir Turma</a><br>
	<table>
		<thead>
			<tr>
				<th>Curso</th>
				<th>Data de início</th>
				<th>Data de Término</th>
				<th>Professor</th>
			</tr>
		</thead>
		
		<tbody>
			<%
				TurmaDao dao = new TurmaDao();
				List<Turma> turmas = dao.listar();
				SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
				for (Turma t: turmas) {
			%>
			<tr>
				<td><%= t.getCurso().getNome() %></td>
				<td><%= fmt.format(t.getDataInicio()) %></td>
				<td><%= fmt.format(t.getDataFim()) %></td>
				<td><%= t.getProfessor().getNome() %></td>
			</tr>
			<% } %>
		</tbody>
		</table>
</body>
</html>