package CLASSES;

import APLICACAO.Aplicacao;

public class ContaEspecial extends Conta{
	// ATRIBUTO DA SUB
	private double limite = 1000;
	// CONSTRUTOR - SOBRECARGA
	public ContaEspecial(int numero, int cpf, boolean ativa, double limite) {
		super(numero, cpf, ativa);
		this.limite = limite;
	}
	// ENCAPSULAMENTO
	public double getLimite() {
		return limite;
	}
	public void setLimite(double limite) {
		this.limite = limite;
	}

	// MÉTODO especial SITUAÇÃO ESPECIAL, CASO SEJA UTILIZADO O LIMITE
	public double usarLimite(double valor) {
		Aplicacao.limparTela();
		if (super.getSaldo() < valor && valor <= super.getSaldo() + limite) {
			double dif = valor - super.getSaldo();
			limite -= dif;
			super.creditar(dif);
						
		} else if ( valor > super.getSaldo() + limite) {
			System.out.println("|--------------------------------------------|");
			System.out.println("|              OPERAÇÃO INVÁLIDA:            |");
			System.out.println("|--------------------------------------------|");
			System.out.println("|              SALDO INSUFICIENTE            |");
		}	
		return limite;
	}
	
	public static void informarLimite() {
		System.out.println("|--------------------------------------------|");
		System.out.println("|   OPERAÇÃO EXCLUSIVA PARA CONTA ESPECIAL   |");
		System.out.println("|--------------------------------------------|");
		System.out.println("|               LIMITE ESPECIAL:             |");
		System.out.println("| O New Bank proporciona aos clientes que    |");
		System.out.println("| adereiram  esse tipo de conta, um limite   |");
		System.out.println("| disponível no valor de R$ 1000,00.         |");
		System.out.println("|--------------------------------------------|");
		System.out.println("| COMO UTILIZAR?                             |");
		System.out.println("| Basta realizar um saque ou débito com um   |");
		System.out.println("| valor maior que o valor do saldo em conta. |");
		System.out.println("| O limite não poderá ser utilizado caso o   |");
		System.out.println("| valor solicitado exceda o saldo somado ao  |");
		System.out.println("| próprio limite.                            |");
	}
	
	@Override 
	public void consultarSaldo() {
		System.out.println("|--------------------------------------------|");
		System.out.printf("       [ SALDO DISPONÍVEL:  R$  %.2f ]  ",super.getSaldo());
		System.out.println(" ");
		System.out.println("|--------------------------------------------|");
		System.out.printf("       [ LIMITE DISPONÍVEL: R$ %.2f  ] ",this.getLimite());
		System.out.println(" ");
	}	
}