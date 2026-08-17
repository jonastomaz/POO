package heroi;

public class HeroiMistico extends Heroi{
	private String origemDoPoder;
	private int nivelDeMagia;
	
	public HeroiMistico(int codigoNumerico, String nomeVerdadeiro, String codinome, int energia, int experiencia,
			String origemDoPoder, int nivelDeMagia) {
		super(codigoNumerico, nomeVerdadeiro, codinome, energia, experiencia);
		this.origemDoPoder = origemDoPoder;
		this.nivelDeMagia = validarValor(nivelDeMagia);
	}
	
	@Override
	public int calcularForcaTotal() {
		return super.calcularForcaTotal() + (4 * this.nivelDeMagia);
	}
	
	@Override
	public String usarHabilidade() {
		if(getEnergia() >= 10) {
			setEnergia(10);
			return super.usarHabilidade() + " invoca os poderes do " + this.origemDoPoder + " e cria um poderoso feitico.";
		}
		return super.usarHabilidade() + " nao possui energia suficiente para utilizar sua habilidade.";
	}
	
	@Override
	public String toString() {
		return "Codigo: "+ getCodigo() + "\nNome verdadeiro: " + getNomeVerdadeiro() + "\nCodinome: "+ getCodinome() + 
				"\nEnergia: " + getEnergia() + "\nExperiencia: " + getExperiencia() + 
				"\nOrigem do poder: " + this.origemDoPoder  + "\nNivel de magia: " + this.nivelDeMagia;
	}
}
