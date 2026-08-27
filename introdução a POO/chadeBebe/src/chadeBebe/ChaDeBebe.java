package chadeBebe;

public class ChaDeBebe {
	int quantidadeAtual;
	Presente[] presente;
	
	ChaDeBebe(int quantidadeMaxima){
		this.quantidadeAtual = 0;
		this.presente = new Presente[quantidadeMaxima];
	}
	
	boolean cadastrarPresente(String tamanhoroupaItem, String nome_convidado, String descricao, int codigo) {
		if (this.quantidadeAtual < this.presente.length) {
			Presente novo_presente = new Presente(tamanhoroupaItem, nome_convidado, descricao, codigo);
			this.presente[this.quantidadeAtual] = novo_presente;
			this.quantidadeAtual ++;
			return true;
		}
		return false;
	}
	
	void verCardeninho() {
		if(this.quantidadeAtual > 0) {
			System.out.println("total de presentes guardados: " + this.presente.length);
			for(int i = 0; i < this.quantidadeAtual; i ++) {
				System.out.println("presente: " + this.presente[i].descricao + 
						" (tamanho " +  this.presente[i].tamanho_roupaItem
						+ ") de " +  this.presente[i].nome_convidado);
			}
		}
		return;
	}
	
	boolean removerPresente(int codigo) {
		boolean codigo_valido = false;
		for(int i = 0; i < this.presente.length; i++) {
			if(this.presente[i].codigo == codigo) {
				codigo_valido = true;
			}
		}
		if(codigo_valido) {
			for(int i = 0; i < this.presente.length; i++) {
				if(this.presente[i].codigo == codigo) {
					for(int j = i; j < this.presente.length-1; j++) {
						this.presente[j] = this.presente[j+1]; 
					}
				}
			}
			this.presente[this.quantidadeAtual - 1] = null;
			this.quantidadeAtual --;
			return true;
		}
		else {
			return false;
		}
}
	
	Presente[] procurarPresentePorConvidad(String nome_convidade) {
		Presente [] presente_contador = new Presente[this.quantidadeAtual];
		int quantidade_presente = 0;
		for(int i = 0; i < this.quantidadeAtual; i++) {
			if(this.presente[i].nome_convidado.equalsIgnoreCase(nome_convidade)) {
				presente_contador[quantidade_presente] = this.presente[i];
				quantidade_presente ++;
			}
		}
		Presente[] presente_encontrado = new Presente[quantidade_presente];
		for (int i = 0; i < quantidade_presente; i++) {
			presente_encontrado[i] = presente_contador[i];
		}
		return presente_encontrado;
	}
}
