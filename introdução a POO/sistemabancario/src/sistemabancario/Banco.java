package sistemabancario;
import java.util.Arrays;
import sistemabancario.ContaBancaria;

class Banco{
	int codigoBancario;
	ContaBancaria[] contas;
	
	public Banco(int codigo_banco) {
		this.codigoBancario = codigo_banco;
		this.contas = new ContaBancaria[0];
	}
	
	void adicionarConta(ContaBancaria novaconta) {
		ContaBancaria[] novoVetor = Arrays.copyOf(this.contas, this.contas.length + 1);
		novoVetor[novoVetor.length - 1] = novaconta;
		this.contas = novoVetor;
	}
}