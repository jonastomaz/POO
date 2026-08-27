package sistemabancario;

import java.util.Scanner;
import sistemabancario.Banco;
import sistemabancario.ContaBancaria;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("informe o codigo do banco: ");
		int codigo = input.nextInt();
		Banco banco = new Banco(codigo);
		
		String operador = "s";
		
		while(operador.equalsIgnoreCase("s")) {
			System.out.print("deseja cadastrar uma conta S ou N: ");
			operador = input.next();
			
			if (operador.equalsIgnoreCase("s")) {
				System.out.print("nome do titular: ");
				String nome_titular = input.next();
				System.out.print("\nnumero da conta: ");
				int numero_conta = input.nextInt();
				System.out.print("\nSaldo da contar: ");
				double valor_saldo = input.nextDouble();
				
				ContaBancaria nova_conta = new ContaBancaria(numero_conta, nome_titular, valor_saldo);
				
				banco.adicionarConta(nova_conta);
			}
		}
		System.out.print("valor minimo de saldo: ");
		double valor = input.nextDouble();
		
		System.out.println("codigo do banco: " + banco.codigoBancario);
		System.out.println("contas cadastradas: " + banco.contas.length);
		
		for(ContaBancaria conta: banco.contas) {
			if(conta.possuiSaldoMaiorque(valor)) {
				System.out.println("conta: " + conta.numero);
				System.out.println("titular: " + conta.titular);
				System.out.println("saldo: " + conta.saldo);
			}
		}

		input.close();
	}

}
