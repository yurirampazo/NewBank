package CLASSES;

import APLICACAO.Aplicacao;

public class ContaCorrente extends Conta {
	// ATRIBUTOS
	private int contadorTalao = 3;
	private double valorTalao = 1000.00;

	// CONSTRUTOR
	public ContaCorrente(int numero, int cpf, boolean ativa, int contadorTalao, double valorTalao) {
		super(numero, cpf, ativa);
		this.contadorTalao = contadorTalao;
		this.valorTalao = valorTalao;
	}

	// ENCAPSULAMENTO
	public double getValorTalao() {
		return valorTalao;
	}

	public void setValorTalao(double valorTalao) {
		this.valorTalao = 1000;
	}

	public int getContadorTalao() {
		return contadorTalao;
	}

	public void setContadorTalao(int contadorTalao) {
		this.contadorTalao = 3;
	}

	public void pedirTalao() {
		if (this.contadorTalao != 0) {
			super.creditar(this.valorTalao);
			this.contadorTalao -= 1;
			System.out.println("|--------------------------------------------|");
			System.out.println("|    TALÃO CREDITADO NA CONTA COM SUCESSO!   |");
		} else if (this.contadorTalao <=0 ) {
			System.out.println("|--------------------------------------------|");
			System.out.println("|         LIMITE DE TALÕES ESGOTADO.         |");
			System.out.println("|--------------------------------------------|");
		}	
		consultarSaldo();
	}
	
	@Override 
	public void consultarSaldo() {
		System.out.println("|--------------------------------------------|");
		System.out.printf("       [ SALDO DISPONÍVEL:  R$  %.2f ]  ",super.getSaldo());
		System.out.println("");
		System.out.println("|--------------------------------------------|");
		System.out.println("          [ TALÕES DISPONÍVEIS: " + this.contadorTalao + "]");
		System.out.println("");
	}	
	
	public static void informarTaloes() {
		System.out.println("|--------------------------------------------|");
		System.out.println("|   CONDIÇÃO ESPECIAL PARA CONTA CORRENTE    |");
		System.out.println("|--------------------------------------------|");
		System.out.println("| O New Bank proporciona aos clientes que    |");
		System.out.println("| adereiram  esse tipo de conta, um bônus de |");
		System.out.println("| 3 Talões de R$ 1000,00 para uso mensal.    |");
		System.out.println("|--------------------------------------------|");
		System.out.println("| COMO UTILIZAR?                             |");
		System.out.println("| Solicitar ao sair ou ao final das operações|");
		System.out.println("| diárias.					                 |");
	}
	
}
