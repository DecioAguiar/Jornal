package br.ufc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.ufc.model.Comentario;

@Repository
public class ComentarioDAO {
	
	@PersistenceContext
	private EntityManager manager;
	
	public void cadastrar(Comentario comentario){
		this.manager.persist(comentario);
	}
	
	public void remover(Comentario comentario){
		Comentario c = this.manager.find(Comentario.class, comentario);
		this.manager.remove(c);
	}
	
	public List<Comentario> listar(){
		String hql = "SELECT c FROM Comentario c";
		return this.manager.createQuery(hql,Comentario.class).getResultList();
	}
	
	public List<Comentario> listarPorNoticia(Long id_noticia){
		String hql = "SELECT c FROM Comentario c WHERE noticia='" + id_noticia+"'";
		return this.manager.createQuery(hql, Comentario.class).getResultList();
	}
}
