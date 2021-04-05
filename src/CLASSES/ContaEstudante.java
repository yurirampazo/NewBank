package CLASSES;

public class ContaEstudante extends Conta {
private double limiteEstudantil= 5000.00;
	
	public ContaEstudante ( int numero, int cpf,boolean ativa,	 double limiteEstudantil) {
		super(numero,cpf, ativa);
		this.limiteEstudantil = limiteEstudantil;
	}

	public double getLimiteEstudantil() {
		return limiteEstudantil;
	}

	public void setLimiteEstudantil(double limiteEstudantil) {
		this.limiteEstudantil = limiteEstudantil;
}	
	public double usarEstudantil(double valor) {
		
		if (super.getSaldo() < valor && valor <= super.getSaldo() + limiteEstudantil) {
			double dif = 0;
			dif = valor - super.getSaldo();
			limiteEstudantil = limiteEstudantil - dif;
			super.creditar(dif);
			System.out.printf("Saque de R$ %.2f. Retire seu dinheiro abaixo! \n", valor);
			System.out.printf("Saldo Disponível R$ %.2f \n", super.getSaldo());
			System.out.printf("Limite Disponível R$ %.2f \n", this.limiteEstudantil);
		}
		return limiteEstudantil;		
	}
}