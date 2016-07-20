package br.ufc.model;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="noticia")
public class Noticia {
	
	@Id
	@Column(name="id_noticia")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idNoticia;
	
	@Column(name="titulo", nullable=false)
	private String titulo;
	
	@Column(name="subtitulo")
	private String subtitulo;
	
	@Column(name="texto", nullable=false)
	private String texto;
	
	@Column(name="caminho", nullable = true)
	private String caminho;
	
	@Column(name="data_noticia")
	private String data;
	
	@OneToOne
	@JoinColumn(name="id_autor")
	private Usuario usuario;
	
	@ManyToOne(optional=false)
	@JoinColumn(name="id_secao",referencedColumnName="id_secao")
	private Secao secao;
	
	@OneToMany(mappedBy="noticia",targetEntity=Comentario.class)
	private Collection<Comentario> comentarios;
	
	
	public Long getIdNoticia() {
		return idNoticia;
	}

	public void setIdNoticia(Long idNoticia) {
		this.idNoticia = idNoticia;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getSubtitulo() {
		return subtitulo;
	}

	public void setSubtitulo(String subtitulo) {
		this.subtitulo = subtitulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public String getCaminho() {
		return caminho;
	}

	public void setCaminho(String caminho) {
		this.caminho = caminho;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Secao getSecao() {
		return secao;
	}

	public void setSecao(Secao secao) {
		this.secao = secao;
	}
	
	@Override
	public String toString(){
		return "Noticia [idNoticia=" + idNoticia + ", titulo=" + titulo
				+ ", subtitulo=" + subtitulo + ", texto=" + texto + "]";
	}

	public Collection<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(Collection<Comentario> comentarios) {
		this.comentarios = comentarios;
	}
	
}
