package teste;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import controlador.Controlador;

public class ControladorTest {

	Controlador controlador;

	@Before
	public void setUp() {
		controlador = new Controlador();
	}

	@Test
	public void deveCadastrarMusica() {
		boolean cadastrou = controlador.cadastrarMusica("Cheap Thrills", "Sia", 211, "Pop", 101);

		assertTrue(cadastrou);
		assertEquals(1, controlador.contarMusicas());
	}

	@Test
	public void naoDeveCadastrarMusicaComCodigoRepetido() {
		controlador.cadastrarMusica("Cheap Thrills", "Sia", 211, "Pop", 101);

		boolean cadastrou = controlador.cadastrarMusica("Tears", "Sabrina Carpenter", 180, "Pop", 101);

		assertFalse(cadastrou);
		assertEquals(1, controlador.contarMusicas());
	}

	@Test
	public void deveExibirMusicasNaOrdemDeCadastro() {
		controlador.cadastrarMusica("Cheap Thrills", "Sia", 211, "Pop", 101);
		controlador.cadastrarMusica("Golden Burning Sun", "Miley Cyrus", 196, "Pop Rock", 102);
		controlador.cadastrarMusica("Mr. Know It All", "Teddy Swims", 188, "Soul Pop", 103);
		controlador.cadastrarMusica("Watermelon Sugar", "Harry Styles", 174, "Pop", 104);
		controlador.cadastrarMusica("No Tears Left To Cry", "Ariana Grande", 205, "Pop", 105);
		controlador.cadastrarMusica("Tears", "Sabrina Carpenter", 180, "Pop", 106);
		controlador.cadastrarMusica("Natural", "Imagine Dragons", 189, "Rock", 107);
		controlador.cadastrarMusica("Nobody Gets Me", "SZA", 180, "R&B", 108);

		String resultado = controlador.exibirMusicas();

		String esperado = "101 - Cheap Thrills - Sia - 211s - Pop\n"
				+ "102 - Golden Burning Sun - Miley Cyrus - 196s - Pop Rock\n"
				+ "103 - Mr. Know It All - Teddy Swims - 188s - Soul Pop\n"
				+ "104 - Watermelon Sugar - Harry Styles - 174s - Pop\n"
				+ "105 - No Tears Left To Cry - Ariana Grande - 205s - Pop\n"
				+ "106 - Tears - Sabrina Carpenter - 180s - Pop\n" + "107 - Natural - Imagine Dragons - 189s - Rock\n"
				+ "108 - Nobody Gets Me - SZA - 180s - R&B";

		assertEquals(esperado, resultado);
	}

	@Test
	public void deveCadastrarAlbum() {
		boolean cadastrou = controlador.cadastrarAlbum("F-1 Trillion", "Post Malone", 2024);

		assertTrue(cadastrou);
		assertEquals(1, controlador.contarAlbuns());
	}

	@Test
	public void deveCadastrarDoisAlbuns() {
		boolean cadastrouPrimeiro = controlador.cadastrarAlbum("F-1 Trillion", "Post Malone", 2024);

		boolean cadastrouSegundo = controlador.cadastrarAlbum("Something Beautiful", "Miley Cyrus", 2025);

		assertTrue(cadastrouPrimeiro);
		assertTrue(cadastrouSegundo);
		assertEquals(2, controlador.contarAlbuns());
	}

	@Test
	public void naoDeveCadastrarAlbumRepetido() {
		controlador.cadastrarAlbum("F-1 Trillion", "Post Malone", 2024);

		boolean cadastrou = controlador.cadastrarAlbum("F-1 Trillion", "Post Malone", 2024);

		assertFalse(cadastrou);
		assertEquals(1, controlador.contarAlbuns());
	}

	@Test
	public void deveExibirAlbum() {
		controlador.cadastrarAlbum("F-1 Trillion", "Post Malone", 2024);

		String resultado = controlador.exibirAlbuns();

		assertEquals("F-1 Trillion - Post Malone - 2024", resultado);
	}

	@Test
	public void deveAdicionarMusicaNoAlbum() {
		controlador.cadastrarMusica("Cheap Thrills", "Sia", 211, "Pop", 101);

		controlador.cadastrarAlbum("F-1 Trillion", "Post Malone", 2024);

		boolean adicionou = controlador.adicionarMusicaNoAlbum("F-1 Trillion", "Post Malone", 2024, 101);

		assertTrue(adicionou);
		assertEquals(1, controlador.contarMusicasDoAlbum("F-1 Trillion", "Post Malone", 2024));
	}

