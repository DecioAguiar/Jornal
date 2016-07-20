package br.ufc.interceptor;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import br.ufc.dao.UsuarioDAO;
import br.ufc.model.Role;
import br.ufc.model.Usuario;

public class Interceptador extends HandlerInterceptorAdapter {
	
	@Autowired
	private UsuarioDAO udao;
	
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException{
		
		HttpSession session = request.getSession();
		String uri = request.getRequestURI();
		
		if (uri.endsWith("/") || uri.endsWith("realizar_login") || uri.endsWith("pagina_noticias") ||
			uri.endsWith("showNoticia") || uri.endsWith("home") || uri.endsWith("listar_classificados")||
			uri.endsWith("formulario_usuario")||uri.endsWith("noticias")|| uri.endsWith("verifica_login") || uri.endsWith("inserir_usuario")){
			return true;
		}
		
		if (request.getSession().getAttribute("user_logado") != null){
			Usuario dum = (Usuario) session.getAttribute("user_logado");
			Usuario user = udao.buscaPorId(dum.getId());
			Collection<Role> papeis = user.getRoleList();
			if(papeis != null){
				for(Role p : papeis){
					if(p.getRole().equals("Usuario") && ( uri.endsWith("pagina_noticias")||uri.endsWith("noticias")|| uri.endsWith("/") || uri.endsWith("logout") ||
					   uri.endsWith("inserir_oferta") || uri.endsWith("formularioInserirOferta")|| uri.endsWith("listar_classificados") ||uri.endsWith("validar_oferta")||
					   uri.endsWith("inserirComentario")|| uri.endsWith("verifica_login") )){
						return true;
					}
					if(p.getRole().equals("Jornalista") && ( uri.endsWith("/")||uri.endsWith("formulario_noticia")|| uri.endsWith("logout") ||
					   uri.endsWith("cadastrar_noticia") || uri.endsWith("showNoticia") || uri.endsWith("apagarNoticia")|| uri.endsWith("verifica_login") || uri.endsWith("realizar_login") || uri.endsWith("pagina_noticias") ||
						uri.endsWith("showNoticia") || uri.endsWith("home") || uri.endsWith("formulario_usuario")||uri.endsWith("noticias")|| uri.endsWith("verifica_login")|| 
						uri.endsWith("inserir_oferta") || uri.endsWith("formularioInserirOferta")|| uri.endsWith("listar_classificados") ||uri.endsWith("validar_oferta"))){
						return true;
					}
					if((p.getRole().equals("Editor")) && ( uri.endsWith("formulario_jornalista") || uri.endsWith("logout") ||
					   uri.endsWith("formulario_classificado") || uri.endsWith("formulario_secao") || 
					   uri.endsWith("showNoticia") || uri.endsWith("formulario_classificado") || uri.endsWith("cadastrar_classificado") ||
					   uri.endsWith("cadastrar_secao") || uri.endsWith("apagarNoticia")|| uri.endsWith("verifica_login") )){
						System.out.println("Entrou aqui");
						return true;
					}
				}
			}		
		}
		
		//response.sendRedirect("realizar_login");
		return true;
	}
}
