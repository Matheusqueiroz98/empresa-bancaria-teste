package Programa;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class EmpresaBancaria {

	static ArrayList<Conta> contasBancarias;

	public static void main(String[] args) {
		contasBancarias = new ArrayList<Conta>();
		operacoes();
	}

	public static void operacoes() {

		int operacao = Integer.parseInt(JOptionPane.showInputDialog(" Selecione uma operaração: "
				+ "|   Opção 1 - Criar conta   " + "|   Opção 2 - Depositar     " + "|   Opção 3 - Sacar   "
				+ "|   Opção 4 - Transferir    " + "|   Opção 5 - Extrato de transfêrencias       "
				+ "|   Opção 6 - Extrato das taxas       " + "|   Opção 7 - Sair          "));

		switch (operacao) {
		case 1:
			criarConta();
			break;

		case 2:
			depositar();
			break;

		case 3:
			sacar();
			break;

		case 4:
			transferir();
			break;

		case 5:
			listarContas();
			break;
		case 6:
			listarTaxas();
			break;
		case 7:
			JOptionPane.showMessageDialog(null, "Obrigado por usar nossa Empresa");
			System.exit(0);

		default:
			JOptionPane.showMessageDialog(null, "Opção inválida!");
			operacoes();
			break;
		}
	}

	public static void criarConta() {

		Pessoa pessoa = new Pessoa();

		pessoa.setName(JOptionPane.showInputDialog("Nome: "));

		pessoa.setCpf(JOptionPane.showInputDialog("CPF ou CNPJ: "));

		pessoa.setEmail(JOptionPane.showInputDialog("Celular: "));

		Conta conta = new Conta(pessoa);

		contasBancarias.add(conta);
		JOptionPane.showMessageDialog(null, "--- Sua conta foi criada com sucesso! ---");
		operacoes();

	}

	private static Conta encontrarConta(int numeroConta) {
		Conta conta = null;
		if (contasBancarias.size() > 0) {
			for (Conta contaa : contasBancarias) {
				if (contaa.getNumeroConta() == numeroConta) {
					conta = contaa;
				}
			}
		}
		return conta;
	}

	public static void depositar() {
		int numeroconta = Integer.parseInt(JOptionPane.showInputDialog("Número da conta para depósito:"));

		Conta conta = encontrarConta(numeroconta);

		if (conta != null) {
			Double valorDeposito = Double.parseDouble(JOptionPane.showInputDialog("Qual valor deseja depositar:  "));
			conta.depositar(valorDeposito);

			JOptionPane.showInputDialog("Valor depositado com sucesso!");

		} else {

			JOptionPane.showInputDialog("--- Conta não encontrada ---");

		}

		operacoes();

	}

	public static void sacar() {
		int numeroconta = Integer.parseInt(JOptionPane.showInputDialog("Número da conta para saque:"));

		Conta conta = encontrarConta(numeroconta);

		if (conta != null) {
			Double valorSaque = Double.parseDouble(JOptionPane.showInputDialog("Qual valor deseja sacar:  "));

			conta.sacar(valorSaque);
			JOptionPane.showInputDialog("Saque realizado com sucesso!");
		} else {
			JOptionPane.showInputDialog("Conta não encontrada");
			System.out.println("");
		}

		operacoes();

	}

	public static void transferir() {
		int numeroContaRemetente = Integer.parseInt(JOptionPane.showInputDialog("Número da conta do remetente:"));

		Conta contaRemetente = encontrarConta(numeroContaRemetente);

		if (contaRemetente != null) {
			int numeroContaDestinatario = Integer
					.parseInt(JOptionPane.showInputDialog("Número da conta do destinatario:"));

			Conta contaDestinatario = encontrarConta(numeroContaDestinatario);

			if (contaDestinatario != null) {
				Double valor = Double.parseDouble(JOptionPane.showInputDialog("Valor da transferência: "));

				contaRemetente.transferencia(contaDestinatario, valor);

			} else {
				JOptionPane.showInputDialog("A conta para depósito não foi encontrada");
			}

		} else {
			JOptionPane.showInputDialog(" A Conta para transferência não encontrada");
		}
		operacoes();
	}

	public static void listarContas() {
		if (contasBancarias.size() > 0) {
			for (Conta conta : contasBancarias) {
				JOptionPane.showInputDialog(null, conta);
			}
		} else {
			JOptionPane.showInputDialog("Não há contas cadastradas");
		}

		operacoes();
	}

	public static void listarTaxas() {
		if (contasBancarias.size() > 0) {
			for (Conta taxas : contasBancarias) {
				JOptionPane.showInputDialog(null, taxas);
			}
		} else {
			JOptionPane.showInputDialog("Não há contas cadastradas");
		}

		operacoes();
	}
}