	@Test
	public void naoDeveAdicionarMusicaInexistenteNoAlbum() {
		controlador.cadastrarAlbum("F-1 Trillion", "Post Malone", 2024);

		boolean adicionou = controlador.adicionarMusicaNoAlbum("F-1 Trillion", "Post Malone", 2024, 999);

		assertFalse(adicionou);
		assertEquals(0, controlador.contarMusicasDoAlbum("F-1 Trillion", "Post Malone", 2024));
	}

	@Test
	public void naoDeveAdicionarMusicaEmAlbumInexistente() {
		controlador.cadastrarMusica("Cheap Thrills", "Sia", 211, "Pop", 101);

		boolean adicionou = controlador.adicionarMusicaNoAlbum("Album Inexistente", "Post Malone", 2024, 101);

		assertFalse(adicionou);
	}

	@Test
	public void deveExibirMusicasDoAlbumNaOrdem() {
		controlador.cadastrarMusica("Cheap Thrills", "Sia", 211, "Pop", 101);
		controlador.cadastrarMusica("Watermelon Sugar", "Harry Styles", 174, "Pop", 104);
		controlador.cadastrarMusica("Natural", "Imagine Dragons", 189, "Rock", 107);

		controlador.cadastrarAlbum("F-1 Trillion", "Post Malone", 2024);

		controlador.adicionarMusicaNoAlbum("F-1 Trillion", "Post Malone", 2024, 101);
		controlador.adicionarMusicaNoAlbum("F-1 Trillion", "Post Malone", 2024, 104);
		controlador.adicionarMusicaNoAlbum("F-1 Trillion", "Post Malone", 2024, 107);

		String resultado = controlador.exibirMusicasDoAlbum("F-1 Trillion", "Post Malone", 2024);

		String esperado = "1. 101 - Cheap Thrills - Sia - 211s - Pop\n"
				+ "2. 104 - Watermelon Sugar - Harry Styles - 174s - Pop\n"
				+ "3. 107 - Natural - Imagine Dragons - 189s - Rock";

		assertEquals(esperado, resultado);
	}

	@Test
	public void deveExibirMusicasDoAlbumSomethingBeautifulNaOrdem() {
		controlador.cadastrarMusica("Golden Burning Sun", "Miley Cyrus", 196, "Pop Rock", 102);
		controlador.cadastrarMusica("Tears", "Sabrina Carpenter", 180, "Pop", 106);
		controlador.cadastrarMusica("Nobody Gets Me", "SZA", 180, "R&B", 108);

		controlador.cadastrarAlbum("Something Beautiful", "Miley Cyrus", 2025);

		controlador.adicionarMusicaNoAlbum("Something Beautiful", "Miley Cyrus", 2025, 102);
		controlador.adicionarMusicaNoAlbum("Something Beautiful", "Miley Cyrus", 2025, 106);
		controlador.adicionarMusicaNoAlbum("Something Beautiful", "Miley Cyrus", 2025, 108);

		String resultado = controlador.exibirMusicasDoAlbum("Something Beautiful", "Miley Cyrus", 2025);

		String esperado = "1. 102 - Golden Burning Sun - Miley Cyrus - 196s - Pop Rock\n"
				+ "2. 106 - Tears - Sabrina Carpenter - 180s - Pop\n" + "3. 108 - Nobody Gets Me - SZA - 180s - R&B";

		assertEquals(esperado, resultado);
	}

	@Test
	public void deveCalcularTempoTotalDoAlbum() {
		controlador.cadastrarMusica("Cheap Thrills", "Sia", 211, "Pop", 101);
		controlador.cadastrarMusica("Watermelon Sugar", "Harry Styles", 174, "Pop", 104);
		controlador.cadastrarMusica("Natural", "Imagine Dragons", 189, "Rock", 107);

		controlador.cadastrarAlbum("F-1 Trillion", "Post Malone", 2024);

		controlador.adicionarMusicaNoAlbum("F-1 Trillion", "Post Malone", 2024, 101);
		controlador.adicionarMusicaNoAlbum("F-1 Trillion", "Post Malone", 2024, 104);
		controlador.adicionarMusicaNoAlbum("F-1 Trillion", "Post Malone", 2024, 107);

		int tempoTotal = controlador.calcularTempoTotalDoAlbum("F-1 Trillion", "Post Malone", 2024);

		assertEquals(574, tempoTotal);
	}

