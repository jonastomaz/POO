package LocadoraDeBicicleta;

public class Bicicleta {

    private String codigo;
    private String modelo;
    private double diaria;
    private boolean disponivel;

    public Bicicleta(String codigo, String modelo, double diaria) {
        this.codigo = codigo;
        this.modelo = modelo;
        this.diaria = validarDiaria(diaria);
        this.disponivel = true;
    }

    private double validarDiaria(double valor) {
        if (valor > 0) {
            return valor;
        }
        return 10.0;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getModelo() {
        return modelo;
    }

    public double getDiaria() {
        return diaria;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void alugar() {
        disponivel = false;
    }

    public void devolver() {
        disponivel = true;
    }
}