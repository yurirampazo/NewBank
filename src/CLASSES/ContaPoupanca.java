package CLASSES;

import java.util.GregorianCalendar;
import java.util.Random;


public class ContaPoupanca extends Conta {
	private int diaAniversarioPoupanca;
	private double reajuste;

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
	public double getReajuste() {
		return reajuste;
	}
	public void setReajuste(double reajuste) {
		this.reajuste = reajuste;
	}
	public void correcao(int hoje) {
		GregorianCalendar calendar = new GregorianCalendar();
		hoje = calendar.get(GregorianCalendar.DAY_OF_MONTH);
		Random aleatorio = new Random(32);
		diaAniversarioPoupanca = aleatorio.nextInt();
		if (diaAniversarioPoupanca == 0) {
			diaAniversarioPoupanca += 1;
		}
		if (hoje == diaAniversarioPoupanca) {
			reajuste = (super.getSaldo() * 0.005);
			super.creditar(reajuste);
			super.consultarSaldo();
			super.setContador(getContador()-1);				//Reajuste no contador, apenas Cr�ditos e d�bitos reais s�o considerados movimenta��es
		}
	}
	public static void informarPoupanca() {
		System.out.println("|--------------------------------------------|");
		System.out.println("|   CONDI��O ESPECIAL PARA CONTA POUPAN�A    |");
		System.out.println("|--------------------------------------------|");
		System.out.println("| O New Bank proporciona aos clientes que    |");
		System.out.println("| adereiram  esse tipo de conta, um reajuste |");
		System.out.println("| de 0,5% acrescidos ao saldo da conta       |");
		System.out.println("|--------------------------------------------|");
		System.out.println("| COMO UTILIZAR?                             |");
		System.out.println("| A cada m�s completado com saldo na conta   |");
		System.out.println("| ela sofre esse reajuste.					 |");
	}
}