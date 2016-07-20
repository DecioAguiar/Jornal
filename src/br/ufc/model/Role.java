package br.ufc.model;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="role")
public class Role {
	
	@Id
	@Column(name="id", nullable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name="role", nullable=false)
	private String role;
	
	@ManyToMany(mappedBy="roleList",fetch=FetchType.EAGER)
	private Collection<Usuario> users;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Collection<Usuario> getUsers() {
		return users;
	}

	public void setUsers(Collection<Usuario> users) {
		this.users = users;
	}
	
	public boolean equals(String s){
		
		return true;
	}
	
	
}
