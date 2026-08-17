package calculadora;

import vetor.Vetor;

public class CalculadoraVetorial {
	private OperacaoVetor operacao;

	public CalculadoraVetorial() {
		this.operacao = new OperacaoVetor();
	}
	
	public boolean vetoresSaoOrtogonais(Vetor vetor1, Vetor vetor2) {
		return operacao.produtoEscalar(vetor1, vetor2) == 0;
	}
	
	public boolean vetoresSaoParalelos(Vetor vetor1, Vetor vetor2) {
		double X = (vetor1.getY() * vetor2.getZ()) - (vetor1.getZ() * vetor2.getY());
		double Y = (vetor1.getZ() * vetor2.getX()) - (vetor1.getX() * vetor2.getZ());
		double Z = (vetor1.getX() * vetor2.getY()) - (vetor1.getY() * vetor2.getX());
		
		return X == 0 && Y == 0 && Z == 0;
	}
	
	public boolean vetorEhUnitario(Vetor vetor) {
		return operacao.modulo(vetor) == 1;
	}
	
	public double CalcularAngulo(Vetor vetor1, Vetor vetor2) {
		double produto = operacao.produtoEscalar(vetor1, vetor2);
		
		double moduloVetor1 = operacao.modulo(vetor1);
		double moduloVetor2 = operacao.modulo(vetor2);
		
		return Math.toDegrees(Math.acos(produto / (moduloVetor1 * moduloVetor2)));
	}
	
	public Vetor encontrarVetorParalelo(Vetor vetor, double escalar) {
		return operacao.multiplicaVetorPorEscalar(vetor, escalar);
	}
}
