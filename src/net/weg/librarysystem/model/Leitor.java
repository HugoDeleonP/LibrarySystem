package net.weg.librarysystem.model;

public class Leitor extends Pessoa{
	private String matricula;
	
	public Leitor(String nome, String cpf, String matricula) {
		super(nome, cpf);
		this.matricula = matricula;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
	@Override
	public String toString() {
		return
				"-=================Biblioteca-WEG================-\n" +
				"| Nome: " + nome + "\n" +
				"| CPF: " + cpf + "\n" +
				"| Matrícula: " + matricula + "\n" +
				"-===============================================-\n";
	}
}
