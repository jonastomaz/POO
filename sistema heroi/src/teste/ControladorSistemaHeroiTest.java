package teste;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import controlador.ControladorSistemaHeroi;
import heroi.Heroi;

public class ControladorSistemaHeroiTest {

	/*
	 * O JUnit 4 cria uma nova instância desta classe para cada método anotado
	 * com @Test. 
	 */
	private ControladorSistemaHeroi controlador = new ControladorSistemaHeroi();

	// ============================================================
	// TESTES DE ESTADO INICIAL, CADASTRO E BUSCA
	// ============================================================

	@Test
	public void deveIniciarSemHeroisCadastrados() {
		assertEquals(0, controlador.contarHerois());
		assertEquals("Nenhum heroi cadastrado.", controlador.exibirTodosHerois());
		assertEquals(0, controlador.calcularForcaTotalEquipe());
		assertNull(controlador.encontrarHeroiMaisForte());
	}

	@Test
	public void deveCadastrarUmHeroiDeCadaCategoria() {
		assertTrue(controlador.cadastrarHeroiFisico(101, "Diana Oliveira", "Impacto", 80, 20, 15));

		assertTrue(controlador.cadastrarHeroiTecnologico(102, "Caio Martins", "Sentinela Neon", 70, 25,
				"Armadura Atlas", 12));

		assertTrue(controlador.cadastrarHeroiMistico(103, "Leonardo Alves", "Guardiao Arcano", 60, 15,
				"Cristal de Lumina", 10));

		assertEquals(3, controlador.contarHerois());
	}

	@Test
	public void naoDeveCadastrarDoisHeroisComMesmoCodigo() {
		assertTrue(controlador.cadastrarHeroiFisico(101, "Diana Oliveira", "Impacto", 80, 20, 15));

		assertFalse(controlador.cadastrarHeroiMistico(101, "Leonardo Alves", "Guardiao Arcano", 60, 15,
				"Cristal de Lumina", 10));

		assertEquals(1, controlador.contarHerois());
	}

	@Test
	public void naoDeveCadastrarHeroiComValorNumericoNegativo() {
		assertFalse(controlador.cadastrarHeroiFisico(-1, "Diana Oliveira", "Impacto", 80, 20, 15));

		assertFalse(controlador.cadastrarHeroiFisico(101, "Diana Oliveira", "Impacto", -1, 20, 15));

		assertFalse(controlador.cadastrarHeroiTecnologico(102, "Caio Martins", "Sentinela Neon", 70, -1,
				"Armadura Atlas", 12));

		assertFalse(controlador.cadastrarHeroiMistico(103, "Leonardo Alves", "Guardiao Arcano", 60, 15,
				"Cristal de Lumina", -1));

		assertEquals(0, controlador.contarHerois());
	}

	@Test
	public void deveBuscarHeroiPeloCodigo() {
		controlador.cadastrarHeroiFisico(101, "Diana Oliveira", "Impacto", 80, 20, 15);

		Heroi heroi = controlador.buscarHeroi(101);

		assertNotNull(heroi);
		assertEquals(101, heroi.getCodigo());
		assertEquals("Diana Oliveira", heroi.getNomeVerdadeiro());
		assertEquals("Impacto", heroi.getCodinome());
		assertEquals(80, heroi.getEnergia());
		assertEquals(20, heroi.getExperiencia());
	}

	@Test
	public void deveRetornarNullAoBuscarCodigoInexistente() {
		assertNull(controlador.buscarHeroi(999));
	}

	// ============================================================
	// TESTES DAS STRINGS RETORNADAS PELO SISTEMA
	// ============================================================

	@Test
	public void deveRetornarInformacoesCompletasDoHeroiFisico() {
		controlador.cadastrarHeroiFisico(101, "Diana Oliveira", "Impacto", 80, 20, 15);

		String esperado = "Codigo: 101" + "\nNome verdadeiro: Diana Oliveira" + "\nCodinome: Impacto" + "\nEnergia: 80"
				+ "\nExperiencia: 20" + "\nNivel de forca: 15";

		assertEquals(esperado, controlador.exibirInformacoesHeroi(101));
	}

