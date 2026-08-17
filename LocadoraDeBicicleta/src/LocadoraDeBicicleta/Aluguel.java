package LocadoraDeBicicleta;

public class Aluguel {

    private Cliente cliente;
    private Bicicleta bicicleta;
    private int dias;
    private double valorTotal;
    private boolean ativo;

    public Aluguel(Cliente cliente, Bicicleta bicicleta, int dias) {

        if (dias <= 0) {
            dias = 1;
        }

        this.cliente = cliente;
        this.bicicleta = bicicleta;
        this.dias = dias;
        this.valorTotal = bicicleta.getDiaria() * dias;
        this.ativo = true;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Bicicleta getBicicleta() {
        return bicicleta;
    }

    public int getDias() {
        return dias;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void encerrar() {
        ativo = false;
    }
}
