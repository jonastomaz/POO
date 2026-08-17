package supermercado;
import estrategia.Estrategia;

public class SimularCompra {
	private Estrategia estrategia;

	public SimularCompra(Estrategia estrategia) {
		this.estrategia = estrategia;
	}
	
	public double calcularValorCompra(double valor) {
		return this.estrategia.valorFinalCompra(valor);
	}
	
	public int mostrarPontosRecebidos(double valor) {
		return this.estrategia.pontosRecebidos(valor);
	}
}