	@Test
	public void deveRetornarInformacoesCompletasDoHeroiTecnologico() {
		controlador.cadastrarHeroiTecnologico(102, "Caio Martins", "Sentinela Neon", 70, 25, "Armadura Atlas", 12);

		String esperado = "Codigo: 102" + "\nNome verdadeiro: Caio Martins" + "\nCodinome: Sentinela Neon"
				+ "\nEnergia: 70" + "\nExperiencia: 25" + "\nEquipamento principal: Armadura Atlas"
				+ "\nNivel tecnologico: 12";

		assertEquals(esperado, controlador.exibirInformacoesHeroi(102));
	}

	@Test
	public void deveRetornarInformacoesCompletasDoHeroiMistico() {
		controlador.cadastrarHeroiMistico(103, "Leonardo Alves", "Guardiao Arcano", 60, 15, "Cristal de Lumina", 10);

		String esperado = "Codigo: 103" + "\nNome verdadeiro: Leonardo Alves" + "\nCodinome: Guardiao Arcano"
				+ "\nEnergia: 60" + "\nExperiencia: 15" + "\nOrigem do poder: Cristal de Lumina"
				+ "\nNivel de magia: 10";

		assertEquals(esperado, controlador.exibirInformacoesHeroi(103));
	}

	@Test
	public void deveInformarQuandoHeroiNaoForEncontrado() {
		assertEquals("Heroi nao encontrado.", controlador.exibirInformacoesHeroi(999));
		assertEquals("Heroi nao encontrado.", controlador.executarHabilidade(999));
		assertEquals("Heroi nao encontrado.", controlador.registrarConclusaoMissao(999));
	}

	@Test
	public void deveRetornarTodosOsHeroisSeparadosPorLinhaEmBranco() {
		controlador.cadastrarHeroiFisico(101, "Diana Oliveira", "Impacto", 80, 20, 15);
		controlador.cadastrarHeroiTecnologico(102, "Caio Martins", "Sentinela Neon", 70, 25, "Armadura Atlas", 12);

		String esperado = "Codigo: 101" + "\nNome verdadeiro: Diana Oliveira" + "\nCodinome: Impacto" + "\nEnergia: 80"
				+ "\nExperiencia: 20" + "\nNivel de forca: 15" + "\n\nCodigo: 102" + "\nNome verdadeiro: Caio Martins"
				+ "\nCodinome: Sentinela Neon" + "\nEnergia: 70" + "\nExperiencia: 25"
				+ "\nEquipamento principal: Armadura Atlas" + "\nNivel tecnologico: 12";

		assertEquals(esperado, controlador.exibirTodosHerois());
	}

	// ============================================================
	// TESTES DO COMPORTAMENTO POLIMÓRFICO
	// ============================================================

	@Test
	public void deveCalcularAForcaDeCadaCategoria() {
		controlador.cadastrarHeroiFisico(101, "Diana Oliveira", "Impacto", 80, 20, 15);
		controlador.cadastrarHeroiTecnologico(102, "Caio Martins", "Sentinela Neon", 70, 25, "Armadura Atlas", 12);
		controlador.cadastrarHeroiMistico(103, "Leonardo Alves", "Guardiao Arcano", 60, 15, "Cristal de Lumina", 10);

		assertEquals(130, controlador.calcularForcaTotal(101));
		assertEquals(131, controlador.calcularForcaTotal(102));
		assertEquals(115, controlador.calcularForcaTotal(103));
	}

	@Test
	public void deveRetornarZeroAoCalcularForcaDeHeroiInexistente() {
		assertEquals(0, controlador.calcularForcaTotal(999));
	}

	@Test
	public void deveCalcularAForcaTotalDaEquipe() {
		controlador.cadastrarHeroiFisico(101, "Diana Oliveira", "Impacto", 80, 20, 15);
		controlador.cadastrarHeroiTecnologico(102, "Caio Martins", "Sentinela Neon", 70, 25, "Armadura Atlas", 12);
		controlador.cadastrarHeroiMistico(103, "Leonardo Alves", "Guardiao Arcano", 60, 15, "Cristal de Lumina", 10);

		assertEquals(376, controlador.calcularForcaTotalEquipe());
	}

