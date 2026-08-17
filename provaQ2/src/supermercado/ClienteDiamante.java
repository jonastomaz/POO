package supermercado;

public class ClienteDiamante extends Cliente{
	private String categoria;

	public ClienteDiamante(String codigo, String nome, int documento, String email, String categoria) throws Exception {
		super(codigo, nome, documento, email);
		this.categoria = categoria;
	}

	@Override
	public double valorFinalCompra(double valor) {
		return valor * 0.9;
	}

	@Override
	public int pontosRecebidos(double valor) {
		return (int)(valor/10) * 3;
	}

	@Override
	public String toString() {
		return super.toString() + " | " + categoria;
	}
}
