<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<form method="post" action="LoginServlet">
		<input type="text" name="login" placeholder="login" required />
		
		<input type="password" name="senha" placeholder="senha"  required />
		
		<input type="submit" value="Logar" />
		
		<input type="reset" valuer="Limpar" />
		
	</form>
</body>
</html>