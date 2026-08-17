package heroi;

public class HeroiFisico extends Heroi{
	private int nivelDeForca;

	public HeroiFisico(int codigoNumerico, String nomeVerdadeiro, String codinome, int energia, int experiencia,
			int nivelDeForca) {
		super(codigoNumerico, nomeVerdadeiro, codinome, energia, experiencia);
		this.nivelDeForca = validarValor(nivelDeForca);
	}
	
	@Override
	public int calcularForcaTotal() {
		return super.calcularForcaTotal() + (2 * this.nivelDeForca);
	}
	
	@Override
	public String toString() {
		return "Codigo: "+ getCodigo() + "\nNome verdadeiro: " + getNomeVerdadeiro() + "\nCodinome: "+ getCodinome() + 
				"\nEnergia: " + getEnergia() + "\nExperiencia: " + getExperiencia() + "\nNivel de forca: " + this.nivelDeForca;
	}

	@Override
	public String usarHabilidade() {
		if(getEnergia() >= 10) {
			setEnergia(10);
			return super.usarHabilidade() + " golpeia o inimigo utilizando sua forca extraordinaria.";
		}
		return super.usarHabilidade() + " nao possui energia suficiente para utilizar sua habilidade.";
	}
}
