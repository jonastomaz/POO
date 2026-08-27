package agendamentoclinico;

public class Consulta {
	String data;
	Medico medico;
	Paciente paciente;
	
	public Consulta(String data_consulta, Medico medico_consulta, Paciente paciente_consulta) {
		this.data = data_consulta;
		this.medico = medico_consulta;
		this.paciente = paciente_consulta;
	}
}
