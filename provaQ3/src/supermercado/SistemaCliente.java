package supermercado;

import java.util.ArrayList;
import java.util.List;

import estrategia.Estrategia;

public class SistemaCliente {
	private List<Cliente> clientes;

	public SistemaCliente() {
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
	
	public boolean cadastrarCliente(String codigo, String nome, int documento, String email) throws Exception {
		if(consultaCliente(codigo) != null) {
			return false;
		}
		Cliente cliente = new Cliente(codigo, nome, documento, email);
		clientes.add(cliente);
		return true;
	}
	
	public double registrarCompra(String codigo, double valor) {
		Cliente cliente = consultaCliente(codigo);
		if(cliente == null || valor <= 0) {
			return 0;
		}
		return cliente.registrarCompra(valor);
	}
	
	public int contarClientes() {
		return clientes.size();
	}
	
	public String simularCompra(double valor, Estrategia estrategia) {
		SimularCompra simular = new SimularCompra(estrategia);
		return "Valor da compra = " + simular.calcularValorCompra(valor) + "\n" +
				"pontos obtidos = " + simular.mostrarPontosRecebidos(valor);
	}
}
