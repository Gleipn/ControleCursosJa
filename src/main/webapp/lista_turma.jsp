<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="br.com.cursosja.controlecursoja.model.dao.TurmaDao" %>
<%@ page import="br.com.cursosja.controlecursoja.model.entidade.Turma" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Lista de Turmas</h1>
	
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
				for (Turma t: turmas) {
			%>
			<tr>
				<td></td>
				<td><%= t.getDataInicio() %></td>
				<td><%= t.getDataFim() %></td>
				<td></td>
			</tr>
			<% } %>
		</tbody>
		</table>
</body>
</html>