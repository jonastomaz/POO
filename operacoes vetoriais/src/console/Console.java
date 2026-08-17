package console;

import java.util.Scanner;

import calculadora.CalculadoraVetorial;
import calculadora.OperacaoPonto;
import calculadora.OperacaoVetor;
import solucao.SolucaoPassoAPasso;
import vetor.Ponto;
import vetor.Vetor;

public class Console {
    private Scanner scanner;
    private OperacaoVetor operacaoVetor;
    private OperacaoPonto operacaoPonto;
    private CalculadoraVetorial calculadora;
    private SolucaoPassoAPasso solucao;

    public Console() {
        scanner = new Scanner(System.in);
        operacaoVetor = new OperacaoVetor();
        operacaoPonto = new OperacaoPonto();
        calculadora = new CalculadoraVetorial();
        solucao = new SolucaoPassoAPasso();
    }

    public void iniciar() {
        int opcao;
        do {
            exibirMenu();
            opcao = scanner.nextInt();
            switch (opcao) {
                case 1:
                    somarVetores();
                    break;
                case 2:
                    subtrairVetores();
                    break;
                case 3:
                    multiplicarPorEscalar();
                    break;
                case 4:
                    calcularProdutoEscalar();
                    break;
                case 5:
                    calcularProdutoVetorial();
                    break;
                case 6:
                    calcularModulo();
                    break;
                case 7:
                    verificarOrtogonalidade();
                    break;
                case 8:
                    verificarParalelismo();
                    break;
                case 9:
                    encontrarVetorParalelo();
                    break;
                case 10:
                    calcularAngulo();
                    break;
                case 11:
                    encontrarPonto();
                    break;
                case 12:
                    resolverEquacaoVetorial();
                    break;
                case 13:
                    verificarVetorUnitario();
                    break;
                case 0:
                    System.out.println("\nSistema encerrado.");
                    break;
                default:
                    System.out.println("\nOpção inválida!");
            }
        } while (opcao != 0);
        scanner.close();
    }


    private void exibirMenu() {
        System.out.println("\n=================================");
        System.out.println("       CALCULADORA VETORIAL");
        System.out.println("=================================");
        System.out.println("1  - Somar vetores");
        System.out.println("2  - Subtrair vetores");
        System.out.println("3  - Multiplicar vetor por escalar");
        System.out.println("4  - Produto escalar");
        System.out.println("5  - Produto vetorial");
        System.out.println("6  - Módulo de um vetor");
        System.out.println("7  - Verificar ortogonalidade");
        System.out.println("8  - Verificar paralelismo");
        System.out.println("9  - Encontrar vetor paralelo");
        System.out.println("10 - Calcular ângulo entre vetores");
        System.out.println("11 - Encontrar ponto através de vetor");
        System.out.println("12 - Resolver equação vetorial");
        System.out.println("13 - Verificar se vetor é unitário");
        System.out.println("0  - Sair");
        System.out.println("=================================");
        System.out.print("Escolha uma opção: ");
    }


    private Vetor lerVetor() {
        System.out.print("Digite x: ");
        double x = scanner.nextDouble();
        System.out.print("Digite y: ");
        double y = scanner.nextDouble();
        System.out.print("Digite z: ");
        double z = scanner.nextDouble();
        return new Vetor(x, y, z);
    }

    private Ponto lerPonto() {
        System.out.print("Digite x: ");
        double x = scanner.nextDouble();
        System.out.print("Digite y: ");
        double y = scanner.nextDouble();
        System.out.print("Digite z: ");
        double z = scanner.nextDouble();
        return new Ponto(x, y, z);
    }

    private void somarVetores() {
        System.out.println("\n--- SOMA DE VETORES ---");
        System.out.println("\nPrimeiro vetor:");
        Vetor v1 = lerVetor();
        System.out.println("\nSegundo vetor:");
        Vetor v2 = lerVetor();
        Vetor resultado = operacaoVetor.somarVetor(v1, v2);
        solucao.mostrarSoma( v1,v2, resultado);
    }

    private void subtrairVetores() {
        System.out.println("\n--- SUBTRAÇÃO DE VETORES ---");
        System.out.println("\nPrimeiro vetor:");
        Vetor v1 = lerVetor();
        System.out.println("\nSegundo vetor:");
        Vetor v2 = lerVetor();
        Vetor resultado =operacaoVetor.subtrairVetor(v1, v2);
        solucao.mostrarSubtracao(v1,v2,resultado);
    }

    private void multiplicarPorEscalar() {
        System.out.println("\n--- MULTIPLICAÇÃO POR ESCALAR ---");
        Vetor vetor = lerVetor();
        System.out.print("Digite o escalar: ");
        double escalar = scanner.nextDouble();
        Vetor resultado = operacaoVetor.multiplicaVetorPorEscalar( vetor, escalar);
        solucao.mostrarEscalar( vetor,escalar,resultado);
    }

