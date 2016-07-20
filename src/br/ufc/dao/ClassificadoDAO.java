package br.ufc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.ufc.model.Classificado;

@Repository
public class ClassificadoDAO {
	
	@PersistenceContext
	private EntityManager manager;
	
	public void cadastrar(Classificado classificado){
		this.manager.persist(classificado);
	}
	
	public void remover(Long id_classificado){
		Classificado c = this.manager.find(Classificado.class, id_classificado);
		this.manager.remove(c);
	}
	
	public void alterar(Classificado classificado){
		this.manager.merge(classificado);
	}
	
	public List<Classificado> listar(){
		String hql = "SELECT c FROM Classificado c";
		return this.manager.createQuery(hql, Classificado.class).getResultList();
	}
	
	public Classificado buscarPorId(Long id_classificado){
		Classificado c = this.manager.find(Classificado.class, id_classificado);
		return c;
	}
}