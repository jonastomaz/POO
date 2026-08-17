package heroi;

public class HeroiTecnologico extends Heroi{
	private String equipamentoPrincipal;
	private int nivelTecnologico;
	
	public HeroiTecnologico(int codigoNumerico, String nomeVerdadeiro, String codinome, int energia, int experiencia,
			String equipamentoPrincipal, int nivelTecnologico) {
		super(codigoNumerico, nomeVerdadeiro, codinome, energia, experiencia);
		this.equipamentoPrincipal = equipamentoPrincipal;
		this.nivelTecnologico = validarValor(nivelTecnologico);
	}
	
	@Override
	public int calcularForcaTotal() {
		return super.calcularForcaTotal() + (3 * this.nivelTecnologico);
	}
	
	@Override
	public String usarHabilidade() {
		if(getEnergia() >= 10) {
			setEnergia(10);
			return super.usarHabilidade() + " ativa a " + this.equipamentoPrincipal + " e dispara seus dispositivos tecnologicos.";
		}
		return super.usarHabilidade() + " nao possui energia suficiente para utilizar sua habilidade.";
	}
	
	@Override
	public String toString() {
		return "Codigo: "+ getCodigo() + "\nNome verdadeiro: " + getNomeVerdadeiro() + "\nCodinome: "+ getCodinome() + 
				"\nEnergia: " + getEnergia() + "\nExperiencia: " + getExperiencia() 
				+ "\nEquipamento principal: " + this.equipamentoPrincipal + "\nNivel tecnologico: " + this.nivelTecnologico;
	}
}
