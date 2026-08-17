package console;

import java.util.Scanner;

import estrategia.EstategiaComum;
import estrategia.EstategiaOuro;
import estrategia.Estrategia;
import estrategia.EstrategiaDiamante;
import estrategia.EstrategiaPlatina;
import supermercado.SistemaCliente;

public class Console {
	private Scanner input;
	private SistemaCliente sistema;
	
	public Console() {
		this.input = new Scanner(System.in);
		this.sistema = new SistemaCliente();
	}
	
	public void iniciar() {
		int operador;
		do {
			menu();
			operador = LerInterio("opcao: ");
			
			executarOpcao(operador);
			
			if(operador != 0) {
				System.out.println("");
			}
		}while (operador != 0);
	}
	
	private int LerInterio(String mensagem) {
		System.out.print(mensagem);
		return input.nextInt();
	}
	
	private double LerDouble(String mensagem) {
		System.out.print(mensagem);
		return input.nextDouble();
	}
	
	private String LerString(String mensagem) {
		System.out.print(mensagem);
		return input.next();
	}
	
	private void menu() {
		System.out.println("1 - cadastrar cliente");
		System.out.println("2 - consultar cliente pelo codigo");
		System.out.println("3 - registrar compra");
		System.out.println("4 - simular compra");
	}
	
	private void menuEstrategia() {
		System.out.println("1 - estrategia comum");
		System.out.println("2 - estrategia ouro");
		System.out.println("3 - estrategia platina");
		System.out.println("4 - estrategia diamante");
	}
	
	private void executarOpcao(int opcao) {
		switch (opcao) {
			case 1:
				String codigo = LerString("codigo: ");
				String nome = LerString("Nome: ");
				int documento = LerInterio("documento: ");
				String email = LerString("email: ");
				try {
					if(sistema.cadastrarCliente(codigo, nome, documento, email)) {
						System.out.println("cliente cadastrado");
					}
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 2:
				String codigoConsulta = LerString("codigo: ");
				System.out.println(sistema.consultaCliente(codigoConsulta));
				break;
			case 3:
				double valor = LerDouble("valor: ");
				String codigoCompra = LerString("codigo: ");
				
				System.out.println("o valor da compra ficou: " + sistema.registrarCompra(codigoCompra, valor));
				break;
			case 4:
				menuEstrategia();
				int opc = LerInterio("opcao: ");
				double valorCompra =  LerDouble("valor: ");
				Estrategia estrategia;
				switch (opc) {
					case 1:
						estrategia = new EstategiaComum();
						System.out.println(sistema.simularCompra(valorCompra, estrategia));
						break;
					case 2:
						estrategia = new EstategiaOuro();
						System.out.println(sistema.simularCompra(valorCompra, estrategia));
						break;
					case 3:
						estrategia = new EstrategiaPlatina();
						System.out.println(sistema.simularCompra(valorCompra, estrategia));
						break;
					case 4:
						estrategia = new EstrategiaDiamante();
						System.out.println(sistema.simularCompra(valorCompra, estrategia));
						break;
					default:
						System.out.println("opcao de estrategia invalida");
						break;
				}
				break;
			default:
				System.out.println("opcao invalida");
				break;
		}
	}
}
