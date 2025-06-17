package net.weg.librarysystem.model;
import java.time.LocalDate;

public class Livro {
	private String titulo;
	private String autor;
	private int anoPublicacao;
	private String genero;
	
	public Livro() {
		this.titulo = "";
		this.autor = "";
		this.anoPublicacao = 0;
		this.genero = "";
	}
	
	public Livro(String titulo, String autor, int anoPublicacao, String genero) {
		this.titulo = titulo;
		this.autor = autor;
		this.anoPublicacao = anoPublicacao;
		this.genero = genero;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getAutor() {
		return autor;
	}
	
	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	public int getAnoPublicacao() {
		return anoPublicacao;
	}
	
	public void setAnoPublicacao(int anoPublicacao) {
		this.anoPublicacao = anoPublicacao;
	}
	
	public String getGenero() {
		return genero;
	}
	
	public void setGenero(String genero) {
		this.genero = genero;
	}
	
}
