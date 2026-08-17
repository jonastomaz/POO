package controlador;
import principal.SPOOfy;

public class Controlador {

    private SPOOfy sistema;

    public Controlador() {
        this.sistema = new SPOOfy();
    }

    public boolean cadastrarMusica(String titulo, String artista, int duracaoEmSegundos, String genero, int codigo) {
        return sistema.cadastrarMusica(titulo, artista, duracaoEmSegundos, genero, codigo);
    }

    public int contarMusicas() {
        return sistema.contarMusicas();
    }

    public String exibirMusicas() {
        return sistema.exibirMusicas();
    }

    public boolean cadastrarAlbum(String titulo, String artistaPrincipal, int anoLancamento) {
        return sistema.cadastrarAlbum(titulo, artistaPrincipal, anoLancamento);
    }

    public int contarAlbuns() {
        return sistema.contarAlbuns();
    }

    public String exibirAlbuns() {
        return sistema.exibirAlbuns();
    }

    public boolean adicionarMusicaNoAlbum(String tituloAlbum, String artistaPrincipal, int anoLancamento, int codigoMusica) {
        return sistema.adicionarMusicaNoAlbum(tituloAlbum, artistaPrincipal, anoLancamento, codigoMusica);
    }

    public int contarMusicasDoAlbum(String tituloAlbum, String artistaPrincipal, int anoLancamento) {
        return sistema.contarMusicasDoAlbum(tituloAlbum, artistaPrincipal, anoLancamento);
    }

    public String exibirMusicasDoAlbum(String tituloAlbum, String artistaPrincipal, int anoLancamento) {
        return sistema.exibirMusicasDoAlbum(tituloAlbum, artistaPrincipal, anoLancamento);
    }

    public int calcularTempoTotalDoAlbum(String tituloAlbum, String artistaPrincipal, int anoLancamento) {
        return sistema.calcularTempoTotalDoAlbum(tituloAlbum, artistaPrincipal, anoLancamento);
    }

    public boolean criarPlaylist(String nome, String descricao, String criador) {
        return sistema.criarPlaylist(nome, descricao, criador);
    }

    public int contarPlaylists() {
        return sistema.contarPlaylists();
    }

    public String exibirPlaylist(String nome) {
        return sistema.exibirPlaylist(nome);
    }

    public boolean adicionarMusicaNaPlaylist(String nomePlaylist, int codigoMusica) {
        return sistema.adicionarMusicaNaPlaylist(nomePlaylist, codigoMusica);
    }

    public int contarMusicasDaPlaylist(String nomePlaylist) {
        return sistema.contarMusicasDaPlaylist(nomePlaylist);
    }

    public String exibirMusicasDaPlaylist(String nomePlaylist) {
        return sistema.exibirMusicasDaPlaylist(nomePlaylist);
    }
}