    private void calcularProdutoEscalar() {
        System.out.println("\n--- PRODUTO ESCALAR ---");
        System.out.println("\nPrimeiro vetor:");
        Vetor v1 = lerVetor();
        System.out.println("\nSegundo vetor:");
        Vetor v2 = lerVetor();
        double resultado = operacaoVetor.produtoEscalar(v1, v2);
        solucao.mostrarProdutoEscalar( v1, v2,resultado);
    }

    private void calcularProdutoVetorial() {
        System.out.println("\n--- PRODUTO VETORIAL ---");
        System.out.println("\nPrimeiro vetor:");
        Vetor v1 = lerVetor();
        System.out.println("\nSegundo vetor:");
        Vetor v2 = lerVetor();
        Vetor resultado =operacaoVetor.produtoVetorial(v1, v2);
        solucao.mostrarProdutoVetorial(v1,v2, resultado);
    }

    private void calcularModulo() {
        System.out.println("\n--- MÓDULO DO VETOR ---");
        Vetor vetor = lerVetor();
        double resultado = operacaoVetor.modulo(vetor);
        solucao.mostrarModulo( vetor,resultado);
    }

    private void verificarOrtogonalidade() {
        System.out.println("\n--- ORTOGONALIDADE ---");
        System.out.println("\nPrimeiro vetor:");
        Vetor v1 = lerVetor();
        System.out.println("\nSegundo vetor:");
        Vetor v2 = lerVetor();
        double produtoEscalar = operacaoVetor.produtoEscalar(v1, v2);
        boolean resultado = calculadora.vetoresSaoOrtogonais(v1, v2);
        solucao.mostrarOrtogonalidade(v1,v2, produtoEscalar,resultado);
    }

    private void verificarParalelismo() {
        System.out.println("\n--- PARALELISMO ---");
        System.out.println("\nPrimeiro vetor:");
        Vetor v1 = lerVetor();
        System.out.println("\nSegundo vetor:");
        Vetor v2 = lerVetor();
        Vetor produtoVetorial = operacaoVetor.produtoVetorial(v1, v2);
        boolean resultado = calculadora.vetoresSaoParalelos(v1, v2);
        solucao.mostrarParalelismo(v1,v2,produtoVetorial,resultado);
    }

    private void encontrarVetorParalelo() {
        System.out.println("\n--- VETOR PARALELO ---");
        Vetor vetor = lerVetor();
        System.out.print("Digite o escalar: ");
        double escalar = scanner.nextDouble();
        Vetor resultado = calculadora.encontrarVetorParalelo(vetor,escalar);
        solucao.mostrarVetorParalelo(vetor,escalar,resultado);
    }

    private void calcularAngulo() {
        System.out.println("\n--- ÂNGULO ENTRE VETORES ---");
        System.out.println("\nPrimeiro vetor:");
        Vetor v1 = lerVetor();
        System.out.println("\nSegundo vetor:");
        Vetor v2 = lerVetor();
        double produtoEscalar =operacaoVetor.produtoEscalar(v1, v2);
        double modulo1 = operacaoVetor.modulo(v1);
        double modulo2 = operacaoVetor.modulo(v2);
        double angulo = calculadora.CalcularAngulo(v1, v2);
        solucao.mostrarAngulo(v1,v2,produtoEscalar,modulo1, modulo2, angulo);
    }

    private void encontrarPonto() {
        System.out.println("\n--- PONTO ATRAVÉS DE VETOR ---");
        System.out.println("\nDigite o ponto:");
        Ponto ponto = lerPonto();
        System.out.println("\nDigite o vetor:");
        Vetor vetor = lerVetor();
        Ponto resultado = operacaoPonto.adicionarVetor(ponto,vetor);
        solucao.mostrarPontoAtravésDeVetor(ponto,vetor,resultado);
    }

    private void resolverEquacaoVetorial() {
        System.out.println("\n--- EQUAÇÃO VETORIAL ---");
        System.out.println("\nDigite o ponto inicial:");
        Ponto ponto = lerPonto();
        System.out.println("\nDigite o vetor diretor:");
        Vetor vetor = lerVetor();
        solucao.mostrarEquacaoVetorial(ponto,vetor);
    }

    private void verificarVetorUnitario() {
        System.out.println("\n--- VETOR UNITÁRIO ---");
        Vetor vetor = lerVetor();
        double modulo = operacaoVetor.modulo(vetor);
        boolean ehUnitario = calculadora.vetorEhUnitario(vetor);

        if (ehUnitario) {
            System.out.println("\nO vetor já é unitário.");
            solucao.mostrarUnitario(vetor,modulo,vetor);
        } else {
            Vetor resultado = operacaoVetor.multiplicaVetorPorEscalar(vetor,1 / modulo);
            solucao.mostrarUnitario(vetor,modulo,resultado);
        }
    }
}
