package br.ufc.dao;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.ufc.model.Usuario;
import sun.misc.BASE64Encoder;

@org.springframework.transaction.annotation.Transactional
@Repository
public class UsuarioDAO {
	
	@PersistenceContext
	private EntityManager manager;
	
	public void cadastrar(Usuario usuario){
		this.manager.persist(usuario);
	}
	
	public void remover(Long id_usuario){
		Usuario u = this.manager.find(Usuario.class, id_usuario);
		this.manager.remove(u);
	}
	
	public void alterar(Usuario usuario){
		this.manager.merge(usuario);
	}
	
	public List<Usuario> listar(){
		String hql = "SELECT u FROM Usuario u";
		return this.manager.createQuery(hql, Usuario.class).getResultList();
	}
	
	public Usuario buscaPorId(Long id_usuario){
		Usuario u = this.manager.find(Usuario.class, id_usuario);
		return u;
	}
	
	public Usuario getUsuario(Usuario usuario){
		String hql = "SELECT u FROM Usuario u WHERE u.login='"+ usuario.getLogin()+"'";
		List<?> res = this.manager.createQuery(hql).getResultList();
		if(!res.isEmpty()){
			return (Usuario) this.manager.createQuery(hql).getResultList().get(0);
		}
		return null;
	}
	
	public String criptografarSenha(String senha){
		try {
			MessageDigest algorithm = MessageDigest.getInstance("MD5");
			BASE64Encoder encoder = new BASE64Encoder();
			return encoder.encode(algorithm.digest());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return senha;
		}

	} 
}
