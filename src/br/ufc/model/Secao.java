package br.ufc.model;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="secao")
public class Secao {
	@Id
	@Column(name="id_secao")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idSecao;
	
	@Column(name = "titulo", nullable=false)
	private String titulo;
	
	@Column(name="descricao")
	private String descricao;
	
	@OneToMany(mappedBy="secao",targetEntity = Noticia.class, fetch=FetchType.EAGER)
	private  Collection<Noticia> noticias;
	
	public Long getIdSecao() {
		return idSecao;
	}

	public void setIdSecao(Long idSecao) {
		this.idSecao = idSecao;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	@Override
	public String toString(){
		return "Secao [idSecao=" + idSecao + ", titulo=" + titulo
				+ ", descricao=" + descricao + ", noticias=" + noticias + "]";
	}
}
