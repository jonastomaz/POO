package console;

import java.util.Scanner;
import controlador.ControladorGuilda;

public class ConsoleGuilda {

	private Scanner scanner;
	private ControladorGuilda controlador;

	public ConsoleGuilda() {
		scanner = new Scanner(System.in);
		controlador = new ControladorGuilda();
	}

	public void iniciar() {
		int opcao;

		do {
			exibirMenu();
			opcao = lerInteiro("Opcao: ");

			executarOpcao(opcao);

			if (opcao != 0) {
				System.out.println();
			}

		} while (opcao != 0);

		scanner.close();
	}

	private void exibirMenu() {
		System.out.println("==================================");
		System.out.println("     GUILDA DOS AVENTUREIROS");
		System.out.println("==================================");
		System.out.println("1 - Cadastrar personagem");
		System.out.println("2 - Listar personagens");
		System.out.println("3 - Consultar personagem por codigo");
		System.out.println("4 - Utilizar habilidade");
		System.out.println("5 - Registrar conclusao de missao");
		System.out.println("6 - Exibir resumo da guilda");
		System.out.println("0 - Sair");
		System.out.println();
	}

	private void executarOpcao(int opcao) {
		switch (opcao) {
		case 1:
			cadastrarPersonagem();
			break;

		case 2:
			listarPersonagens();
			break;

		case 3:
			consultarPersonagem();
			break;

		case 4:
			utilizarHabilidade();
			break;

		case 5:
			registrarConclusaoMissao();
			break;

		case 6:
			exibirResumoGuilda();
			break;

		case 0:
			System.out.println("Programa encerrado.");
			break;

		default:
			System.out.println("Opcao invalida.");
		}
	}

	private int lerInteiro(String mensagem) {
		while (true) {
			System.out.print(mensagem);
			String entrada = scanner.nextLine();

			try {
				return Integer.parseInt(entrada);

			} catch (NumberFormatException e) {
				System.out.println("Digite um numero inteiro valido.");
			}
		}
	}

	private String lerTexto(String mensagem) {
		System.out.print(mensagem);
		return scanner.nextLine();
	}
	
	private void cadastrarPersonagem() {
		System.out.print("TIPO DE PERSONAGEM\n"
				+ "1 - Guerreiro\n"
				+ "2 - Mago\n"
				+ "3 - Arqueiro\n"
				+ "0 - Voltar \n");
		
		int opc = lerInteiro("opcao: ");
		if(opc <= 0 || opc > 3) {
			System.out.println("opcao invalida");
			return;
		}
		
		int codigo = lerInteiro("Codigo: ");
		String nome = lerTexto("Nome: ");
		int nivel = lerInteiro("Nivel: ");
		int energia = lerInteiro("Energia: ");
		int experiencia = lerInteiro("Experiencia: ");
		
		switch (opc) {
			case 1:
				String arma = lerTexto("Arma: ");
				int forca = lerInteiro("Forca: ");
				
				if(controlador.cadastrarGuerreiro(codigo, nome, nivel, energia, experiencia, arma, forca)) {
					System.out.println("Personagem cadastrado com sucesso.");
				}else {
					System.out.println("Personagem nao cadastrado");
				}
				
				break;
			case 2:
				String elemento = lerTexto("elemento que domina: ");
				int poderMagico = lerInteiro("valor da precisao: ");
				
				if(controlador.cadastrarMago(codigo, nome, nivel, energia, experiencia, elemento, poderMagico)) {
					System.out.println("Personagem cadastrado com sucesso.");
				}else {
					System.out.println("Personagem nao cadastrado");
				}
				
				break;
			case 3:
				String tipoArco = lerTexto("tipo de arco: ");
				int valorPrecisao = lerInteiro("valor da precisao: ");
				
				if(controlador.cadastrarArqueiro(codigo, nome, nivel, energia, experiencia, tipoArco, valorPrecisao)) {
					System.out.println("Personagem cadastrado com sucesso.");
				}else {
					System.out.println("Personagem nao cadastrado");
				}
				
				break;
		}
	}
	
	private void consultarPersonagem() {
		int codigo = lerInteiro("codigo do personagem: ");
		System.out.println(controlador.consultarPersonagem(codigo));
	}
	
	private void listarPersonagens() {
		System.out.println(controlador.listarPersonagens());
	}
	
	private void utilizarHabilidade() {
		int codigo = lerInteiro("codigo do personagem: ");
		System.out.println(controlador.usarHabilidade(codigo));
	}
	
	private void registrarConclusaoMissao() {
		int codigo = lerInteiro("codigo do personagem: ");
		System.out.println("DIFICULDADE DA MISSAO\n"
				+ "1 - FACIL\n"
				+ "2 - NORMAL\n"
				+ "3 - DIFICIL\n"
				+ "4 - LENDARIA");
		int dificuldade = lerInteiro("dificuldade da missao: ");
		
		System.out.println(controlador.registrarConclusaoMissao(codigo, dificuldade));
	}
	
	private void exibirResumoGuilda() {
		System.out.println(controlador.exibirResumoGuilda());
	}
}
