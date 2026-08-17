package heroi;

import java.util.Objects;

public class Heroi {

	private int codigoNumerico;
	private String nomeVerdadeiro;
	private String codinome;
	private int energia;
	private int experiencia;
	
	public Heroi(int codigoNumerico, String nomeVerdadeiro, String codinome, int energia, int experiencia) {
		this.codigoNumerico = codigoNumerico;
		this.nomeVerdadeiro = nomeVerdadeiro;
		this.codinome = codinome;
		this.energia = validarValor(energia);
		this.experiencia = validarValor(experiencia);
	}


	@Override
	public int hashCode() {
		return Objects.hash(codigoNumerico);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Heroi other = (Heroi) obj;
		return codigoNumerico == other.codigoNumerico;
	}


	protected int validarValor(int valor) {
		if(valor >= 0) {
			return valor;
		}
		return 0;
	}

	public int getExperiencia() {
		return experiencia;
	}

	public int getEnergia() {
		return energia;
	}
	
	public String getCodinome() {
		return codinome;
	}

	public String getNomeVerdadeiro() {
		return nomeVerdadeiro;
	}

	public int getCodigo() {
		return codigoNumerico;
	}
	
	public String usarHabilidade() {
		return getCodinome();
	}

	public void setEnergia(int valor) {
		this.energia -= valor;
	}
	
	public void setExperiencia(int experiencia) {
		this.experiencia += experiencia;
	}

	public int calcularForcaTotal() {
		return getEnergia() + getExperiencia();
	}
}
