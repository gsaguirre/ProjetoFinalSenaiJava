package br.com.senai.crudComSpring.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Anime {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "Título Obrigatório")
	private String titulo;
	
	@NotNull(message = "Gênero Obrigatório")
	private String genero;
	
	@DateTimeFormat(pattern = "yyyy")
	@NotNull(message = "Ano Obrigatório")
	private Date anoDeLancamento;
	
	@NotNull(message = "Autor Obrigatório")
	private String autor;
	
	@NotNull(message = "Descrição Obrigatória")
	@Size(min = 2, max = 500, message = "Mínimo 2 caractéres")
	private String descricao;
	
	@NotNull(message = "Url da Imagem Obrigatória")
	@Size(min = 2, max = 500, message = "Mínimo 2 caractéres")
	private String urlImagem;

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

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Date getAnoDeLancamento() {
		return anoDeLancamento;
	}

	public void setAnoDeLancamento(Date anoDeLancamento) {
		this.anoDeLancamento = anoDeLancamento;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getUrlImagem() {
		return urlImagem;
	}

	public void setUrlImagem(String urlImagem) {
		this.urlImagem = urlImagem;
	}
	
	
}
