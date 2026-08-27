import java.util.Scanner;
public class Main {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("digite a quantidade maxima de pacotes por entregador: ");
		int quantMaxPacotes = input.nextInt();
		System.out.println("digite a quantidade de entregador: ");
		int quantEntregadores = input.nextInt();
		
		HubEntregas entregas = new HubEntregas(quantMaxPacotes, quantEntregadores);
		
		int opc = 1;
		while(opc != 0) {
			System.out.println("1 - cadastrar entregador");
			System.out.println("2 - cadastrar pacote");
			System.out.println("3 - remover pacote");
			System.out.println("4 - marcar pacote como entregue");
			System.out.println("5 - listar entregadores");
			System.out.println("0 - sair");
			
			System.out.print("informe uma das opcoes acima: ");
			opc = input.nextInt();
			
			switch (opc) {
				case 1:
					System.out.print("digite o nome do entregador: ");
					String nome = input.next();
					System.out.print("digite o telefone do entregador: ");
					String telefone = input.next();
					
					entregas.cadastrarEntregador(nome, telefone);
					break;
					
				case 2:
					System.out.print("digite o nome do entregador: ");
					String nomeEntregador = input.next();
					System.out.print("digite o codigo do pacote: ");
					String codigo = input.next();
					System.out.print("digite o destinatario do pacote: ");
					String destinatario = input.next();
					
					entregas.cadastrarPacote(nomeEntregador, codigo, destinatario);
					break;
					
				case 3:
					System.out.print("digite o codigo do pacote: ");
					String codigoParaRemover = input.next();
					
					entregas.removerPacotePorCodigo(codigoParaRemover);
					break;
					
				case 4:
					System.out.print("digite o codigo do pacote: ");
					String codigoPacoteEntregue = input.next();
					
					entregas.marcarPacoteComoEntregue(codigoPacoteEntregue);
					break;
					
				case 5:
					entregas.listarEntregadores();
					break;
				
				default:
					System.out.println("opcao invalida");
			}
		}
		input.close();
	}
}