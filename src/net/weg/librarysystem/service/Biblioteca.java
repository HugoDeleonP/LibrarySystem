package net.weg.librarysystem.service;
import java.util.List;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import net.weg.librarysystem.view.Atendente;


import net.weg.librarysystem.model.Livro;

public class Biblioteca {
	
	ArrayList <Livro> livros = new ArrayList<>();
	
	public Biblioteca() {
		livros = new ArrayList();
	}
	
	public LocalDate dataPublicacao(Scanner input) {
		
		String dataString = input.nextLine();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		return LocalDate.parse(dataString, formatter);
	}
	
	public void gerenciarBiblioteca(int keyUser, Atendente atendente) {
		
		
		switch (keyUser) {
		case 0 ->{
			atendente.encerramento();
		}
		case 1 -> {
			adicionarLivro(atendente);
		}
		case 2 ->{
			listarLivro(atendente, livros);
		}
		case 3 ->{
			removerLivro(atendente, livros);
		}
		case 4 ->{
			pesquisarLivro(atendente, livros);
		}
		case 5 ->{
			editarLivro(atendente, livros);
		}
		case 6 ->{
			contagemLivros(atendente, livros);
		}
		default ->{
			atendente.numeroInvalido();
		}
		}
	}
	
	public Livro formerLivro(Atendente atendente) {
		
		String titulo = atendente.writeTitulo();
		String autor = atendente.writeAutor();
		int anoPublicacao = atendente.writeAnoPublicacao();
		String genero = atendente.writeGenero();
		
		Livro livro = new Livro(titulo, autor, anoPublicacao, genero);
		
		return livro;
	}
	
	public void adicionarLivro(Atendente atendente) {

		 Livro livro = formerLivro(atendente);
		 livros.add(livro);
		
	}
	
	public void listarLivro(Atendente atendente, ArrayList<Livro> livros) {
	
	if(livros.isEmpty()){
		atendente.listaVazia();
	}
	else {
		for(Livro unitLivro:livros) {
			int index = 0;
			atendente.printLivro(unitLivro, index);
			index++;
		}
	}

	}
	
	public void removerLivro(Atendente atendente, ArrayList<Livro> livros) {
		int index = atendente.writeIndex();
		try {
			livros.remove(index);
		}
		catch(Exception e) {
			if(index > livros.size()) {
				atendente.acimaLimite();
			}
		}
	}
	
	public void pesquisarLivro(Atendente atendente, ArrayList<Livro> livros) {
		
		String tituloLivro = atendente.writeTitulo();
		
		for(Livro livro: livros) {
			
			if(livro.getTitulo().equalsIgnoreCase(tituloLivro)) {
				atendente.tituloEncontrado(livro);
			}
			else {
				atendente.tituloNaoEncontrado();
			}
		}
	}
	
	public Livro pesquisarLivroIndex(Atendente atendente, ArrayList<Livro> livros, int indexDigitado) {
		
		
		int index = 0;

		for(Livro livro: livros) {
			
			if(livros.get(indexDigitado) != null) {
				return livro;
			}
			
			else {
				atendente.listaVazia();
			}
		}
		
		return null;
	}
	
	public void editarLivro(Atendente atendente, ArrayList<Livro> livros) {
		Scanner input = new Scanner(System.in);
		
		listarLivro(atendente, livros);
		int indexDigitado = atendente.writeIndex();
				
		Livro livroPesquisado = pesquisarLivroIndex(atendente, livros, indexDigitado);
		
		int keyUser = atendente.edicaoMenu(input);		
		gerenciarEdicao(keyUser, atendente, livroPesquisado);
	}
	
	public void gerenciarEdicao(int keyUser, Atendente atendente, Livro livro) {
		switch(keyUser) {
			case 0 ->{
				atendente.cancelamento();
			}
			case 1 ->{
				String tituloEditado = atendente.writeTitulo();
				livro.setTitulo(tituloEditado);
			}
			case 2 ->{
				String autorEditado = atendente.writeAutor();
				livro.setAutor(autorEditado);
			}
			case 3 ->{
				int anoPublicacaoEditado = atendente.writeAnoPublicacao();
				livro.setAnoPublicacao(anoPublicacaoEditado);
			}
			case 4 ->{
				String generoEditado = atendente.writeGenero();
				livro.setGenero(generoEditado);
			}
			default ->{
				atendente.numeroInvalido();
			}
		}
	}
	
	public void contagemLivros(Atendente atendente, ArrayList<Livro> livros) {
		
		int quantidadeLivros = livros.size();
		
		atendente.quantidadeDeLivros(quantidadeLivros);
	}
}
