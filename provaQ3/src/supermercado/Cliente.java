package supermercado;

import estrategia.EstategiaComum;
import estrategia.EstategiaOuro;
import estrategia.Estrategia;
import estrategia.EstrategiaDiamante;
import estrategia.EstrategiaPlatina;

public class Cliente {
	private String codigo;
	private String nome;
	private int documento;
	private String email;
	private int quantPontos;
	private Estrategia estrategia;
	
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
		this.estrategia = new EstategiaComum();
	}
	
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
		return  "Código: " + codigo + " | Nome: " + nome + " | Documento: " + documento + " | E-mail: " + email 
				+ " | Pontos: " + quantPontos + " | Categoria: " + estrategia.getCategoria();
	}
	
	private void mudarEstrategia() {
		if(getQuantPontos() >= 300) {
			this.estrategia = new EstrategiaDiamante();
		}else if (getQuantPontos() >= 150) {
			this.estrategia = new EstrategiaPlatina();
		}else if (getQuantPontos() >= 50) {
			this.estrategia = new EstategiaOuro();
		}else {
			this.estrategia = new EstategiaComum();
		}
	}
	
	public double registrarCompra(double valor) {
		if(valor <= 0) {
			return 0;
		}
		double valorCompra = this.estrategia.valorFinalCompra(valor);
		int pontos = this.estrategia.pontosRecebidos(valor);
		setQuantPontos(pontos);
		mudarEstrategia();
		return valorCompra;
	}
}
