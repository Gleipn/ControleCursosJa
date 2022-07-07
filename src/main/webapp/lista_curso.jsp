<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="br.com.cursosja.controlecursoja.model.dao.CursoDao" %>
<%@ page import="br.com.cursosja.controlecursoja.model.entidade.Curso" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.DecimalFormat" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listagem de Cursos</title>
</head>
<body>
		
		<%
			String nomeBusca = "";
			
			if(request.getParameter("nomeBusca") != null){
				nomeBusca = request.getParameter("nomeBusca");
			}
		%>
		
		<h1>Lista de cursos</h1>
		
		<form method="post" action="lista_curso.jsp">
			<input type="text" name="nomeBusca" value="<%= nomeBusca %>" />
			<input type="submit" value="Buscar" />
		</form>
		
		<table>
			<thead>
				<tr>
					<th>Nome</th>
					<th>Mensalidade</th>
					<th>Ações</th>
				</tr>
			</thead>
			
			<tbody>
				<%
					CursoDao dao = new CursoDao();
				
					List<Curso> cursos = dao.listar(nomeBusca);
					
					DecimalFormat fmt = new DecimalFormat("###,##0.00");
					for (Curso c: cursos) {
						String strValor = fmt.format(c.getValor());
				%>
				<tr>
					<td><%= c.getNome() %></td>
					<td><%= strValor %></td>
					<td>
					<a href="IniciarAlterarCurso?id=<%= c.getId() %>">Alterar</a>
					<a href="ExcluirCurso?id=<%= c.getId() %>" 
						onclick="return confirm('Deseja excluir esse registro?');">
							Excluir</a>
					</td>
				</tr>
				<% } %>
			</tbody>
		</table>
</body>
</html>