
public class HubEntregas {
	Entregador[] entregadores;
	int quantidadeEntregadores;
	int quantidadeMaximaPacotesPorEntregador;
	
	HubEntregas(int quantidadeMaximaPacotesPorEntregador, int quantidadeMaximaEntregadores){
		this.entregadores = new Entregador[quantidadeMaximaEntregadores];
		this.quantidadeMaximaPacotesPorEntregador = quantidadeMaximaPacotesPorEntregador;
		this.quantidadeEntregadores = 0;
	}
	
	boolean cadastrarEntregador(String nome, String telefone) {
		if(this.quantidadeEntregadores < this.entregadores.length) {
			Entregador novo_entregador = new Entregador(nome, telefone, this.quantidadeMaximaPacotesPorEntregador);
			this.entregadores[this.quantidadeEntregadores] = novo_entregador;
			this.quantidadeEntregadores ++;
			return true;
		}
		return false;
	}
	
	Entregador buscarEntregadorPorNome(String nome) {
		for(int i = 0; i < this.quantidadeEntregadores; i++) {
			if(this.entregadores[i].nome.equalsIgnoreCase(nome)) {
				return this.entregadores[i];
			}
		}
		return null;
	}
	
	boolean cadastrarPacote(String nomeEntregador, String codigo, String destinatario) {
		if(buscarEntregadorPorNome(nomeEntregador) == null) {
			return false;
		}
		Pacote novo_pacote = new Pacote(codigo, destinatario);
		buscarEntregadorPorNome(nomeEntregador).adicionarPacotes(novo_pacote);
		return true;
	}
	
	boolean removerPacotePorCodigo(String codigo) {
		for(int i = 0; i < this.quantidadeEntregadores; i++) {
			if(this.entregadores[i].buscarPacotePorCodigo(codigo) != null) {
				this.entregadores[i].removerPacotePorCodigo(codigo);
				return true;
			}
		}
		return false;
	}
	
	boolean marcarPacoteComoEntregue(String codigo) {
		for(int i = 0; i < this.quantidadeEntregadores; i++) {
			if(this.entregadores[i].buscarPacotePorCodigo(codigo) != null) {
				this.entregadores[i].marcarPacoteComoEntregue(codigo);
				return true;
			}
		}
		return false;
	}
	
	void listarEntregadores() {
		for(int i = 0; i < this.quantidadeEntregadores; i++) {
			System.out.println(this.entregadores[i]);
		}
	}
}
