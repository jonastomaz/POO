package sistemabancario;

class ContaBancaria{
	int numero;
	String titular;
	double saldo;
	
	public ContaBancaria(int numero, String titular, double saldo) {
		this.numero = numero;
		this.titular = titular;
		this.saldo = saldo;
	}
	
	boolean possuiSaldoMaiorque(double valor) {
		return this.saldo > valor;
	}
}