package chadeBebe;

public class Presente {
	String tamanho_roupaItem;
	String nome_convidado;
	String descricao;
	int codigo;
	
	Presente(String tamanho_roupaItem, String nome_convidado, String descricao, int codigo){
		this.codigo = codigo;
		this.descricao = descricao;
		this.nome_convidado = nome_convidado;
		this.tamanho_roupaItem = tamanho_roupaItem;
	}
	
}
