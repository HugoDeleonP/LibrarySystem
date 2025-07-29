package net.weg.librarysystem.model;

public class Bibliotecario extends Pessoa{
	private String turno;
	
	public Bibliotecario(String nome, String cpf, String turno) {
		super(nome, cpf);
		this.turno = turno;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}
	
	@Override
	public String toString() {
		return
				"-=================Biblioteca-WEG================-\n" +
				"| Nome: " + nome + "\n" +
				"| CPF: " + cpf + "\n" +
				"| Turno: " + turno + "\n" +
				"-===============================================-\n";
	}
}
