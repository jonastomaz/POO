package calculadora;

import vetor.Ponto;
import vetor.Vetor;

public class OperacaoPonto {
	
	public Vetor encontrarVetor(Ponto A, Ponto B) {
		Vetor vetor = new Vetor(B.getX() - A.getX(), B.getY() - A.getY(), B.getZ() - A.getZ());
		return vetor;
	}
	
	public Ponto adicionarVetor(Ponto A, Vetor vetor) {
		Ponto ponto = new Ponto(vetor.getX() + A.getX(), vetor.getY() + A.getY(), vetor.getZ() + A.getZ());
		return ponto;
	}
}
