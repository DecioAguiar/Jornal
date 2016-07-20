package br.ufc.model;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="usuario")
public class Usuario {
	
	@Id
	@Column(name="id", nullable = false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name="login", nullable = false, unique=true)
	private String login;
	
	@Column(name="senha", nullable=false)
	private String senha;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="email")
	private String email;
	
	@Column(name="caminho")
	private String caminho;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(
			name="Usuario_Role",
			joinColumns= @JoinColumn(referencedColumnName="id", name="id_usuario"),
			inverseJoinColumns = @JoinColumn(referencedColumnName = "id", name="id_role")
			)
	private Collection<Role> roleList;
	
	@OneToOne(optional=false,cascade=CascadeType.ALL, mappedBy="usuario", targetEntity=Noticia.class)
	private Noticia noticia;
	
	@OneToMany(mappedBy="autor",targetEntity=Comentario.class,fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private Collection<Comentario> comentarios;
	
	@OneToMany(mappedBy = "usuario",targetEntity=Classificado.class, fetch=FetchType.LAZY)
	private Collection<Classificado> classificados;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public String getCaminho() {
		return caminho;
	}

	public void setCaminho(String caminho) {
		this.caminho = caminho;
	}

	public Collection<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(Collection<Role> roleList) {
		this.roleList = roleList;
	}

	public boolean is(String roleName){
		getRoleList();
		for (Role role : roleList) {
			if(role.getRole().equals(roleName)){
				return true;
			}
		}
		return false;
	}
	
	@Override
	public String toString(){
		return "Usuario [id=" + id + ", login=" + login + ", senha=" + senha
				+ ", nome=" + nome + ", email=" + email + "]";
	}

	public Noticia getNoticia() {
		return noticia;
	}

	public void setNoticia(Noticia noticia) {
		this.noticia = noticia;
	}

	public Collection<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(Collection<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	public Collection<Classificado> getClassificados() {
		return classificados;
	}

	public void setClassificados(Collection<Classificado> classificados) {
		this.classificados = classificados;
	}
	
	
}
