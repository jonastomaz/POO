package playlist;
import java.util.HashSet;
import musica.Musica;

public class Playlist {

    private String nome;
    private String descricao;
    private String criador;
    private HashSet<Musica> musicas;

    public Playlist(String nome, String descricao, String criador) {
        this.nome = nome;
        this.descricao = descricao;
        this.criador = criador;
        this.musicas = new HashSet<Musica>();
    }

    public boolean adicionarMusica(Musica musica) {
        return musicas.add(musica);
    }

    public int contarMusicas() {
        return musicas.size();
    }
    
    public String listarMusicas() {
    	String musica = "";
    	for(Musica musicaPlaylist : this.musicas) {
    		musica += musicaPlaylist.toString();
    	}
    	return musica;
    }
    
    @Override
    public String toString() {
        return nome + " - " + descricao + " - " + criador;
    }
}
