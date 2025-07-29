package net.weg.librarysystem.model;

public class Pessoa {
	protected String nome;
	protected String cpf;
	
	public Pessoa(String nome, String cpf) {
		this.nome = nome;
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String toString() {
		return
				"-=================Biblioteca-WEG================-\n" +
				"| Nome: " + nome + "\n" +
				"| CPF: " + cpf + "\n" +
				"-===============================================-\n";
	}
}
