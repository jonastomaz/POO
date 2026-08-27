package agendamentoclinico;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("digite o nome da clinica: ");
		String nome_clinica = input.next();
		Clinica clinica = new Clinica(nome_clinica);
		
		String opc = "s";
		while(opc.equalsIgnoreCase("S")) {
			System.out.print("agendar consulta S OU N: ");
			opc = input.next();
			
			if (opc.equalsIgnoreCase("s")) {
				System.out.print("informe a data da consulta: ");
				String data = input.next();
				
				System.out.print("informe o nome do medico: ");
				String nome_medico = input.next();
				System.out.print("informe a especialidade do medico: ");
				String especialidade_medico = input.next();
				Medico medico = new Medico(nome_medico, especialidade_medico);
				
				System.out.print("informe o nome do paciente: ");
				String nome_paciente = input.next();
				System.out.print("informe a idade do paciente: ");
				int idade_paciente = input.nextInt();
				Paciente paciente = new Paciente(nome_paciente, idade_paciente);
				
				Consulta consulta = new Consulta(data, medico, paciente);
				
				clinica.agendarConsulta(consulta);
			}
		}
		System.out.print("qual o nome do medico para buscar na agenda: ");
		String agenda_medico = input.next();
		
		clinica.imprimirConsultasPorMedico(agenda_medico);
		
		input.close();
	}

}
