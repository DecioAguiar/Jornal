package br.ufc.controller;

import java.util.Collection;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.ufc.dao.NoticiaDAO;
import br.ufc.dao.SecaoDAO;
import br.ufc.dao.UsuarioDAO;
import br.ufc.model.Comentario;
import br.ufc.model.Noticia;
import br.ufc.model.Secao;
import br.ufc.model.Usuario;

@Transactional
@Controller
public class NoticiaController {
	
	@Autowired
	private NoticiaDAO uNot;
	
	@Autowired
	private UsuarioDAO uDAO;
	
	@Autowired
	private SecaoDAO sDAO;
	
	@RequestMapping("cadastrar_noticia")
	public String cadastrarNoticia(Noticia noticia, @RequestParam(required = true) Long id_jornalista, @RequestParam(required=true) Long id_secao){
		Usuario jornalista = uDAO.buscaPorId(id_jornalista);
		noticia.setUsuario(jornalista);
		
		Secao secao = sDAO.buscarPorId(id_secao);
		noticia.setSecao(secao);
		
		uNot.cadastrar(noticia);
		
		return "redirect:secao_principal";
	}		
	
	@RequestMapping("formulario_noticia")
	public String formularioNoticia(Model model){
		model.addAttribute("secoes", sDAO.listar());
		return "noticia/formulario_noticia";
	}
	
	@RequestMapping("noticias")
	public String noticias(Model model, Long id_jornalista){
		model.addAttribute("noticias", uNot.listar());
		return "noticia/pagina_noticias";
	}
	
	@RequestMapping("apagarNoticia")
	public String apagarNoticia(@RequestParam(required=true) Long idNoticia){
		uNot.remover(idNoticia);
		return"redirect:noticias";
	}
	
	@RequestMapping("showNoticia")
	public String showNoticia(@RequestParam(required=true) Long idNoticia, Model model){
		Noticia n = uNot.buscaPorId(idNoticia);
		model.addAttribute("n",n);
		model.addAttribute("comentarios",n.getComentarios());
		return "noticia/showNoticia";
	}
	@RequestMapping("adicionaComentario")
	public String adicionaComentario(HttpSession session,@RequestParam(required=true) Long idNoticia, @RequestParam(required=true) String comentario){
		System.out.println(idNoticia);
		Noticia n = uNot.buscaPorId(idNoticia);
		Usuario u = (Usuario) session.getAttribute("usuario_logado");
		
		Comentario c = new Comentario();
		c.setTexto(comentario);
		c.setNoticia(n);
		c.setAutor(u);
		Collection<Comentario> com = n.getComentarios();
		com.add(c);
		return "redirect:showNoticia?idNoticia="+idNoticia;
	}

}
