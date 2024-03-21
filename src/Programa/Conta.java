package Programa;

import javax.swing.JOptionPane;

import utilitarios.Utils;

public class Conta {

	private static int accountCounter = 1;

	private int numeroConta;
	private Pessoa pessoa;
	private Double saldo = 0.0;
	private Double taxa = 10.0;

	/**
	 * 
	 * @param pessoa
	 */

	public Conta(Pessoa pessoa) {
		this.numeroConta = Conta.accountCounter;
		this.pessoa = pessoa;
		this.updateSaldo();
		Conta.accountCounter += 1;
	}

	/**
	 * 
	 * @return
	 */

	public int getNumeroConta() {
		return numeroConta;
	}

	public Pessoa getClient() {
		return pessoa;
	}

	/**
	 * 
	 * @param pessoa
	 */

	public void setClient(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	/**
	 * 
	 * @return
	 */

	public Double getSaldo() {
		return saldo;
	}

	/**
	 * 
	 * @param saldo
	 */

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	/**
	 * 
	 * @return
	 */

	public Double getTaxa() {
		return taxa;
	}

	/**
	 * 
	 * @param taxa
	 */

	public void setTaxa(Double taxa) {
		this.taxa = taxa;
	}

	private void updateSaldo() {
		this.saldo = this.getSaldo();
	}

	public String toString() {

		return "\nBank account: " + this.getNumeroConta() + "\nCliente: " + this.pessoa.getNome() + "\nEmail: "
				+ this.pessoa.getCelular() + "\nSaldo: " + Utils.doubleToString(this.getSaldo()) + "\nTaxa: "
				+ Utils.doubleToString(this.getTaxa()) + "\n";
	}

	/**
	 * 
	 * @param valor
	 */

	public void depositar(Double valor) {
		if (valor > 0) {
			setSaldo(getSaldo() + valor - taxa);

			JOptionPane.showMessageDialog(null, "Seu depósito foi realizado com sucesso!");

		} else {
			JOptionPane.showMessageDialog(null, "Não foi possível realizar o depósito!");
		}
	}

	public void sacar(Double valor) {
		if (valor > 0 && this.getSaldo() >= valor) {
			setSaldo(getSaldo() - valor);
			JOptionPane.showMessageDialog(null, "Saque realizado com sucesso!");
		} else {
			JOptionPane.showMessageDialog(null, "Não foi possível realizar o saque!");
		}
	}

	/**
	 * 
	 * @param contaParaDeposito
	 * @param valor
	 */

	public void transferencia(Conta contaParaDeposito, Double valor) {
		if (valor > 0 && this.getSaldo() >= valor) {
			setSaldo(getSaldo() - valor);
			// this.saldo = this.getSaldo() - valor;
			contaParaDeposito.saldo = contaParaDeposito.getSaldo() + valor;
			JOptionPane.showMessageDialog(null, "Transferência realizada com sucesso!");
		} else {
			JOptionPane.showMessageDialog(null, "Não foi possível realizar a tranferência");
		}

	}

	/**
	 * 
	 * @param taxa
	 */

	public void taxas(Double taxa) {
		if (taxa > 0 && this.getTaxa() >= taxa) {
			setTaxa(getTaxa() - taxa);
			JOptionPane.showMessageDialog(null, "Taxas conferidas!");
		} else {
			JOptionPane.showMessageDialog(null, "Não foi possível acessar as taxas");
		}

	}

}
