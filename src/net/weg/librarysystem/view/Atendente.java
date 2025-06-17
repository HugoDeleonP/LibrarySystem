package net.weg.librarysystem.view;

import java.util.Scanner;
import java.time.LocalDate;
import net.weg.librarysystem.service.Biblioteca;
import net.weg.librarysystem.model.Livro;

public class Atendente {
	
	Scanner input;
	
	public Atendente() {
		input = new Scanner(System.in);
	}
	
	public int mainMenu() {
		System.out.println("-========Biblioteca-WEG=======-");
		System.out.println("| 1- Cadastrar livro          |");
		System.out.println("| 2- Listar livros            |");
		System.out.println("| 3- Remover livros           |");
		System.out.println("| 4- Sair                     |");
		System.out.println("-=============================-");
		
		int keyUser = input.nextInt();
		input.nextLine();
		return keyUser;
	}
	
	public String writeTitulo() {
		System.out.println("Digite o título: ");
		String titulo = input.nextLine();
		
		return titulo;
	}
	
	public String writeAutor() {
		System.out.println("Digite o autor: ");
		String autor = input.nextLine();
		
		return autor;
	}
	
	public int writeAnoPublicacao(){
		Biblioteca biblioteca = new Biblioteca();
		
		System.out.println("Digite o ano de publicação(dd/MM/yyyy): ");
		int anoPublicacao = biblioteca.dataPublicacao(input).getYear();
		
		return anoPublicacao;
	}
	
	public String writeGenero(){
		
		System.out.println("Digite o gênero: "); 
		String genero = input.nextLine();
		
		return genero;
	}
	
	public int writeIndex() {
		
		System.out.println("Digite o índice: ");
		int index = input.nextInt();
		
		return index;
	}
	
	public void printLivro(Livro livro, int index) {
		System.out.println("-============| "+ index + " |============-");
		System.out.println("|Título: " + livro.getTitulo());
		System.out.println("|Autor: " + livro.getAutor());
		System.out.println("|Ano de publicação: " + livro.getAnoPublicacao());
		System.out.println("|Gênero: " + livro.getGenero());

	}
	
	public void listaVazia(){
		System.out.println("Não há livros registrados");
	}
	
	public void acimaLimite() {
		System.out.println("O índice escolhido está acima do tamanho da lista.");
		System.out.println("Escolha um outro que esteja condizente com a quantidade existente");
	}
	
	public void encerramento() {
		System.out.println("Programa encerrado");
	}
	
	public void numeroInvalido() {
		System.out.println("Número inválido.");
		System.out.println("Digite um número condizente com a legenda");
	}
}
