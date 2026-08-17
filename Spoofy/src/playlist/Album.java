package playlist;
import java.util.ArrayList;
import java.util.Objects;
import musica.Musica;

public class Album {

    private String titulo;
    private String artista;
    private int ano;
    private ArrayList<Musica> musicas;

    public Album(String titulo, String artista, int ano) {
        this.titulo = titulo;
        this.artista = artista;
        this.ano = ano;
        musicas = new ArrayList<Musica>();
    }

    public void adicionarMusica(Musica musica) {
        musicas.add(musica);
    }

    public int contarMusicas() {
        return musicas.size();
    }

    public int tempoTotal() {
        int soma = 0;

        for (Musica m : musicas)
            soma += m.getDuracao();

        return soma;
    }
    
    public String exibirMusicas() {
        String musicas = "";
        for (int i = 0; i < this.musicas.size(); i++) {
            musicas += (i + 1) + ". " + this.musicas.get(i);
            if (i < this.musicas.size() - 1) {
                musicas += "\n";
            }
        }
        return musicas;
    }

    @Override
    public String toString() {
        return titulo + " - " + artista + " - " + ano;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Album))
            return false;
        Album outro = (Album) obj;
        return titulo.equals(outro.titulo)
                && artista.equals(outro.artista)
                && ano == outro.ano;
    }

    @Override
    public int hashCode() {
        return Objects.hash(titulo, artista, ano);
    }
}
