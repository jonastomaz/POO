package guilda;

public class Arqueiro extends Personagem{
	private String TipoArco;
	private int valorPrecisao;
	
	public Arqueiro(int código, String nome, int nível, int energia, int experiência, String tipoArco,
			int valorPrecisao) throws Exception {
		super(código, nome, nível, energia, experiência);
		if(tipoArco == null || tipoArco.isEmpty()) {
			throw new Exception("nome da arma esta vazio ou nulo");
		}
		if(valorPrecisao < 0) {
			throw new Exception("valor da forca menor que 0");
		}
		this.TipoArco = tipoArco;
		this.valorPrecisao = valorPrecisao;
	}

	@Override
	public int calcularPoderTotal() {
		return getEnergia() + getExperiencia() + (2*getNivel()) + (3*valorPrecisao);
	}
	
	@Override
	public String usarHabilidade() {
		if(getEnergia() < 10) {
			return getNome() + " nao possui energia suficiente para utilizar sua habilidade.";
		}
		setEnergia(10);
		return getNome()+" dispara uma chuva de flechas com " + TipoArco;
	}
	
	@Override
    public String toString(){
        return super.toString() + "\nArco: " + TipoArco + "\nPrecisão: " + valorPrecisao + "\nPoder total: " + calcularPoderTotal();
    }
	
}
