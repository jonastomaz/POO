package cadastroacademico;

public class Aluno {
	String matricula;
	String nome;
	double nota1;
	double nota2;
	double media;
	
	public Aluno(String matricula_aluno, String nome_aluno, double nota_1, double nota_2) {
		this.matricula = matricula_aluno;
		this.nome = nome_aluno;
		this.nota1 = nota_1;
		this.nota2 = nota_2;
	}
	
	void calcularMedia(){
		this.media = (this.nota1 + this.nota2) / 2;
	}
	
	boolean estaAprovado() {
		if (this.media >= 7) {
			return true;
		}
		return false;
	}
	
}
