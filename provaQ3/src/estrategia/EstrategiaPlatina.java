package estrategia;

public class EstrategiaPlatina implements Estrategia{
	@Override
	public double valorFinalCompra(double valor) {
		return valor * 0.75;
	}

	@Override
	public int pontosRecebidos(double valor) {
		return (int)(valor/10) * 12;
	}

	@Override
	public String getCategoria() {
		return "Platina";
	}
}
