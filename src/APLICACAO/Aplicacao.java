package APLICACAO;

import java.util.*;
import CLASSES.ContaEmpresa;
import CLASSES.ContaEspecial;
import CLASSES.ContaPoupanca;

public class Aplicacao {
	static Scanner leia = new Scanner(System.in);		//Variáveis globais para poderem ser acessadas por todos os métodos no código
	static int tipoConta, opcaoOperacao, numero;
	static short opcaoAtividade;
	static char opcaoContinuar = 'S';
	static boolean ativa = true;
	static int cpf;
	
	public static void main(String[] args) {
		int contador = 0;
		double[] valor = new double [10];
		mostrarMenuContas();
			
			switch (tipoConta) {    //ESCOLHA DO TIPO DE CONTA
			
				case 1: 
					int diaAniversarioPoupanca = 1;
					ContaPoupanca contaPoupanca = new ContaPoupanca(numero, cpf, ativa, diaAniversarioPoupanca);		
					limparTela();
					System.out.println("|--------------------------------------------|");
					System.out.println("|             { CONTA  POUPANÇA }            |");
					System.out.println("|--------------------------------------------|");
					diaAniversarioPoupanca = contaPoupanca.getDiaAniversarioPoupanca();
					inserirNumero(numero);  	
					inserirCPF(cpf);		
					verificarAtividade(); 	
						
					do {
						contador = contaPoupanca.getContador();
						System.out.println("|--------------------------------------------|");
						System.out.println("    LIMITE DE MOVIMENTAÇÕES (HOJE): " + contaPoupanca.getContador() + "/10");
						mostrarMenuAtividades();
						switch (opcaoOperacao) {
							case 1: 
								limparTela();
								contaPoupanca.consultarSaldo();
								break;
								
							case 2: 
								limparTela();
								System.out.println("|--------------------------------------------|");
								System.out.println("| DIGITE O VALOR DA OPERAÇÃO: R$             |");
								try {
									valor[contador] = leia.nextDouble();
									contaPoupanca.creditar(valor[contador]);
									
									contaPoupanca.consultarSaldo();	
								}
								 catch (InputMismatchException exception) {
									System.out.println("|--------------------------------------------|"); 	
									System.out.println("| VALOR INVÁLIDO, POR FAVOR UTILIZAR APENAS  |");
									System.out.println("| NÚMEROS.                                   |"); 	
									invalidarOperacao();
								}
							break;	
							case 3: 
								try {
									limparTela();
									System.out.println("|--------------------------------------------|");
									System.out.println("         DIGITE O VALOR DA OPERAÇÃO: R$       ");
									valor[contador] = leia.nextDouble();
									if (valor[contador] > contaPoupanca.getSaldo()) {
										contaPoupanca.debitar(valor[contador]);
										contaPoupanca.consultarSaldo();	
									} else if (valor[contador] <= contaPoupanca.getSaldo()) {
										contaPoupanca.debitar(valor[contador]);
										contaPoupanca.consultarSaldo();									
									}
								} catch (InputMismatchException exception) {
									System.out.println("|--------------------------------------------|"); 	
									System.out.println("| VALOR INVÁLIDO, POR FAVOR UTILIZAR APENAS  |");
									System.out.println("| NÚMEROS.                                   |"); 	
									invalidarOperacao();
								}
							break;
								
							case 4: 
								limparTela();
								ContaPoupanca.informarPoupanca();
							break;
								
							case 5:  
								contaPoupanca.correcao(diaAniversarioPoupanca);
								pararAtividadeAcesso();
							break;
							}
								
						} while (contaPoupanca.getContador() < valor.length);
						contaPoupanca.correcao(diaAniversarioPoupanca);
						break;
						
					case 2:
						
					break;
				
				case 3: 				//CASO ESCOLHA CONTA ESPECIAL
					double limite = 1000.00;			
					limparTela();
					ContaEspecial contaEspecial = new ContaEspecial(numero, cpf, ativa, limite);
					System.out.println("|--------------------------------------------|");
					System.out.println("|             { CONTA  ESPECIAL }            |");
					inserirNumero(numero);  	
					inserirCPF(cpf);		
					verificarAtividade(); 	
					
					do {
						contador = contaEspecial.getContador();
						System.out.println("|--------------------------------------------|");
						System.out.println("    LIMITE DE MOVIMENTAÇÕES (HOJE): " + contaEspecial.getContador() + "/10");
						mostrarMenuAtividades();
						switch (opcaoOperacao) {
							case 1: 
								limparTela();
								contaEspecial.consultarSaldo();
							break;
							
							case 2: 
								limparTela();
								System.out.println("|--------------------------------------------|");
								System.out.println("| DIGITE O VALOR DA OPERAÇÃO: R$             |");
								try {
									valor[contador] = leia.nextDouble();
									contaEspecial.creditar(valor[contador]);					
									contaEspecial.consultarSaldo();
								}
								
								 catch (InputMismatchException exception) {
									System.out.println("|--------------------------------------------|"); 	
									System.out.println("| VALOR INVÁLIDO, POR FAVOR UTILIZAR APENAS  |");
									System.out.println("| NÚMEROS.                                   |"); 	
									invalidarOperacao();
								}
								
							break;	
							case 3: 
								limparTela();
								System.out.println("|--------------------------------------------|");
								System.out.println("         DIGITE O VALOR DA OPERAÇÃO: R$       ");
								
								try {
									valor[contador] = leia.nextDouble();
									if (valor[contador] > contaEspecial.getSaldo()) {
										contaEspecial.usarLimite(valor[contador]);
										contaEspecial.consultarSaldo();
										
									} else if (valor[contador] <= contaEspecial.getSaldo()) {
										contaEspecial.debitar(valor[contador]);
										contaEspecial.consultarSaldo();		
										
									} else if (valor[contador] <= contaEspecial.getSaldo()) {
										contaEspecial.debitar(valor[contador]);
										contaEspecial.consultarSaldo();									
									}
								} catch  (InputMismatchException exception) {
									System.out.println("|--------------------------------------------|"); 	
									System.out.println("| VALOR INVÁLIDO, POR FAVOR UTILIZAR APENAS  |");
									System.out.println("| NÚMEROS.                                   |"); 	
									invalidarOperacao();
								}
							break;
							
							case 4: 
								limparTela();
								ContaEspecial.informarLimite(4);
							break;
							
							case 5:  
								pararAtividade();
							break;
						}
							
					} while (contaEspecial.getContador() < valor.length);
					
					if (contaEspecial.getContador() == valor.length) {
						encerrarPorLimite();
					}
					break;
					
				case 4:					//CASO ESCOLHA CONTA EMPRESA
					limparTela();
					double emprestimoEmpresa = 10000.00;
					ContaEmpresa contaEmpresa = new ContaEmpresa(numero, cpf, ativa, emprestimoEmpresa);
					System.out.println("|--------------------------------------------|");
					System.out.println("|             { CONTA  EMPRESA }             |");
					inserirNumero(numero);    	
					inserirCPF(cpf);		
					verificarAtividade(); 	
					
					do {
						contador = contaEmpresa.getContador();
						System.out.println("|--------------------------------------------|");
						System.out.println("    LIMITE DE MOVIMENTAÇÕES (HOJE): " + contaEmpresa.getContador() + "/10");
						mostrarMenuAtividades();
						switch (opcaoOperacao) {
							case 1: 
								limparTela();
								contaEmpresa.consultarSaldo();
							break;
							
							case 2: 
								limparTela();
								System.out.println("|--------------------------------------------|");
								System.out.println("| DIGITE O VALOR DA OPERAÇÃO: R$             |");
								try {
									valor[contador] = leia.nextDouble();
									contaEmpresa.creditar(valor[contador]);					
									contaEmpresa.consultarSaldo();
								}
								 catch (InputMismatchException exception) {
									System.out.println("|--------------------------------------------|"); 	
									System.out.println("| VALOR INVÁLIDO, POR FAVOR UTILIZAR APENAS  |");
									System.out.println("| NÚMEROS.                                   |"); 	
									invalidarOperacao();
								}
							break;
								
							case 3: 
								limparTela();
								System.out.println("|--------------------------------------------|");
								System.out.println("|   OPERAÇÃO EXCLUSIVA PARA CONTA ESPECIAL   |");
								System.out.println("|--------------------------------------------|");
								System.out.println("         DIGITE O VALOR DA OPERAÇÃO: R$       ");
								try {
									valor[contador] = leia.nextDouble();
									if (valor[contador] > contaEmpresa.getSaldo()) {
										System.out.println("|--------------------------------------------|");
										System.out.println("| DESEJA SOLICITAR UM EMPRÉSTIMO? [S/N] ?    |");
										System.out.println("|--------------------------------------------|");
										opcaoContinuar = leia.next().toUpperCase().charAt(0);
										if (opcaoContinuar == 'S') {
											contaEmpresa.consultarSaldo();
											System.out.println("|--------------------------------------------|");
											System.out.println("| DIGITE O VALOR DO EMPRÉSTIMO: R$           |");
											System.out.println("|--------------------------------------------|");
											valor[contador] = leia.nextDouble();
											contaEmpresa.pedirEmprestimo(valor[contador]);
										} else if (opcaoContinuar == 'N') {
											System.out.println("|--------------------------------------------|");
											System.out.println("|          O QUE DESEJA FAZER AGORA?         |");
											System.out.println("|--------------------------------------------|");
											System.out.println("| [1] - VOLTAR AO MENU DE ATIVIDADES         |");
											System.out.println("| [2] - SAIR                                 |");
											System.out.println();
										switch(opcaoAtividade) {
											case 1: 
												mostrarMenuAtividades();	
											break;
											
											case 2:
												pararAtividade();
											break;
											default: {
												mostrarMenuAtividades();
											}
										} 
									} else {
										invalidarOperacao();	
									}
														
								} else if (valor[contador] <= contaEmpresa.getSaldo()) {
									contaEmpresa.debitar(valor[contador]);
									contaEmpresa.consultarSaldo();									
								}
							} catch  (InputMismatchException exception) {
								System.out.println("|--------------------------------------------|"); 	
								System.out.println("| VALOR INVÁLIDO, POR FAVOR UTILIZAR APENAS  |");
								System.out.println("| NÚMEROS.                                   |"); 	
								invalidarOperacao();
							}
							break;
							
							case 4: 
								limparTela();
								System.out.println("|--------------------------------------------|");
								System.out.println("|   OPERAÇÃO EXCLUSIVA PARA CONTA ESPECIAL   |");
								System.out.println("|--------------------------------------------|");
								System.out.println("| DESEJA SOLICITAR UM EMPRÉSTIMO? [S/N] ?    |");
								System.out.println("|--------------------------------------------|");
								opcaoContinuar = leia.next().toUpperCase().charAt(0);
								if (opcaoContinuar == 'S') {
									contaEmpresa.consultarSaldo();
									System.out.println("|--------------------------------------------|");
									System.out.println("| DIGITE O VALOR DO EMPRÉSTIMO: R$           |");
									System.out.println("|--------------------------------------------|");
									valor[contador] = leia.nextDouble();
									contaEmpresa.pedirEmprestimo(valor[contador]);
								} else if (opcaoContinuar == 'N') {
									System.out.println("|--------------------------------------------|");
									System.out.println("|          O QUE DESEJA FAZER AGORA?         |");
									System.out.println("|--------------------------------------------|");
									System.out.println("| [1] - VOLTAR AO MENU DE ATIVIDADES         |");
									System.out.println("| [2] - SAIR                                 |");
									System.out.println();
									switch(opcaoAtividade) {
										case 1: 
											mostrarMenuAtividades();	
										break;
										
										case 2:
											pararAtividade();
										break;
									}
								} else {
									invalidarOperacao();	
								}
							break;
							
							case 5:  
								pararAtividade();
						}
							
					} while (contaEmpresa.getContador() < valor.length);
					
					if (contaEmpresa.getContador() == valor.length) {
						encerrarPorLimite();
					}
				break;
		}
	}
	
