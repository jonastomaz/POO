package estrategia;

public class EstategiaComum implements Estrategia{

	@Override
	public double valorFinalCompra(double valor) {
		return valor;
	}

	@Override
	public int pontosRecebidos(double valor) {
		return (int)(valor/10) * 5;
	}

	@Override
	public String getCategoria() {
		return "Comum";
	}

}
