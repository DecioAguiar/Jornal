package br.ufc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.ufc.model.Role;

@org.springframework.transaction.annotation.Transactional
@Repository
public class RolesDAO {
	
	@PersistenceContext
	private EntityManager manager;
	
	public void cadastrar(Role role){
		this.manager.persist(role);
	}
	
	public void remover(Long id_role){
		Role r = this.manager.find(Role.class, id_role);
		this.manager.remove(r);
	}
	
	public void alterar(Role role){
		this.manager.merge(role);
	}
	
	public List<Role> listar(){
		String hql = "SELECT r FROM Role r";
		return this.manager.createQuery(hql, Role.class).getResultList();
	}
	
	public Role getRole(Role r){
		String hql = "SELECT r FROM Role r WHERE r.id='"+r.getId()+"'";
		return (Role) this.manager.createQuery(hql).getResultList().get(0);
	}
	
	public Role buscarPorId(Long id_role){
		Role r = this.manager.find(Role.class, id_role);
		return r;
	}
	
}
