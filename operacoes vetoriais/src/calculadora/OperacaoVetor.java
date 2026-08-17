package calculadora;
import vetor.Vetor;

public class OperacaoVetor {
	
	public Vetor somarVetor(Vetor vetor1, Vetor vetor2) {
		Vetor somaVetor = new Vetor(vetor1.getX() + vetor2.getX(), vetor1.getY() + vetor2.getY(), vetor1.getZ() + vetor2.getZ());
		return somaVetor;
	}
	
	public Vetor subtrairVetor(Vetor vetor1, Vetor vetor2) {
		Vetor subtrairVetor = new Vetor(vetor1.getX() - vetor2.getX(), vetor1.getY() - vetor2.getY(), vetor1.getZ() - vetor2.getZ());
		return subtrairVetor;
	}
	
	public Vetor multiplicaVetorPorEscalar(Vetor vetor1, double escalar) {
		Vetor VetorPorEscalar = new Vetor(vetor1.getX() * escalar, vetor1.getY() * escalar, vetor1.getZ()* escalar);
		return VetorPorEscalar;
	}
	
	public double produtoEscalar(Vetor vetor1, Vetor vetor2) {
		double produtoEscalar = (vetor1.getX() * vetor2.getX() + vetor1.getY() * vetor2.getY() + vetor1.getZ() * vetor2.getZ());
		return produtoEscalar;
	}
	
	public Vetor produtoVetorial(Vetor vetor1, Vetor vetor2) {
		double X = (vetor1.getY() * vetor2.getZ()) - (vetor1.getZ() * vetor2.getY());
		double Y = (vetor1.getZ() * vetor2.getX()) - (vetor1.getX() * vetor2.getZ());
		double Z = (vetor1.getX() * vetor2.getY()) - (vetor1.getY() * vetor2.getX());
		
		return new Vetor(X,Y,Z);
	}
	
	public double modulo(Vetor vetor) {
		double moduloVetor = Math.sqrt(Math.pow(vetor.getX(), 2) + Math.pow(vetor.getY(), 2) + Math.pow(vetor.getZ(), 2));
		return moduloVetor;
	}
}
