package controlador;

import guilda.Personagem;
import guilda.SistemaGuilda;

public class ControladorGuilda {

	private SistemaGuilda sistema;

	public ControladorGuilda() {
		sistema = new SistemaGuilda();
	}

	public boolean cadastrarGuerreiro(int codigo, String nome, int nivel, int energia, int experiencia, String arma,
			int forca) {
		return sistema.cadastrarGuerreiro(codigo, nome, nivel, energia, experiencia, arma, forca);
	}
	
	public boolean cadastrarArqueiro(int codigo, String nome, int nivel, int energia, int experiencia, String tipoArco,
			int valorPrecisao) {
		return sistema.cadastrarArqueiro(codigo, nome, nivel, energia, experiencia, tipoArco, valorPrecisao);
	}

	public boolean cadastrarMago(int codigo, String nome, int nivel, int energia, int experiencia, String elemento,
			int poderMagico) {
		return sistema.cadastarMago(codigo, nome, nivel, energia, experiencia, elemento, poderMagico );
	}
	
	public String consultarPersonagem(int codigo) {
		return sistema.consultarPersonagem(codigo);
	}

	public String usarHabilidade(int codigo) {
		return sistema.usarHabilidade(codigo);
	}

	public String registrarConclusaoMissao(int codigo, int dificuldade) {
		return sistema.registrarConclusaoMissao(codigo, dificuldade);
	}

	public Personagem localizarMaisPoderoso() {
		return sistema.localizarMaisPoderoso();
	}

	public int contarPersonagens() {
		return sistema.contarPersonagem();
	}
	
	public String exibirResumoGuilda() {
		return sistema.exibirResumoGuilda();
	}
	
	public String listarPersonagens() {
		return sistema.listarPersonagens();
	}
	
	public int poderTotalGuida() {
		return sistema.poderTotalGuida();
	}
}