	@Test
	public void deveEncontrarOHeroiMaisForte() {
		controlador.cadastrarHeroiFisico(101, "Diana Oliveira", "Impacto", 80, 20, 15);
		controlador.cadastrarHeroiTecnologico(102, "Caio Martins", "Sentinela Neon", 70, 25, "Armadura Atlas", 12);
		controlador.cadastrarHeroiMistico(103, "Leonardo Alves", "Guardiao Arcano", 60, 15, "Cristal de Lumina", 10);

		Heroi maisForte = controlador.encontrarHeroiMaisForte();

		assertNotNull(maisForte);
		assertEquals(102, maisForte.getCodigo());
		assertEquals("Sentinela Neon", maisForte.getCodinome());
		assertEquals(131, maisForte.calcularForcaTotal());
	}

	@Test
	public void deveExecutarAHabilidadeEspecificaDeCadaHeroi() {
		controlador.cadastrarHeroiFisico(101, "Diana Oliveira", "Impacto", 80, 20, 15);
		controlador.cadastrarHeroiTecnologico(102, "Caio Martins", "Sentinela Neon", 70, 25, "Armadura Atlas", 12);
		controlador.cadastrarHeroiMistico(103, "Leonardo Alves", "Guardiao Arcano", 60, 15, "Cristal de Lumina", 10);

		assertEquals("Impacto golpeia o inimigo utilizando sua forca extraordinaria.",
				controlador.executarHabilidade(101));

		assertEquals("Sentinela Neon ativa a Armadura Atlas e dispara seus dispositivos tecnologicos.",
				controlador.executarHabilidade(102));

		assertEquals("Guardiao Arcano invoca os poderes do Cristal de Lumina e cria um poderoso feitico.",
				controlador.executarHabilidade(103));
	}

	// ============================================================
	// TESTES DE ALTERAÇÃO DE ENERGIA E EXPERIÊNCIA
	// ============================================================

	@Test
	public void deveDiminuirDezPontosDeEnergiaAoUtilizarHabilidade() {
		controlador.cadastrarHeroiFisico(101, "Diana Oliveira", "Impacto", 80, 20, 15);

		controlador.executarHabilidade(101);

		assertEquals(70, controlador.buscarHeroi(101).getEnergia());
	}

	@Test
	public void naoDeveUtilizarHabilidadeComEnergiaInsuficiente() {
		controlador.cadastrarHeroiFisico(101, "Diana Oliveira", "Impacto", 5, 20, 15);

		String retorno = controlador.executarHabilidade(101);

		assertEquals("Impacto nao possui energia suficiente para utilizar sua habilidade.", retorno);
		assertEquals(5, controlador.buscarHeroi(101).getEnergia());
	}

	@Test
	public void energiaNuncaDeveFicarNegativa() {
		controlador.cadastrarHeroiTecnologico(102, "Caio Martins", "Sentinela Neon", 10, 25, "Armadura Atlas", 12);

		controlador.executarHabilidade(102);
		String segundaTentativa = controlador.executarHabilidade(102);

		assertEquals(0, controlador.buscarHeroi(102).getEnergia());
		assertEquals("Sentinela Neon nao possui energia suficiente para utilizar sua habilidade.", segundaTentativa);
	}

	@Test
	public void deveExecutarAsHabilidadesDeTodosEmUmaUnicaOperacao() {
		controlador.cadastrarHeroiFisico(101, "Diana Oliveira", "Impacto", 80, 20, 15);
		controlador.cadastrarHeroiTecnologico(102, "Caio Martins", "Sentinela Neon", 70, 25, "Armadura Atlas", 12);
		controlador.cadastrarHeroiMistico(103, "Leonardo Alves", "Guardiao Arcano", 60, 15, "Cristal de Lumina", 10);

		String esperado = "Impacto golpeia o inimigo utilizando sua forca extraordinaria."
				+ "\nSentinela Neon ativa a Armadura Atlas e dispara seus dispositivos tecnologicos."
				+ "\nGuardiao Arcano invoca os poderes do Cristal de Lumina e cria um poderoso feitico.";

		assertEquals(esperado, controlador.executarHabilidadesDeTodos());
		assertEquals(70, controlador.buscarHeroi(101).getEnergia());
		assertEquals(60, controlador.buscarHeroi(102).getEnergia());
		assertEquals(50, controlador.buscarHeroi(103).getEnergia());
	}

	@Test
	public void deveInformarQuandoNaoHouverHeroisParaUtilizarHabilidades() {
		assertEquals("Nenhum heroi cadastrado.", controlador.executarHabilidadesDeTodos());
	}

