package br.ufc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufc.dao.RolesDAO;
import br.ufc.dao.SecaoDAO;
import br.ufc.dao.UsuarioDAO;
import br.ufc.model.Role;
import br.ufc.model.Secao;
import br.ufc.model.Usuario;

@org.springframework.transaction.annotation.Transactional
@Controller
public class UsuarioController {
	
	@Autowired
	private UsuarioDAO uDAO;
	@Autowired
	private RolesDAO rolesDAO;
	@Autowired
	private SecaoDAO sDAO;
	
	@RequestMapping("formulario_usuario")
	public String formularioInserir(){
		return "usuarios/formulario_usuario";
	}
	
	@RequestMapping("inserir_usuario")
	public String inserirUsuario(Usuario usuario){
		String novaSenha;		
		Role role = new Role();
		role.setId(3L);
		
		//Inicializa a lista de papeis do usuario
		List<Role> papeis = new ArrayList<Role>();
		papeis.add(rolesDAO.getRole(role));
		
		//Alterar a senha do Objeto setando a criptografada
		usuario.setRoleList(papeis);
		novaSenha = uDAO.criptografarSenha(usuario.getSenha());
		usuario.setSenha(novaSenha);
		
		uDAO.cadastrar(usuario);
		return"home";
	}
	
	@RequestMapping("cadastrar_jornalista")
	public String cadastrarJornalista(Usuario usuario){
		Role role = new Role();
		role.setId(2L);
		
		List<Role> papeis = new ArrayList<Role>();
		
		papeis.add(rolesDAO.getRole(role));
		
		String novaSenha = uDAO.criptografarSenha(usuario.getSenha());
		usuario.setSenha(novaSenha);
		/**
		if(!file.isEmpty()){
			try {
				String nomeImg = new Date(0).getTime()+"-"+file.getOriginalFilename();
				String imagem = "C:/Users/Décio Aguiar/Pictures/Jornal"+nomeImg;
				usuario.setCaminho(nomeImg);
				byte[] bytes = file.getBytes();
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new java.io.File(imagem)));
				stream.write(bytes);
				stream.close();
			} catch (Exception e) {
				e.printStackTrace();
				return "";
			}
		} else {
			return "";
		}
		*/
		usuario.setRoleList(papeis);
		
		uDAO.cadastrar(usuario);
		return "principal";
	}
	
	@RequestMapping("realizar_login")
	public String relizaLogin(){
		return"realizar_login";
	}
	
	@RequestMapping("formulario_jornalista")
	public String formularioJornalista(){
		return "usuarios/formulario_jornalista";
	}
	
	@RequestMapping("verifica_login")
	public String verificaLogin(Usuario usuario, HttpSession session, Model model){
		List<Secao> secoes = sDAO.listar();
		model.addAttribute("secoes", secoes);
		
		if(uDAO.getUsuario(usuario) != null){
			String senha;
			senha = uDAO.criptografarSenha(usuario.getSenha());
			if(senha.equals(uDAO.getUsuario(usuario).getSenha())){
				session.setAttribute("usuario_logado", uDAO.getUsuario(usuario));
				return "secao/principal";
			} else {
				return "redirect:realizar_login";
			} 
		} else {
			return "redirect:realizar_login";
		}	
	} 
}