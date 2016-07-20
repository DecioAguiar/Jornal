<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Formulário Noticia</title>
</head>
<body>
<center>
	<form action="cadastrar_noticia">
		<br> <br>		
	    <div class="form-group">
	    	<label for="titulo"> Titulo: </label>
			<input type="text" name="titulo"> <br><br> 
		</div>
		<div class="form-group">
			<label for="subtitulo"> SubTitulo: </label>
			<input type="text" name="subtitulo"> <br><br>
		</div>
		<div class="form-group">
			<label for="data"> Data: </label>
			<input type="text" name="data"> <br><br>
		</div>
		<textarea rows="50" cols="50" name="texto"></textarea>
		<input type="hidden" name="id_jornalista" value="${usuario_logado.id}"/>
		<br>
		<select name="id_secao">
			<c:forEach var="secao" items="${secoes}">
				<option value="${secao.idSecao}">${secao.titulo}</option>
			</c:forEach>
		</select>
				
		<button type="submit" class="btn btn-default"> Cadastrar </button><br>
	</form>
</center>
</body>
</html>