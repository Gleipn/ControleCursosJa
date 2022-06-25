<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Incluir Professor</title>
</head>
<body>
	<form method="post" action="IncluirProfessor">
	
		<input type="text" name="inputNome"
		placeholder="Informe o nome do professor" required/><br>
		
		<input type="text" name="inputCelular"
		placeholder="Informe o celular" required/><br>
		
		<input type="text" name="inputValorHora"
		placeholder="Informe o valor/hora" required/><br>
		
		<input type="submit" value="Ok"/>
		<input type="reset" value="Limpar"/>
		
	</form>

</body>
</html>