package CLASSES;

import APLICACAO.Aplicacao;

public class ContaEmpresa extends Conta {
	
	private double emprestimoEmpresa = 10000.00;

	public ContaEmpresa(int numero, String cpf, boolean ativa, double emprestimoEmpresa) {
		super(numero, cpf, ativa);
		this.emprestimoEmpresa = emprestimoEmpresa;
	}


	public double getEmprestimoEmpresa() {
		return emprestimoEmpresa;
	}
	
	public void setEmprestimoEmpresa(double emprestimoEmpresa) {
		this.emprestimoEmpresa = emprestimoEmpresa;
	}
	
	public double pedirEmprestimo (double valor) {
		if (this.emprestimoEmpresa >= valor) {
			super.creditar(valor);
			this.emprestimoEmpresa -= valor;
			super.setContador(getContador()-1); //Reajuste no contador, apenas Cr�ditos e d�bitos reais s�o considerados movimenta��es
					
		} else if (valor > this.emprestimoEmpresa) {
			Aplicacao.limparTela();
			System.out.println("|--------------------------------------------|");
			System.out.println("|              OPERA��O INV�LIDA:            |");
			System.out.println("|--------------------------------------------|");
			System.out.println("|        LIMITE EMPRESARIAL INSUFICIENTE     |");
			System.out.println("|--------------------------------------------|");
		}
		return this.emprestimoEmpresa;
	}
	@Override
	public void consultarSaldo() {
		System.out.println("|--------------------------------------------|");
		System.out.printf("         SALDO DISPON�VEL:  R$  %.2f    ",super.getSaldo());
		System.out.println(" ");
		System.out.println("|--------------------------------------------|");
		System.out.printf("         LIMITE DISPON�VEL: R$ %.2f   ",this.emprestimoEmpresa);
		System.out.println(" ");
	}	
}