<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="br.com.cursosja.controlecursoja.model.entidade.Professor" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<%
		Professor professor = (Professor) request.getAttribute("professor");
	%>
	<form method="post" action="AlterarProfessor">
		<input type="hidden" name="id" value="<%= professor.getId()  %>"/>
		
		<input type="text" name="nome" value="<%= professor.getNome()  %>" required/>
		
		<input type="text" name="celular" value="<%= professor.getCelular()  %>" required/>
		
		<input type="number" name="valorHora" step="0.01" 
				value="<%= professor.getValorHora()  %>" required/>
		
		<input type="submit" value="Editar"/>
		
		<input type="reset" value="Limpar"/>
		
	</form>
	
</body>
</html>