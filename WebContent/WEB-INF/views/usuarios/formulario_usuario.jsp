<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Formulario usuario</title>
</head>
<body>

<center><h1>Cadastro de usuário</h1></center>

<div class="container">
<center>
	<form action="inserir_usuario" method="post">
	<br> <br>
	    <div class="form-group">
	    	<label for="lome"> Nome: </label>
			<input type="text" name="nome"> <br><br> 
		</div>
		<div class="form-group">
			<label for="login"> Login: </label>
			<input type="text" name="login"> <br><br>
		</div>
		<div class="form-group">
			<label for="senha"> Senha: </label>
			<input type="password" name="senha"> <br><br>
		</div>
		<div class="form-group">
			<label for="email"> Email: </label>
			<input type="text" name="email"> <br><br>
		</div>
		
		<button type="submit" class="btn btn-default"> Cadastrar </button><br>
	</form>
	</center>
</div>
	
</body>
</html>