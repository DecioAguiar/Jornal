package br.ufc.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufc.dao.SecaoDAO;
import br.ufc.model.Secao;

@Transactional
@Controller
public class SecaoController {
	
	@Autowired
	private SecaoDAO sDAO;
	
	@RequestMapping("pagina_principal")
	public String paginaPrincipal(Model model){
		List<Secao> secoes = sDAO.listar();
		model.addAttribute("secoes", secoes);
		return "home";
	}
	
	@RequestMapping("secao_principal")
	public String secaoPrincipal(Model model){
		List<Secao> secoes = sDAO.listar();
		model.addAttribute("secoes", secoes);
		return"secao/principal";
	}
	@RequestMapping("cadastrar_secao")
	public String cadastrarSecao(Secao secao, Model model){
		if(sDAO.buscarPorTitulo(secao)==null){
			this.sDAO.cadastrar(secao);
		} else {
			if(secao.equals(sDAO.buscarPorTitulo(secao))){
				this.sDAO.cadastrar(secao);
			} else {
				System.out.println("Sessão já cadastrada");
			}
		}
		return "redirect:secao_principal";
	}
	
	@RequestMapping("formulario_secao")
	public String formularioSecao(){
		return "secao/formulario_secao";
	}
	
	@RequestMapping("logout")
	public String logout(HttpSession session){
		session.setAttribute("usuario_logado", null);
		return"home";
	}
}
