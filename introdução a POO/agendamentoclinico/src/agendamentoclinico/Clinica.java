package agendamentoclinico;
import java.util.Arrays;

public class Clinica {
	String nome;
	Consulta[] agenda;
	
	public Clinica(String nome_clinica) {
		this.nome = nome_clinica;
		this.agenda = new Consulta[0];
	}
	
	void agendarConsulta(Consulta nova_consulta) {
		Consulta[] consulta = Arrays.copyOf(this.agenda, this.agenda.length + 1);
		consulta[consulta.length - 1] = nova_consulta;
		this.agenda = consulta;
	}
	
	void imprimirConsultasPorMedico(String nome_medico) {
		for(int i = 0; i < this.agenda.length; i++) {
			if(this.agenda[i].medico.nome.equalsIgnoreCase(nome_medico)) {
				System.out.println("data: " + this.agenda[i].data + 
						"| paciente: " + this.agenda[i].paciente.nome 
						+ " (" + this.agenda[i].paciente.idade + ") anos");
			}
		}
	}
}
