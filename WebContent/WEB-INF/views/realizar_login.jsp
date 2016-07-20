<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Login</title>
</head>
<body>

<div class="container">
<center>
	<form action="verifica_login" method="post">
		<div class="form-group">
			<label for="login"> Login:</label> <br>
			<input type="text" name="login" class="form-control">
		</div>
		<div class="form-group">
			<label for="senha"> Senha:</label> <br> 
			<input type="password" name="senha" class="form-control">
			<br><button type="submit" class="btn btn-default"> Logar</button>
		</div>
	</form>
</center>
</div>
	
</body>
</html>