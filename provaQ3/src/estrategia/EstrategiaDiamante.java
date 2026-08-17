package estrategia;

public class EstrategiaDiamante implements Estrategia{
	@Override
	public double valorFinalCompra(double valor) {
		return valor * 0.7;
	}

	@Override
	public int pontosRecebidos(double valor) {
		return (int)(valor/10) * 15;
	}

	@Override
	public String getCategoria() {
		return "Diamante";
	}
}
