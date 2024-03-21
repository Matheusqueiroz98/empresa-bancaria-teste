package Programa;

import java.util.Date;

public class Pessoa {

	private static int counter = 1;

	private int numeroPessoa;
	private String nome;
	private String cpf;
	private String celular;
	private Date accountCreationDate;

	public Pessoa() {
	}

	public Pessoa(String nome, String cpf, String celular) {
		this.numeroPessoa = Pessoa.counter;
		this.nome = nome;
		this.cpf = cpf;
		this.celular = celular;
		this.accountCreationDate = new Date();
		Pessoa.counter += 1;
	}

	public int getNumeroPessoa() {
		return this.numeroPessoa;
	}

	public String getNome() {
		return nome;
	}

	public void setName(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCelular() {
		return celular;
	}

	public void setEmail(String celular) {
		this.celular = celular;
	}

	public Date getAccountCreationDate() {
		return this.accountCreationDate;
	}

	public String toString() {
		return "\nNome: " + this.getNome() + "\nCPF: " + this.getCpf() + "\nCelular: " + this.getCelular();
	}

}
