<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Noticias</title>
<style>
table, th, td {
    border: 1px solid black;
}
</style>
</head>
<body>

<h2>Noticias</h2>
	<table border="1">
	<c:forEach var="noticia" items="${noticias}">
		<tr>
			<td><a href="showNoticia?idNoticia=${noticia.idNoticia}">${noticia.titulo}</a></td>	
			<td>${noticia.secao.titulo}</td>
			<td>${noticia.data}</td>
			<c:if test="${papel.role == 'Jornalista'}">				
				<td><a href="apagarNoticia?idNoticia=${noticia.idNoticia}">APAGAR</a></td>			
			</c:if>
		</tr>
	</c:forEach>
	</table>
  
	
</body>
</html>