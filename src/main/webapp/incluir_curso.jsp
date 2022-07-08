<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Incluir curso</title>
</head>
<body>
<jsp:include page="verificaSessao.jsp" />
	<form method="post" action="IncluirCurso">
	
		<input type="text" name="nomecurso"
		placeholder="Informe o nome do curso" required/><br>
		
		<input type="number" name="mensalidade" step="0.01"
		placeholder="Informe o valor" required/><br>
		
		<input type="submit" value="ok"/>
		<input type="reset" value="Limpar"/>
		
	</form>

</body>
</html>