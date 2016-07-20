package br.ufc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.ufc.model.Secao;

@Repository
public class SecaoDAO {
	
	@PersistenceContext
	private EntityManager manager;
	
	public void cadastrar(Secao secao){
		this.manager.persist(secao);
	}
	
	public void remover(Long id_secao){
		Secao s = this.manager.find(Secao.class, id_secao);
		this.manager.remove(s);
	}
	
	public List<Secao> listar(){
		String hql = "SELECT s FROM Secao s";
		return this.manager.createQuery(hql, Secao.class).getResultList();
	}
	
	public Secao buscarPorId(Long id_secao){
		Secao s  = this.manager.find(Secao.class, id_secao);
		return s;
	}
	
	public Secao buscarPorTitulo(Secao secao){
		String hql = "SELECT s FROM Secao s WHERE s.titulo='"+secao.getTitulo()+"'";
		List<?> res = this.manager.createQuery(hql).getResultList();
		if(!res.isEmpty()){
			return (Secao) this.manager.createQuery(hql).getResultList().get(0);
		}
		return null;
	}
	
}
