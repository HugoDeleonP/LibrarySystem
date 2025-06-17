package net.weg.librarysystem;

import net.weg.librarysystem.view.Atendente;
import net.weg.librarysystem.service.Biblioteca;

public class BibliotecaApp {

	public static void main(String[] args) {
		Atendente atendente = new Atendente();
		Biblioteca biblioteca = new Biblioteca();
		int keyUser;
		do {
			keyUser = atendente.mainMenu();
			biblioteca.gerenciarBiblioteca(keyUser, atendente);
		} while(keyUser != 4);
		
		
	}

}