	@Test
	public void deveCalcularTempoTotalDoAlbumSomethingBeautiful() {
		controlador.cadastrarMusica("Golden Burning Sun", "Miley Cyrus", 196, "Pop Rock", 102);
		controlador.cadastrarMusica("Tears", "Sabrina Carpenter", 180, "Pop", 106);
		controlador.cadastrarMusica("Nobody Gets Me", "SZA", 180, "R&B", 108);

		controlador.cadastrarAlbum("Something Beautiful", "Miley Cyrus", 2025);

		controlador.adicionarMusicaNoAlbum("Something Beautiful", "Miley Cyrus", 2025, 102);
		controlador.adicionarMusicaNoAlbum("Something Beautiful", "Miley Cyrus", 2025, 106);
		controlador.adicionarMusicaNoAlbum("Something Beautiful", "Miley Cyrus", 2025, 108);

		int tempoTotal = controlador.calcularTempoTotalDoAlbum("Something Beautiful", "Miley Cyrus", 2025);

		assertEquals(556, tempoTotal);
	}

	@Test
	public void deveCriarPlaylist() {
		boolean criou = controlador.criarPlaylist("Pra chorar depois da prova", "Playlist da turma de LP2",
				"Turma LP2");

		assertTrue(criou);
		assertEquals(1, controlador.contarPlaylists());
	}

	@Test
	public void naoDeveCriarPlaylistComNomeRepetido() {
		controlador.criarPlaylist("Pra chorar depois da prova", "Playlist da turma de LP2", "Turma LP2");

		boolean criou = controlador.criarPlaylist("Pra chorar depois da prova", "Outra descricao", "Outro Criador");

		assertFalse(criou);
		assertEquals(1, controlador.contarPlaylists());
	}

	@Test
	public void deveExibirPlaylistPeloNome() {
		controlador.criarPlaylist("Pra estudar fingindo calma", "Playlist para revisar o conteudo antes da prova",
				"Hiago");

		String resultado = controlador.exibirPlaylist("Pra estudar fingindo calma");

		String esperado = "Pra estudar fingindo calma - " + "Playlist para revisar o conteudo antes da prova - "
				+ "Hiago";

		assertEquals(esperado, resultado);
	}

	@Test
	public void deveAdicionarMusicaNaPlaylist() {
		controlador.cadastrarMusica("Nobody Gets Me", "SZA", 180, "R&B", 108);

		controlador.criarPlaylist("Pra chorar depois da prova", "Playlist da turma de LP2", "Turma LP2");

		boolean adicionou = controlador.adicionarMusicaNaPlaylist("Pra chorar depois da prova", 108);

		assertTrue(adicionou);
		assertEquals(1, controlador.contarMusicasDaPlaylist("Pra chorar depois da prova"));
	}

	@Test
	public void naoDeveAdicionarMusicaRepetidaNaPlaylist() {
		controlador.cadastrarMusica("Nobody Gets Me", "SZA", 180, "R&B", 108);

		controlador.criarPlaylist("Pra chorar depois da prova", "Playlist da turma de LP2", "Turma LP2");

		controlador.adicionarMusicaNaPlaylist("Pra chorar depois da prova", 108);

		boolean adicionou = controlador.adicionarMusicaNaPlaylist("Pra chorar depois da prova", 108);

		assertFalse(adicionou);
		assertEquals(1, controlador.contarMusicasDaPlaylist("Pra chorar depois da prova"));
	}

	@Test
	public void naoDeveAdicionarMusicaInexistenteNaPlaylist() {
		controlador.criarPlaylist("Pra chorar depois do lab",
				"Playlist para ouvir depois de tentar corrigir todos os testes", "Turma LP2");

		boolean adicionou = controlador.adicionarMusicaNaPlaylist("Pra chorar depois do lab", 999);

		assertFalse(adicionou);
		assertEquals(0, controlador.contarMusicasDaPlaylist("Pra chorar depois do lab"));
	}

	@Test
	public void deveExibirMusicasDaPlaylist() {
		controlador.cadastrarMusica("Nobody Gets Me", "SZA", 180, "R&B", 108);

		controlador.criarPlaylist("Pra chorar depois da prova", "Playlist da turma de LP2", "Turma LP2");

		controlador.adicionarMusicaNaPlaylist("Pra chorar depois da prova", 108);

		String resultado = controlador.exibirMusicasDaPlaylist("Pra chorar depois da prova");

		assertEquals("108 - Nobody Gets Me - SZA - 180s - R&B", resultado);
	}

	@Test
	public void deveExibirPlaylistComNomeCriativo() {
		controlador.criarPlaylist("Quando o codigo nao compila e a vida tambem nao",
				"Playlist para momentos de erro no programa", "UEPBfy");

		String resultado = controlador.exibirPlaylist("Quando o codigo nao compila e a vida tambem nao");

		String esperado = "Quando o codigo nao compila e a vida tambem nao - "
				+ "Playlist para momentos de erro no programa - " + "UEPBfy";

		assertEquals(esperado, resultado);
	}
}
