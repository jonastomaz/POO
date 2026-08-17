package musica;

import java.util.Objects;

public class Musica {

    private String titulo;
    private String artista;
    private int duracao;
    private String genero;
    private int codigo;

    public Musica(String titulo, String artista, int duracao, String genero, int codigo) {
        this.titulo = titulo;
        this.artista = artista;
        this.duracao = duracao;
        this.genero = genero;
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    public int getDuracao() {
        return duracao;
    }

    @Override
    public String toString() {
        return codigo + " - " + titulo + " - " + artista + " - " + duracao + "s - " + genero;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Musica))
            return false;

        Musica outra = (Musica) obj;
        return codigo == outra.codigo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }
}
