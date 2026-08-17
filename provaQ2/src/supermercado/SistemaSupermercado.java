package supermercado;

import java.util.ArrayList;
import java.util.List;

public class SistemaSupermercado {
	private List<Cliente> clientes;

	public SistemaSupermercado() {
		this.clientes = new ArrayList<>();
	}
	
	public Cliente consultaCliente(String codigo) {
		for(Cliente c: clientes) {
			if(c.getCodigo().equals(codigo)) {
				return c;
			}
		}
		return null;
	}
	
	public boolean cadastrarCliente(String codigo, String nome, int documento, String email, String categoria) throws Exception {
		if(consultaCliente(codigo) != null) {
			return false;
		}
		Cliente cliente;
		switch (categoria.toLowerCase()){
			case "comum":
				cliente = new ClienteComum(codigo, nome, documento, email, categoria);
				clientes.add(cliente);
				return true;
			case "ouro":
				cliente = new ClienteOuro(codigo, nome, documento, email, categoria);
				clientes.add(cliente);
				return true;
			case "diamante":
				cliente = new ClienteDiamante(codigo, nome, documento, email, categoria);
				clientes.add(cliente);
				return true;
			default:
				return false;
		}
	}
	
	public boolean removerCliente(String codigo) {
		if(consultaCliente(codigo) == null) {
			return false;
		}
		clientes.remove(consultaCliente(codigo));
		return true;
	}
	
	public double registrarCompra(String codigo, double valor) {
		Cliente cliente = consultaCliente(codigo);
		if(cliente == null || valor <= 0) {
			return 0;
		}
		double valorCompra = cliente.valorFinalCompra(valor);
		int quantPontos = cliente.pontosRecebidos(valor);
		cliente.setQuantPontos(quantPontos);
		
		return valorCompra;
	}
	
	public int contarClientes() {
		return clientes.size();
	}
}
