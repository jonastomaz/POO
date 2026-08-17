package principal;

import musica.Musica;
import playlist.Playlist;
import playlist.Album;

import java.util.ArrayList;
import java.util.HashMap;

public class SPOOfy {

    private ArrayList<Musica> catalogo;
    private HashMap<Integer, Musica> mapaMusicas;
    private ArrayList<Album> albuns;
    private HashMap<String, Playlist> playlists;

    public SPOOfy() {
        catalogo = new ArrayList<Musica>();
        mapaMusicas = new HashMap<Integer, Musica>();
        albuns = new ArrayList<Album>();
        playlists = new HashMap<String, Playlist>();
    }

    public boolean cadastrarMusica(String titulo, String artista, int duracao, String genero, int codigo) {
        if (mapaMusicas.containsKey(codigo))
            return false;
        Musica musica = new Musica(titulo, artista, duracao, genero, codigo);
        catalogo.add(musica);
        mapaMusicas.put(codigo, musica);

        return true;
    }

    public int contarMusicas() {
        return catalogo.size();
    }

    public String exibirMusicas() {
        String musicas = "";
        for (int i = 0; i < catalogo.size(); i++) {
            musicas += catalogo.get(i);
            if (i != catalogo.size() - 1)
                musicas += "\n";
        }
        return musicas;
    }

    public boolean cadastrarAlbum(String titulo, String artista, int ano) {
        Album album = new Album(titulo, artista, ano);
        if (albuns.contains(album))
            return false;
        albuns.add(album);
        return true;
    }

    public int contarAlbuns() {
        return albuns.size();
    }

    public String exibirAlbuns() {
        String albuns = "";
        for (int i = 0; i < this.albuns.size(); i++) {
            albuns += this.albuns.get(i);
            if (i != this.albuns.size() - 1)
                albuns += "/n";
        }
        return albuns;
    }

    private Album procurarAlbum(String titulo, String artista, int ano) {
        Album procurado = new Album(titulo, artista, ano);
        for (Album album : this.albuns) {
            if (album.equals(procurado))
                return album;
        }
        return null;
    }

    public boolean adicionarMusicaNoAlbum(String titulo, String artista,int ano, int codigo) {
        Album album = procurarAlbum(titulo, artista, ano);
        Musica musica = mapaMusicas.get(codigo);
        if (album == null || musica == null)
            return false;
        album.adicionarMusica(musica);
        return true;
    }

    public int contarMusicasDoAlbum(String titulo, String artista, int ano) {
        Album album = procurarAlbum(titulo, artista, ano);
        if (album == null)
            return 0;
        return album.contarMusicas();
    }

    public String exibirMusicasDoAlbum(String titulo, String artista, int ano) {
        Album album = procurarAlbum(titulo, artista, ano);
        if (album == null)
            return "Album nao encontrado";
        return album.exibirMusicas();
    }

    public int calcularTempoTotalDoAlbum(String titulo, String artista, int ano) {
        Album album = procurarAlbum(titulo, artista, ano);
        if (album == null)
            return 0;
        return album.tempoTotal();
    }

    public boolean criarPlaylist(String nome, String descricao, String criador) {
        if (playlists.containsKey(nome))
            return false;
        playlists.put(nome, new Playlist(nome, descricao, criador));
        return true;
    }

    public int contarPlaylists() {
        return playlists.size();
    }

    public String exibirPlaylist(String nome) {
        Playlist playlist = this.playlists.get(nome);
        if (playlist == null)
            return "Playlist nao encontrada";
        return playlist.toString();
    }

    public boolean adicionarMusicaNaPlaylist(String nome, int codigo) {
        Playlist playlist = this.playlists.get(nome);
        Musica musica = mapaMusicas.get(codigo);
        if (playlist == null || musica == null)
            return false;
        return playlist.adicionarMusica(musica);
    }

    public int contarMusicasDaPlaylist(String nome) {
        Playlist playlist = this.playlists.get(nome);
        if (playlist == null)
            return 0;
        return playlist.contarMusicas();
    }
    
    public String exibirMusicasDaPlaylist(String nomePlaylist) {
    	Playlist playlist = this.playlists.get(nomePlaylist);
    	if(playlist == null) {
    		return "playlist nao encontradas";
    	}
    	return playlist.listarMusicas();
    }

}