	public static void invalidarOperacao() {	
		opcaoContinuar = leia.next().toUpperCase().charAt(0);	
		if (opcaoContinuar =='S') {
			limparTela();
			mostrarMenuAtividades();
		}
			
		else if(opcaoContinuar == 'N') {
			limparTela();
			pararAtividade();	
		}
		else {
			System.out.println("|--------------------------------------------|");
			System.out.println("|               OPÇÃO INVÁLIDA               |");
			System.out.println("|--------------------------------------------|");
			System.out.println("| Deseja tentar novamente? [S/N]:            |");
			invalidarOperacao();	
		}
	}
	public static void invalidarAtividade() {
		opcaoContinuar = leia.next().toUpperCase().charAt(0);	
		if (opcaoContinuar =='S') {
			limparTela();
			verificarAtividade();
		}
		
		else if(opcaoContinuar == 'N') {
			limparTela();
			pararAtividade();	
		}
		else {
			System.out.println("|--------------------------------------------|");
			System.out.println("|               OPÇÃO INVÁLIDA               |");
			System.out.println("|--------------------------------------------|");
			System.out.println("| Deseja tentar novamente? [S/N]:            |");
			invalidarAtividade();
			
		}
	}
	public static void invalidarCPF() {
		opcaoContinuar = leia.next().toUpperCase().charAt(0);	
		if (opcaoContinuar =='S') {
			limparTela();
			inserirCPF(cpf);
		}		
		else if(opcaoContinuar == 'N') {
			limparTela();
			pararAtividadeAcesso();	
		}
		else {
			System.out.println("|--------------------------------------------|");
			System.out.println("|               OPÇÃO INVÁLIDA               |");
			System.out.println("|--------------------------------------------|");
			System.out.println("| Deseja tentar novamente? [S/N]:            |");
			invalidarCPF();
		}
	}
	public static void invalidarNumeroConta() {
		opcaoContinuar = leia.next().toUpperCase().charAt(0);	
		if (opcaoContinuar =='S') {
			limparTela();
			inserirNumero(numero);
		}
		else if(opcaoContinuar == 'N') {		
			limparTela();
			pararAtividadeAcesso();	
		}
		else {
			System.out.println("|--------------------------------------------|");
			System.out.println("|               OPÇÃO INVÁLIDA               |");
			System.out.println("|--------------------------------------------|");
			System.out.println("| Deseja tentar novamente? [S/N]:            |");
			invalidarNumeroConta();	
		}
	}
	public static void pararAtividadeAcesso() { 	//FINALIZA O PROGRAMA
		limparTela();	
		System.out.println("|--------------------------------------------|");
		System.out.println("|      OBRIGADO POR UTILIZAR O NEW BANK      |");
		System.out.println("|--------------------------------------------|");
		System.exit(0);
	}
	public static int invalidarOpcaoMenuAtividades (int opcaoOperacao) {   //MÉTODO PARA INVALIDAR ERROS PROVENIENTES DO USUÁRIO NO MENU DE ATIVIDADES
		opcaoContinuar = leia.next().toUpperCase().charAt(0);	
		if (opcaoContinuar =='S') {
			limparTela();
			mostrarMenuAtividades();
		}
			
		else if(opcaoContinuar == 'N') {
			limparTela();
			pararAtividadeAcesso();	
		}
		else {
			System.out.println("|--------------------------------------------|");
			System.out.println("|               OPÇÃO INVÁLIDA               |");
			System.out.println("|--------------------------------------------|");
			System.out.println("| Deseja tentar novamente? [S/N]:            |");
			invalidarOpcaoMenuAtividades(opcaoOperacao);
		}
		return opcaoOperacao;
	}
	public static void invalidarOpcaoContas () {   //MÉTODO PARA INVALIDAR ERROS PROVENIENTES DO USUÁRIO NAS OPÇOES DE CONTA		
		opcaoContinuar = leia.next().toUpperCase().charAt(0);	
		if (opcaoContinuar =='S') {
			limparTela();
			mostrarMenuContas();
		}
			
		else if(opcaoContinuar == 'N') {
			limparTela();
			pararAtividadeAcesso();	
		}
		else {
			System.out.println("|--------------------------------------------|");
			System.out.println("|               OPÇÃO INVÁLIDA               |");
			System.out.println("|--------------------------------------------|");
			System.out.println("| Deseja tentar novamente? [S/N]:            |");
			invalidarOpcaoContas();
		}
	}
	public static void pararAtividade() { 	//FINALIZA O PROGRAMA
		System.out.println("|--------------------------------------------|");
		System.out.println("| Deseja mesmo sair? [S/N]:                  |");
		System.out.println("|--------------------------------------------|");
		opcaoContinuar = leia.next().toUpperCase().charAt(0);
		if (opcaoContinuar == 'S') {
			System.out.println("|--------------------------------------------|");
			System.out.println("|      OBRIGADO POR UTILIZAR O NEW BANK      |");
			System.out.println("|--------------------------------------------|");
			System.exit(0);
		}
		else if (opcaoContinuar == 'N') {
			mostrarMenuAtividades();
		}
		
		else {
			invalidarOpcaoContas();
		}
	}
	public static void verificarAtividade() {
		limparTela();	
		System.out.println("|--------------------------------------------|");
		System.out.println("|    POR FAVOR, INFORME O STATUS DA CONTA:   |");
		System.out.println("|--------------------------------------------|");
		System.out.println("|[1] -> CONTA ATIVA                          |");
		System.out.println("|[2] -> CONTA INATIVA                        |");
		System.out.println("|--------------------------------------------|");;
		try {		
			opcaoAtividade = leia.nextShort();
		} catch (InputMismatchException exception) {
			System.out.println("|--------------------------------------------|"); 	
			System.out.println("|VOCÊ NÃO PODE INFORMAR UMA CONTA COM LETRAS.|");
			System.out.println("|         POR FAVOR, TENTE NOVAMENTE.        |");
			invalidarAtividade();
		}
		if (opcaoAtividade == 1) {
			ativa = true;
			System.out.println("|--------------------------------------------|");
			System.out.println("|             CONTA NEW BANK ATIVA           |");
			System.out.println("|--------------------------------------------|");
			System.out.println("|Por gentileza, aguarde um momento.          |");
								
		} else if (opcaoAtividade == 2) {
			ativa = false;
			System.out.println("|--------------------------------------------|");
			System.out.println("|            CONTA NEW BANK INATIVA          |");
			System.out.println("|--------------------------------------------|");
			System.out.println("|Para abrir uma nova conta, acesse nosso App |");
			System.out.println("|Aguardamos seu retorno ansiosamente!        |");
			System.out.println("|--------------------------------------------|");
			System.exit(0);
		} else { 
			invalidarOpcaoContas();
		}
	}
	public static int inserirCPF(int cpf) {  				//MÉTODO PARA ACESSO: VERIFICAÇÃO DO CPF
		limparTela();
		System.out.println("| DIGITE O SEU CPF:                          |");
		System.out.println("|--------------------------------------------|");
		try {
			cpf = leia.nextInt();
			limparTela();
		} catch (InputMismatchException exception) {
			limparTela();
			System.out.println("|--------------------------------------------|"); 	
			System.out.println("|               CPF INVÁLIDO                 |");
			System.out.println("|         POR FAVOR, TENTE NOVAMENTE.        |");
			System.out.println("|--------------------------------------------|"); 	
			invalidarCPF();
		}
		return cpf;
	}
	public static int mostrarMenuAtividades() {			//MÉTODO PARA MENU DE ACESSO AS AÇÕES DA CONTA
		System.out.println("|--------------------------------------------|");
		System.out.println("|               [ NEW BANK ]                 |");
		System.out.println("|   ---> Aqui seu dinheiro têm VALOR! <---   |");
		System.out.println("|--------------------------------------------|");
		System.out.println("| [1] - VERIFICAR SALDO                      |");
		System.out.println("| [2] - CREDITAR VALOR                       |");
		System.out.println("| [3] - DEBITAR VALOR                        |");
		System.out.println("| [4] - OPERAÇÃO EXCLUSIVA                   |");
		System.out.println("| [5] - ENCERRAR                             |");
		System.out.println("|--------------------------------------------|");
		System.out.println("|                                            |");
		System.out.print("|  DIGITE O CÓDIGO DA OPÇÃO SELECIONADA:     |");
		try {
			opcaoOperacao = leia.nextInt();
		}
		catch (java.util.InputMismatchException exception) {
			limparTela();
			System.out.println("|--------------------------------------------|"); 	
			System.out.println("|VOCÊ NÃO PODE INFORMAR OPERAÇÕES COM LETRAS.|");
			System.out.println("|         POR FAVOR, TENTE NOVAMENTE.        |");
			System.out.println("|--------------------------------------------|"); 	
			
			if (opcaoOperacao < 1  || opcaoOperacao > 5) {
				invalidarOpcaoMenuAtividades(opcaoOperacao);
			}
				limparTela();invalidarOpcaoMenuAtividades(0);
		}
		
		if (opcaoOperacao < 1  || opcaoOperacao > 5) {
			invalidarOpcaoMenuAtividades(opcaoOperacao);
		}
			limparTela();
		return opcaoOperacao;
	}
	public static int inserirNumero(int numero) {				//MÉTODO PARA ACESSO: VERIFICAÇÃO DO NÚMERO
		System.out.println("|--------------------------------------------|");
		System.out.println("|               [ NEW BANK ]                 |");
		System.out.println("|   ---> Aqui seu dinheiro têm VALOR! <---   |");
		System.out.println("|--------------------------------------------|");
		System.out.println("| DIGITE O NÚMERO DA CONTA:                  |");
		System.out.println("|--------------------------------------------|");
		try {
			numero = leia.nextInt();
		} catch (InputMismatchException exception) {
			System.out.println("|--------------------------------------------|"); 	
			System.out.println("|VOCÊ NÃO PODE INFORMAR UMA CONTA COM LETRAS.|");
			System.out.println("|         POR FAVOR, TENTE NOVAMENTE.        |"); 	
			invalidarNumeroConta();
		} return numero;
	}
	public static int mostrarMenuContas() {     	//MÉTODO PARA MOSTRAR OS TIPOS DE CONTA DISPONIVEIS
		do {
			System.out.println("|--------------------------------------------|");
			System.out.println("|               [ NEW BANK ]                 |");
			System.out.println("|   ---> Aqui seu dinheiro têm VALOR! <---   |");
			System.out.println("|--------------------------------------------|");
			System.out.println("| [1] - CONTA POUPANÇA                       |");
			System.out.println("| [2] - CONTA CORRENTE                       |");
			System.out.println("| [3] - CONTA ESPECIAL                       |");
			System.out.println("| [4] - CONTA EMPRESA                        |");
			System.out.println("| [5] - CONTA ESTUDANTIL                     |");
			System.out.println("| [6] - SAIR                                 |");
			System.out.println("|--------------------------------------------|"); 			
			System.out.println("|                                            |");
			System.out.print("|  DIGITE O CÓDIGO DA OPÇÃO SELECIONADA:     |");
			
			try {
			tipoConta = leia.nextInt();
			if (tipoConta < 1 || tipoConta > 6) {
				invalidarOpcaoContas();
			}
			else if (tipoConta == 6 ) {
				pararAtividadeAcesso();
			}
			}
			catch (InputMismatchException exception) {
				System.out.println("|--------------------------------------------|"); 	
				System.out.println("|VOCÊ NÃO PODE INFORMAR UMA CONTA COM LETRAS.|");
				System.out.println("|         POR FAVOR, TENTE NOVAMENTE.        |");	
				invalidarOpcaoContas();
			}
	} while (tipoConta == 6);
		return tipoConta;
	}
	public static void encerrarPorLimite() {				//MENSSAGEM DE LIMITE DE ACESSOS UTILIZADO, FORÇA ENCERRAMENTO.
		System.out.println("|--------------------------------------------|");
		System.out.println("|  LIMITE DE MOVIMENTAÇÕES DIÁRIAS ATINGIDO  |");
		System.out.println("|--------------------------------------------|");
		System.out.println("|      OBRIGADO POR UTILIZAR O NEW BANK      |");
		System.out.println("|--------------------------------------------|");
	}
	public static void limparTela() {			//LIMPA TELA PULANDO LINHAS EM LOOP
			for (int i = 0; i < 15; i++) {
				System.out.println();
			}
		}
}