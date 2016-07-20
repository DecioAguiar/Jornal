package br.ufc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="classificado")
public class Classificado {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name="titulo")
	private String titulo;
	
	@Column(name="texto")
	private String texto;
	
	@Column(name="preco")
	private Double preco;
	
	@Column(name="telefone")
	private String telefone;
	
	@Column(name="data_oferta")
	private String dataOferta;
	
	@ManyToOne(optional=true)
	@JoinColumn(name="id_autor", referencedColumnName="id", nullable=true)
	private Usuario usuario;
	
	@Column(name="melhor_oferta")
	private Float melhor_oferta;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getDataOferta() {
		return dataOferta;
	}

	public void setDataOferta(String dataOferta) {
		this.dataOferta = dataOferta;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Float getMelhor_oferta() {
			return melhor_oferta;
	}

	public void setMelhor_oferta(Float melhor_oferta) {
		this.melhor_oferta = melhor_oferta;
	}
	
	
}
