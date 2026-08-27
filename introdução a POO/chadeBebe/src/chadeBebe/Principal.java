package chadeBebe;
import java.util.Scanner;

public class Principal {
	
	static ChaDeBebe festaMikaelle;
	
	static void mostrarMenu() {
		System.out.println("1 - anotar presente");
		System.out.println("2 - ver caderno de presente");
		System.out.println("3 - apagar um presente");
		System.out.println("4 - procurar presente por convidado");
		System.out.println("0 - sair");
	}

	static int lerNumero() {
		Scanner lerNumero = new Scanner(System.in);
		int opc = lerNumero.nextInt();
		return opc;
	}
	
	static String lerString() {
		Scanner lerString = new Scanner(System.in);
		String palavra = lerString.next();
		return palavra;
	}
	
	static void opcaoAnotarNovoPresente() {
		System.out.print("qual nome do convidado: ");
		String nome_convidado = lerString();
		
		System.out.print("qual o presente: ");
		String descricao = lerString();
		
		System.out.print("qual o tamanho: ");
		String tamanho = lerString();
		
		System.out.print("informe o codigo: ");
		int codigo = lerNumero();
		
		festaMikaelle.cadastrarPresente(tamanho, nome_convidado, descricao, codigo);
	}
	
	static void opcaoApagarPresente() {
		System.out.print("informe o codigo do presente que deseja apagar: ");
		int codigo_presente = lerNumero();
		if(festaMikaelle.removerPresente(codigo_presente)) {
			System.out.println("presente removido");
		}
		else {
			System.out.println("algo deu errado, presente nao foi encontrado");
		}
	}
	
	static void opcaoProcurarPorConvidado() {
		System.out.print("nome do convidado para ver qual presente: ");
		String nome_convidade_presente = lerString();
		Presente[] presente_encontrado = festaMikaelle.procurarPresentePorConvidad(nome_convidade_presente);
		if(presente_encontrado.length > 0) {
			for(Presente presentes: presente_encontrado) {
				System.out.println("presente " + presentes.descricao + 
						" de " + presentes.nome_convidado +
						" tamanho " + presentes.tamanho_roupaItem);
			}
		}
		else {
			System.out.println("nenhum presente encontrado");
		}
	}
	
	public static void main(String[] args) {
		System.out.print("informe a quantidade maxima de presente: ");
		int quantidadeMaxima = lerNumero();
		festaMikaelle = new ChaDeBebe(quantidadeMaxima);
		int operador = 1;
		
		while(operador != 0) {
			mostrarMenu();
			System.out.print("escolha uma opcao: ");
			operador = lerNumero();
			
			switch(operador) {
				case 1:
					opcaoAnotarNovoPresente();
					break;
					
				case 2:
					festaMikaelle.verCardeninho();
					break;
				
				case 3:
					opcaoApagarPresente();
					break;
					
				case 4:
					opcaoProcurarPorConvidado();
					break;
				
				default:
					System.out.println("opcao invalida");
					break;
			}
		}
	}
}