	@Test
	public void deveRegistrarAConclusaoDeUmaMissao() {
		controlador.cadastrarHeroiMistico(103, "Leonardo Alves", "Guardiao Arcano", 60, 15, "Cristal de Lumina", 10);

		String retorno = controlador.registrarConclusaoMissao(103);

		assertEquals("Guardiao Arcano concluiu a missao. Experiencia recebida: 5 pontos.", retorno);
		assertEquals(20, controlador.buscarHeroi(103).getExperiencia());
	}

	// ============================================================
	// TESTES EM ABERTO
	//
	// Os métodos abaixo possuem apenas a assinatura e uma orientação.
	// ============================================================

	@Test
	public void deveExibirTresHeroisNaOrdemEmQueForamCadastrados() {
		controlador.cadastrarHeroiFisico(101, "Diana Oliveira", "Impacto", 80, 20, 15);
	    controlador.cadastrarHeroiTecnologico(102, "Caio Martins", "Sentinela Neon", 70, 25, "Armadura Atlas", 12);
	    controlador.cadastrarHeroiMistico(103, "Leonardo Alves", "Guardiao Arcano", 60, 15, "Cristal de Lumina", 10);

	    String esperado =
	            "Codigo: 101\n" +
	            "Nome verdadeiro: Diana Oliveira\n" +
	            "Codinome: Impacto\n" +
	            "Energia: 80\n" +
	            "Experiencia: 20\n" +
	            "Nivel de forca: 15\n\n" +

	            "Codigo: 102\n" +
	            "Nome verdadeiro: Caio Martins\n" +
	            "Codinome: Sentinela Neon\n" +
	            "Energia: 70\n" +
	            "Experiencia: 25\n" +
	            "Equipamento principal: Armadura Atlas\n" +
	            "Nivel tecnologico: 12\n\n" +

	            "Codigo: 103\n" +
	            "Nome verdadeiro: Leonardo Alves\n" +
	            "Codinome: Guardiao Arcano\n" +
	            "Energia: 60\n" +
	            "Experiencia: 15\n" +
	            "Origem do poder: Cristal de Lumina\n" +
	            "Nivel de magia: 10";

	    assertEquals(esperado, controlador.exibirTodosHerois());
	}

	@Test
	public void deveIdentificarOHeroiMaisForteQuandoAsForcasForemDiferentes() {
		controlador.cadastrarHeroiFisico(101, "Diana Oliveira", "Impacto", 80, 20, 15);
	    controlador.cadastrarHeroiTecnologico(102, "Caio Martins", "Sentinela Neon", 70, 25, "Armadura Atlas", 12);
	    controlador.cadastrarHeroiMistico(103, "Leonardo Alves", "Guardiao Arcano", 60, 15, "Cristal de Lumina", 10);

	    Heroi esperado = controlador.buscarHeroi(102);

	    assertEquals(esperado, controlador.encontrarHeroiMaisForte());
	}

	@Test
	public void deveExecutarPolimorficamenteAsHabilidadesDosTresTiposDeHeroi() {
		controlador.cadastrarHeroiFisico(101, "Diana Oliveira", "Impacto", 80, 20, 15);
	    controlador.cadastrarHeroiTecnologico(102, "Caio Martins", "Sentinela Neon", 70, 25, "Armadura Atlas", 12);
	    controlador.cadastrarHeroiMistico(103, "Leonardo Alves", "Guardiao Arcano", 60, 15, "Cristal de Lumina", 10);

	    assertEquals(
	            "Impacto golpeia o inimigo utilizando sua forca extraordinaria.",
	            controlador.executarHabilidade(101));

	    assertEquals(
	            "Sentinela Neon ativa a Armadura Atlas e dispara seus dispositivos tecnologicos.",
	            controlador.executarHabilidade(102));

	    assertEquals(
	            "Guardiao Arcano invoca os poderes do Cristal de Lumina e cria um poderoso feitico.",
	            controlador.executarHabilidade(103));
	}

	@Test
	public void deveManterAEnergiaDoHeroiQuandoAHabilidadeNaoPuderSerExecutada() {
		controlador.cadastrarHeroiFisico(101, "Diana Oliveira", "Impacto", 0, 20, 15);

	    Heroi heroi = controlador.buscarHeroi(101);

	    controlador.executarHabilidade(101);

	    assertEquals(0, heroi.getEnergia());
	}
}