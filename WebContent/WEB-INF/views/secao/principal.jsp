<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Seção principal</title>
</head>
<body>

	<ul id="menu">
		<div id="menu-div">
			<li class='item-menu'> <a href="pagina_principal">Home</a></li>
			<li class='item-menu'> Funcionalidades
				<ul id="submenu">
					<c:forEach var="papel" items="${usuario_logado.roleList }">
						<c:if test="${papel.role == 'Editor' }">
							<li><a href="formulario_jornalista"> Cadastrar jornalista </a></li>
							<li><a href="formulario_secao"> Cadastrar seção </a></li>
							<li><a href="formulario_classificado"> Cadastrar classificado</a></li>
						</c:if>
						
						<c:if test="${papel.role == 'Jornalista' }">				
							<li><a href="formulario_noticia?id=${usuario_logado.id }">Cadastrar notícia</a></li>
						</c:if>

					</c:forEach>
				</ul>
			</li>
			<li class='item-menu'> Noticias
				<ul id="submenu">
					<a href="noticias">Visualizar Noticias</a>
				</ul>
			</li>
			<li class='item-menu'> Classificados
				<ul id="submenu">
					<a href="listar_classificados"> Visualizar classificados </a>
				</ul>
			</li>
			<li class='item-logado'><a href="logout">Logout</a></li>
			<li class='item-logado'> ${usuario_logado.nome}</li>
		</div>
	</ul>
	
	
	
	<style>
		#submenu{
			margin-top:5px;
			width:100px;
			background-color: #ffffff;
			border:1px solid black;
			position:absolute;
			display:none;
		}
		#submenu li{
			width:100px;
			display:list-item;
			cursor:pointer;
		}
		#menu{
			margin-left:-8px;
			margin-top:-8px;
			margin-right:-8px;
			padding:10px;
			background-color: #cccccc;
		}
		#menu li.item-menu{
			float: left;
			background-color: #cccccc;
			display:inline;
			position:relative;	
			padding: 5px;
			transition: all 0.3s;
		}
		#menu li.item-logado{
			font-size: 10px;
			background-color:#cccccc;
			display:inline;
			margin-top:-8px;
			margin-right:-8px;
			padding:10px;
			float: right;
		}
		#menu li.item-logado:hover{
			background-color:#ffffff;
			transform: scale(1.2,1.1);
			transition: all 0.3s;
		}
		#menu li.item-menu:hover{
			background-color:#ffffff;
			transform: rotateY(360deg);
			transition: all 0.2s;
		}
		#menu li.item-menu:hover #submenu{
			display:block;
		}
		#submenu li{
			width:130px;
			margin-left:-40px;
			list-style:none;
			padding:5px;
		}
		#submenu li:hover{
			background-color:#dddddd;
		}
		
	</style>
	
</body>
</html>