<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Noticia</title>
</head>
<body>
<center>
	<form action="adicionaComentario" method="post">
		<h1>${n.titulo}</h1>
		<h2>${n.subtitulo}</h2>
			${n.texto}
			
		
		Adicionar Comentário:	
		<textarea rows="5" cols="50" name="comentario"></textarea>
		<input type="hidden" value="${n.idNoticia}" name="idNoticia"/>
		<button type="submit" class="btn btn-default"> Comentar </button><br>
		
		</form>		
		 		
</center>

	
</body>
</html>