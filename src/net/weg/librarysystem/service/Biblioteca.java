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
	
	public void gerenciarBiblioteca(int keyUser, Atendente atendente) {
		switch (keyUser) {
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
			atendente.encerramento();
		}
		default ->{
			atendente.numeroInvalido();
		}
		}
	}
}
