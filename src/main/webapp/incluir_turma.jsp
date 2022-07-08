<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="br.com.cursosja.controlecursoja.model.dao.CursoDao" %>
<%@ page import="br.com.cursosja.controlecursoja.model.entidade.Curso" %>
<%@ page import="br.com.cursosja.controlecursoja.model.dao.ProfessorDao" %>
<%@ page import="br.com.cursosja.controlecursoja.model.entidade.Professor" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<form method="post" action="IncluirTurma">
		
		<label for="curso">Curso</label>
		<select name="curso" id="curso" required>
		<%
			CursoDao daoC = new CursoDao();
		
			List<Curso> cursos = daoC.listar("");
		
		
			for (Curso c: cursos) {
			
		%>
		
		<option value="<%= c.getId() %>"><%= c.getNome() %></option>
		
		<% } %>
		</select>
		
		<label for="professor">Professor</label>
		<select name="professor" id="professor" required>
		<%
			ProfessorDao daoP = new ProfessorDao();
			
			List<Professor> professores = daoP.listar("");
			
			for(Professor c: professores) {
		
		%>
		
		<option value="<%= c.getId() %>"><%= c.getNome() %></option>
		
		<% } %>
		</select>
		
		<label for="inicio">Data de Inicio</label>
		<input type="date" id="inicio" name="inicio" required/>
		
		<label for="fim">Data de Término</label>
		<input type="date" id="fim" name="fim" required/>
		
		
		<input type="submit" value="Enviar" />
		<input type="reset" value="Limpar" />
	
	
	</form>
	
</body>
</html>