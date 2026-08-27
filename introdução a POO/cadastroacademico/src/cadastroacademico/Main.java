package cadastroacademico;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("informe o codigo da disciplina: ");
		String codigo_disciplina = input.next();
		Turma turmas = new Turma(codigo_disciplina);
		
		String opc = "s";
		
		while(opc.equalsIgnoreCase("s")) {
			System.out.print("deseja cadastrar um aluno S OU N: ");
			opc = input.next();
			
			if(opc.equalsIgnoreCase("s")) {
				
				System.out.print("digite o nome do aluno: ");
				String nome = input.next();
				
				System.out.print("digite a matricula do aluno: ");
				String matricula = input.next();
				
				System.out.print("digite a nota do aluno: ");
				double nota_1 = input.nextDouble();
				
				System.out.print("digite a nota 2 do aluno: ");
				double nota_2 = input.nextDouble();
				
				Aluno novo_aluno = new Aluno(matricula, nome, nota_1, nota_2);
				turmas.adicionar_aluno(novo_aluno);	
			}
		}
		System.out.println("disciplina: " + codigo_disciplina);
		System.out.println("alunos cadastrados: " + turmas.aluno.length);
		
		System.out.println("Alunos aprovados: ");
		for (Aluno alunos_aprovados : turmas.aluno) {
			alunos_aprovados.calcularMedia();
			if(alunos_aprovados.estaAprovado()) {
				System.out.println("nome: " + alunos_aprovados.nome + 
						"| matricula: " + alunos_aprovados.matricula + 
						"| media: " + alunos_aprovados.media);
			}
		}
		
		input.close();
	}

}
