<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>

<title>Cadastrando Classificado</title>
</head>
<body>

<center><h1> Cadastrando Classificado</h1></center>

<div class="container">
	<form action="cadastrar_classificado" method="post">
	<br> <br>
	    <div class="form-group">
	    	<label for="titulo"> Titulo: </label>
			<input type="text" name="titulo"> <br><br> 
		</div>
		<div class="form-group">
			<label for="texto"> Texto: </label>
			<input type="text" name="texto"> <br><br>
		</div>
		<div class="form-group">
			<label for="preco"> Preco: </label>
			<input type="text" name="preco"> <br><br>
		</div>
		<div class="form-group">
			<label for="telefone"> Telefone: </label>
			<input type="text" name="telefone"> <br><br>
		</div>
		<div class="form-group">
			<label for="dataOferta"> Data: </label>
			<input type="text" name="dataOferta"> <br><br>
		</div>
		<button type="submit" class="btn btn-default"> Cadastrar </button><br>
	</form>
</div>



</body>
</html>