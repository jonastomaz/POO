package LocadoraDeBicicleta;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        SistemaLocacao sistema = new SistemaLocacao();

        int opcao;

        do {

            System.out.println("\n=== LOCADORA DE BICICLETAS ===");
            System.out.println("1 - Cadastrar cliente");
            System.out.println("2 - Cadastrar bicicleta");
            System.out.println("3 - Alugar bicicleta");
            System.out.println("4 - Devolver bicicleta");
            System.out.println("5 - Listar bicicletas disponiveis");
            System.out.println("6 - Listar alugueis ativos");
            System.out.println("7 - Sair");
            System.out.print("Escolha uma opcao: ");

            opcao = input.nextInt();
            input.nextLine();

            switch (opcao) {

                case 1:

                    System.out.print("Nome: ");
                    String nome = input.nextLine();

                    System.out.print("CPF: ");
                    String cpf = input.nextLine();

                    System.out.println(sistema.cadastrarCliente(nome, cpf));

                    break;

                case 2:

                    System.out.print("Codigo: ");
                    String codigo = input.nextLine();

                    System.out.print("Modelo: ");
                    String modelo = input.nextLine();

                    System.out.print("Valor da diaria: ");
                    double diaria = input.nextDouble();
                    input.nextLine();

                    System.out.println(sistema.cadastrarBicicleta(codigo, modelo, diaria));

                    break;

                case 3:

                    System.out.print("CPF do cliente: ");
                    cpf = input.nextLine();

                    System.out.print("Codigo da bicicleta: ");
                    codigo = input.nextLine();

                    System.out.print("Quantidade de dias: ");
                    int dias = input.nextInt();
                    input.nextLine();

                    System.out.println(sistema.alugarBicicleta(cpf, codigo, dias));

                    break;

                case 4:

                    System.out.print("Codigo da bicicleta: ");
                    codigo = input.nextLine();

                    System.out.println(sistema.devolverBicicleta(codigo));

                    break;

                case 5:

                    System.out.println(sistema.listarBicicletasDisponiveis());

                    break;

                case 6:

                    System.out.println(sistema.listarAlugueisAtivos());

                    break;

                case 7:

                    System.out.println("Sistema encerrado.");

                    break;

                default:

                    System.out.println("Opcao invalida.");
            }

        } while (opcao != 7);

        input.close();
    }
}