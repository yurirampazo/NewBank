package CLASSES;

import java.time.LocalDate;
import java.util.GregorianCalendar;
import java.util.Random;

public class ContaPoupanca extends Conta {
	private int diaAniversarioPoupanca;

	public ContaPoupanca(int numero, int cpf, boolean ativa, int diaAniversarioPoupanca) {
		super(numero, cpf, ativa);
		this.diaAniversarioPoupanca = diaAniversarioPoupanca;

	}

	public int getDiaAniversarioPoupanca() {
		return diaAniversarioPoupanca;
	}

	public void setDiaAniversarioPoupanca(int diaAniversarioPoupanca) {
		this.diaAniversarioPoupanca = diaAniversarioPoupanca;

	}
	
	public void correcao(int dia) {
		LocalDate hoje = new LocalDate(dia, mes, ano);
		Random diaAniversarioPoupanca = new Random();;
		GregorianCalendar calendar = new GregorianCalendar();
		int hoje = calendar.get(GregorianCalendar.DAY_OF_MONTH);
		double valor = 0.00;
		if (hoje == diaAniversarioPoupanca) {
			valor = (super.getSaldo() * 0.005);
			super.creditar(valor);
		}
	}
}