package cadastroacademico;
import java.util.Arrays;

public class Turma {
	String codigoDisciplina;
	Aluno[] aluno;
	
	public Turma(String codigo_Disciplia) {
		this.codigoDisciplina = codigo_Disciplia;
		this.aluno = new Aluno[0];
	}
	
	void adicionar_aluno(Aluno aluno_A) {
		Aluno[] novo_aluno = Arrays.copyOf(this.aluno, this.aluno.length + 1);
		novo_aluno[novo_aluno.length - 1] = aluno_A;
		this.aluno = novo_aluno;
	}
}
