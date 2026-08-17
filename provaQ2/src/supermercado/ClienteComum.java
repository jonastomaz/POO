package supermercado;

public class ClienteComum extends Cliente{
	private String categoria;

	public ClienteComum(String codigo, String nome, int documento, String email, String categoria) throws Exception {
		super(codigo, nome, documento, email);
		this.categoria = categoria;
	}

	@Override
	public double valorFinalCompra(double valor) {
		return valor;
	}

	@Override
	public int pontosRecebidos(double valor) {
		return (int)(valor/10);
	}

	@Override
	public String toString() {
		return super.toString() + " | " + categoria;
	}
}
