package estrategia;

public class EstategiaOuro implements Estrategia{
	@Override
	public double valorFinalCompra(double valor) {
		return valor * 0.85;
	}

	@Override
	public int pontosRecebidos(double valor) {
		return (int)(valor/10) * 10;
	}

	@Override
	public String getCategoria() {
		return "Ouro";
	}
}
