public class Entregador {
	String nome;
	String telefone;
	Pacote[] pacotes;
	int quantidadePacotes;
	
	Entregador(String nome, String telefone, int quantidadeMaximaPacotes){
		this.nome = nome;
		this.telefone = telefone;
		this.pacotes = new Pacote[quantidadeMaximaPacotes];
		this.quantidadePacotes = 0;
	}
	
	boolean adicionarPacotes(Pacote pacotes) {
		if(this.quantidadePacotes < this.pacotes.length) {
			this.pacotes[this.quantidadePacotes] = pacotes;
			this.quantidadePacotes ++;
			return true;
		}
		return false;
	}
	
	Pacote buscarPacotePorCodigo(String codigo) {
		for(int i = 0; i < this.quantidadePacotes; i++) {
			if(this.pacotes[i].codigo.equalsIgnoreCase(codigo)) {
				return this.pacotes[i];
			}
		}
		return null;
	}
	
	boolean removerPacotePorCodigo(String codigo) {
		boolean opc = false;
		for(int i = 0; i < this.quantidadePacotes; i++) {
			if(this.pacotes[i].codigo.equalsIgnoreCase(codigo)) {
				opc = true;
				for(int j = i; j < this.quantidadePacotes - 1; j++) {
					this.pacotes[j] = this.pacotes[j+1];
				}
			}
		}
		if(opc) {
			this.pacotes[this.quantidadePacotes - 1] = null;
			this.quantidadePacotes --;
			return true;
		}
		return false;
	}
	
	boolean marcarPacoteComoEntregue(String codigo) {
		for(int i = 0; i < this.quantidadePacotes; i++) {
			if(this.pacotes[i].codigo.equalsIgnoreCase(codigo)) {
				this.pacotes[i].marcarComoEntregue();
			}
		}
		return true;
	}

	public String toString() {
		String entregador = "nome: " + this.nome + " telefone: " + this.telefone;
		for(int i = 0; i < this.quantidadePacotes; i++) {
			entregador += " " + this.pacotes[i] + "\n";
		}
		
		return entregador;
	}
}
