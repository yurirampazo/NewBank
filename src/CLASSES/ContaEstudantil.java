package CLASSES;

import APLICACAO.Aplicacao;

public class ContaEstudantil extends Conta {
private double limiteEstudantil= 5000.00;
	
	public ContaEstudantil ( int numero, String cpf,boolean ativa,	 double limiteEstudantil) {
		super(numero,cpf, ativa);
		this.limiteEstudantil = limiteEstudantil;
	}

	public double getLimiteEstudantil() {
		return limiteEstudantil;
	}

	public void setLimiteEstudantil(double limiteEstudantil) {
		this.limiteEstudantil = limiteEstudantil;
}	
	public  double usarEstudantil(double valor) {
		if (this.limiteEstudantil >= valor) {
			super.creditar(valor);
			this.limiteEstudantil -= valor;
			super.setContador(getContador()-1);
			
		} else if (valor > this.limiteEstudantil) {
			Aplicacao.limparTela();
			System.out.println("|--------------------------------------------|");
			System.out.println("|              OPERAÇÃO INVÁLIDA:            |");
			System.out.println("|--------------------------------------------|");
			System.out.println("|        LIMITE ESTUDANTIL INSUFICIENTE      |");
			System.out.println("|--------------------------------------------|");
		}
		return this.limiteEstudantil;		
	}
	
	@Override
	public void consultarSaldo() {
		System.out.println("|--------------------------------------------|");
		System.out.printf("         SALDO DISPONÍVEL:  R$  %.2f    ",super.getSaldo());
		System.out.println(" ");
		System.out.println("|--------------------------------------------|");
		System.out.printf("         LIMITE DISPONÍVEL: R$ %.2f   ",this.limiteEstudantil);
		System.out.println(" ");
	}	
}