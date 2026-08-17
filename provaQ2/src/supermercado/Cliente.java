package supermercado;

public abstract class Cliente {
	private String codigo;
	private String nome;
	private int documento;
	private String email;
	private int quantPontos;
	
	public Cliente(String codigo, String nome, int documento, String email) throws Exception {
		if(nome == null || nome.isBlank()) {
			throw new Exception("nome invalido");
		}
		if(codigo == null || codigo.isBlank()) {
			throw new Exception("codigo invalido");
		}
		if(documento == 0) {
			throw new Exception("codigo invalido");
		}
		if(email == null || email.isBlank()) {
			throw new Exception("codigo invalido");
		}
		this.codigo = codigo;
		this.nome = nome;
		this.documento = documento;
		this.email = email;
		this.quantPontos = 0;
	}
	
	protected abstract double valorFinalCompra(double valor);
	protected abstract int pontosRecebidos(double valor);

	public String getCodigo() {
		return codigo;
	}

	public String getNome() {
		return nome;
	}

	public int getQuantPontos() {
		return quantPontos;
	}

	public void setQuantPontos(int quantPontos) {
		this.quantPontos += quantPontos;
	}

	@Override
	public String toString() {
		return  codigo + " | " + nome + " | " + quantPontos + " pontos";
	}
	
	
}
