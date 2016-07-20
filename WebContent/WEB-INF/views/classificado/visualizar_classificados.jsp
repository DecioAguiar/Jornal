<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Classificados</title>
</head>
<body>
	
	<c:forEach var="classificado" items="${classificados}">
		<h1> ${classificado.titulo } </h1>
		<h4> ${classificado.texto }</h4>
		<h5>Preço inicial: ${classificado.preco }</h5>
		<h5>Telefone: ${classificado.telefone }</h5>
		<h5>Melhor oferta: ${classificado.melhor_oferta }</h5>
		<h5>Data: ${classificado.dataOferta }</h5>
		<h5>Autor: ${classificado.usuario.nome }</h5>
		
		<form action="inserir_oferta">
			<input type="hidden" value="${classificado.id }" name="id_classificado"/>
			<input type="submit" value="Inserir oferta">
		</form> 
		<hr width="100%">
		<br><br>
	</c:forEach>
	
	<a href="pagina_principal"> voltar para menu principal</a>
		
</body>
</html>