package estrategia;

public interface Estrategia {
	double valorFinalCompra(double valor);
	int pontosRecebidos(double valor);
	String getCategoria();
}
