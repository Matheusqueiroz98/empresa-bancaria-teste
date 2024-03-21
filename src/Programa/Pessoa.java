package Programa;

import java.util.Date;

/**
 * @author Matheus Queiroz
 */

public class Pessoa {

	private static int counter = 1;

	private int numeroPessoa;
	private String nome;
	private String cpf;
	private String celular;
	private Date accountCreationDate;

	public Pessoa() {
	}

	/**
	 * 
	 * @param nome
	 * @param cpf
	 * @param celular
	 */
	public Pessoa(String nome, String cpf, String celular) {
		this.numeroPessoa = Pessoa.counter;
		this.nome = nome;
		this.cpf = cpf;
		this.celular = celular;
		this.accountCreationDate = new Date();
		Pessoa.counter += 1;
	}

	/**
	 * 
	 * @return
	 */

	public int getNumeroPessoa() {
		return this.numeroPessoa;
	}

	public String getNome() {
		return nome;
	}

	/**
	 * 
	 * @param nome
	 */

	public void setName(String nome) {
		this.nome = nome;
	}

	/**
	 * 
	 * @return
	 */

	public String getCpf() {
		return cpf;
	}

	/**
	 * 
	 * @param cpf
	 */

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	/**
	 * 
	 * @return
	 */

	public String getCelular() {
		return celular;
	}

	/**
	 * 
	 * @param celular
	 */

	public void setEmail(String celular) {
		this.celular = celular;
	}

	/**
	 * 
	 * @return
	 */

	public Date getAccountCreationDate() {
		return this.accountCreationDate;
	}

	public String toString() {
		return "\nNome: " + this.getNome() + "\nCPF: " + this.getCpf() + "\nCelular: " + this.getCelular();
	}

}
