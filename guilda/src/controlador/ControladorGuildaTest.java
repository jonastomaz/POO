package controlador;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import guilda.Personagem;

public class ControladorGuildaTest {

    // =========================================================
    // TESTES DOS CADASTROS COM DADOS INVALIDOS
    // Os construtores lancam Exception e o SistemaGuilda trata,
    // fazendo o cadastro retornar false.
    // =========================================================

    @Test
    public void testCadastrarGuerreiroComCodigoInvalido() {
        ControladorGuilda controlador = new ControladorGuilda();

        boolean resultado = controlador.cadastrarGuerreiro(
                0, "Ragnar", 5, 80, 20,
                "Machado de Ferro", 12);

        assertFalse(resultado);
        assertEquals(0, controlador.contarPersonagens());
    }

    @Test
    public void testCadastrarGuerreiroComNomeVazio() {
        ControladorGuilda controlador = new ControladorGuilda();

        boolean resultado = controlador.cadastrarGuerreiro(
                101, "", 5, 80, 20,
                "Machado de Ferro", 12);

        assertFalse(resultado);
        assertEquals(0, controlador.contarPersonagens());
    }

    @Test
    public void testCadastrarGuerreiroComNivelInvalido() {
        ControladorGuilda controlador = new ControladorGuilda();

        boolean resultado = controlador.cadastrarGuerreiro(
                101, "Ragnar", 0, 80, 20,
                "Machado de Ferro", 12);

        assertFalse(resultado);
        assertEquals(0, controlador.contarPersonagens());
    }

    @Test
    public void testCadastrarGuerreiroComEnergiaNegativa() {
        ControladorGuilda controlador = new ControladorGuilda();

        boolean resultado = controlador.cadastrarGuerreiro(
                101, "Ragnar", 5, -1, 20,
                "Machado de Ferro", 12);

        assertFalse(resultado);
        assertEquals(0, controlador.contarPersonagens());
    }

    @Test
    public void testCadastrarGuerreiroComExperienciaNegativa() {
        ControladorGuilda controlador = new ControladorGuilda();

        boolean resultado = controlador.cadastrarGuerreiro(
                101, "Ragnar", 5, 80, -1,
                "Machado de Ferro", 12);

        assertFalse(resultado);
        assertEquals(0, controlador.contarPersonagens());
    }

    @Test
    public void testCadastrarGuerreiroComArmaVazia() {
        ControladorGuilda controlador = new ControladorGuilda();

        boolean resultado = controlador.cadastrarGuerreiro(
                101, "Ragnar", 5, 80, 20,
                "", 12);

        assertFalse(resultado);
        assertEquals(0, controlador.contarPersonagens());
    }

    @Test
    public void testCadastrarGuerreiroComForcaNegativa() {
        ControladorGuilda controlador = new ControladorGuilda();

        boolean resultado = controlador.cadastrarGuerreiro(
                101, "Ragnar", 5, 80, 20,
                "Machado de Ferro", -1);

        assertFalse(resultado);
        assertEquals(0, controlador.contarPersonagens());
    }

    @Test
    public void testCadastrarMagoComElementoVazio() {
        ControladorGuilda controlador = new ControladorGuilda();

        boolean resultado = controlador.cadastrarMago(
                102, "Merlin", 4, 70, 25,
                "", 11);

        assertFalse(resultado);
        assertEquals(0, controlador.contarPersonagens());
    }

    @Test
    public void testCadastrarMagoComPoderMagicoNegativo() {
        ControladorGuilda controlador = new ControladorGuilda();

        boolean resultado = controlador.cadastrarMago(
                102, "Merlin", 4, 70, 25,
                "Fogo", -1);

        assertFalse(resultado);
        assertEquals(0, controlador.contarPersonagens());
    }

    @Test
    public void testCadastrarArqueiroComArcoVazio() {
        ControladorGuilda controlador = new ControladorGuilda();

        boolean resultado = controlador.cadastrarArqueiro(
                103, "Lyra", 6, 75, 15,
                "", 14);

        assertFalse(resultado);
        assertEquals(0, controlador.contarPersonagens());
    }

    @Test
    public void testCadastrarArqueiroComPrecisaoNegativa() {
        ControladorGuilda controlador = new ControladorGuilda();

        boolean resultado = controlador.cadastrarArqueiro(
                103, "Lyra", 6, 75, 15,
                "Arco Longo", -1);

        assertFalse(resultado);
        assertEquals(0, controlador.contarPersonagens());
    }

    // =========================================================
    // TESTES EM ABERTO 
    // =========================================================

    @Test
    public void testCadastrarGuerreiroValido() {
    	ControladorGuilda controlador = new ControladorGuilda();

    	assertTrue(controlador.cadastrarGuerreiro(101, "jonas", 10,90, 40, "enchada", 70));
        assertEquals(1, controlador.contarPersonagens());
    }

    @Test
    public void testCadastrarMagoValido() {
    	ControladorGuilda controlador = new ControladorGuilda();

        assertTrue(controlador.cadastrarMago(102, "Mister M", 4, 70, 25, "água", 11));
        assertTrue(controlador.cadastrarMago(103, "kratos", 4, 70, 25, "fogo", 11));
        assertEquals(2, controlador.contarPersonagens());
    }

    @Test
    public void testCadastrarArqueiroValido() {
    	ControladorGuilda controlador = new ControladorGuilda();
        assertTrue(controlador.cadastrarArqueiro(103, "Arqueiro verde", 6, 75, 15,"Arco Longo", 14));

        assertEquals(1, controlador.contarPersonagens());
    }

    @Test
    public void testListarPersonagensSemCadastros() {
    	ControladorGuilda controlador = new ControladorGuilda();
        assertEquals("Nenhum personagem cadastrado.", controlador.listarPersonagens());
    }

    @Test
    public void testListarTodosOsPersonagens() {
    	ControladorGuilda controlador = new ControladorGuilda();
        controlador.cadastrarGuerreiro(101, "Aquiles", 5, 80, 20,"espada", 12);
        controlador.cadastrarMago(102, "Fredy", 4, 70, 25,"gelo", 11);
        controlador.cadastrarArqueiro(103, "Lyra", 6, 75, 15,"Arco Longo", 14);

        String lista = controlador.listarPersonagens();

        assertTrue(lista.contains("Aquiles"));
        assertTrue(lista.contains("Fredy"));
        assertTrue(lista.contains("Lyra"));
    }

    @Test
    public void testConsultarPersonagemExistente() {
    	ControladorGuilda controlador = new ControladorGuilda();
        controlador.cadastrarGuerreiro(101, "Ragnar", 5, 80, 20,"Machado", 12);

        String personagem = controlador.consultarPersonagem(101);

        assertTrue(personagem.contains("Ragnar"));
        assertTrue(personagem.contains("101"));
    }

    @Test
    public void testConsultarPersonagemInexistente() {
    	ControladorGuilda controlador = new ControladorGuilda();
        assertEquals("persnagem nao encontrado.",controlador.consultarPersonagem(1001));
    }

    @Test
    public void testUsarHabilidadeDoGuerreiro() {
    	ControladorGuilda controlador = new ControladorGuilda();
        controlador.cadastrarGuerreiro(101, "Ragnar", 5, 80, 20,"Machado", 12);

        String mensagem = controlador.usarHabilidade(101);

        assertTrue(mensagem.contains("Ragnar"));

        String consulta = controlador.consultarPersonagem(101);

        assertTrue(consulta.contains("Energia: 70"));
    }

    @Test
    public void testUsarHabilidadeSemEnergiaSuficiente() {
    	ControladorGuilda controlador = new ControladorGuilda();
        controlador.cadastrarGuerreiro(101, "Ragnar", 5, 5, 20,"Machado", 12);

        assertEquals("Ragnar nao possui energia suficiente para utilizar sua habilidade.",
                controlador.usarHabilidade(101));

        String consulta = controlador.consultarPersonagem(101);

        assertTrue(consulta.contains("Energia: 5"));
    }

    @Test
    public void testRegistrarConclusaoDeMissao() {
    	ControladorGuilda controlador = new ControladorGuilda();
        controlador.cadastrarGuerreiro(101, "Ragnar", 5, 80, 20,"Machado", 12);

        String mensagem = controlador.registrarConclusaoMissao(101, 1);

        assertTrue(mensagem.contains("Ragnar"));
    }

    @Test
    public void testCalcularPoderTotalDaGuilda() {
    	ControladorGuilda controlador = new ControladorGuilda();
        controlador.cadastrarGuerreiro(101, "Ragnar", 5, 80, 20,"Machado", 12);
        controlador.cadastrarMago(102, "Merlin", 4, 70, 25,"Fogo", 11);
        controlador.cadastrarArqueiro(103, "Lyra", 6, 75, 15,"Arco Longo", 14);

        int poder = controlador.poderTotalGuida();

        assertTrue(poder == 426);
    }

    @Test
    public void testLocalizarPersonagemMaisPoderoso() {
    	ControladorGuilda controlador = new ControladorGuilda();
        controlador.cadastrarGuerreiro(101, "Ragnar", 5, 80, 20,"Machado", 12);

        controlador.cadastrarMago(102, "Merlin", 4, 70, 25,"Fogo", 20);

        Personagem personagem = controlador.localizarMaisPoderoso();

        assertEquals("Merlin", personagem.getNome());
    }

    @Test
    public void testExibirResumoDaGuilda() {
    	ControladorGuilda controlador = new ControladorGuilda();
    	
        controlador.cadastrarGuerreiro(101, "Ragnar", 5, 80, 20,"Machado", 12);

        controlador.cadastrarMago(102, "Merlin", 4, 70, 25, "Fogo", 20);

        String resumo = controlador.exibirResumoGuilda();

        assertTrue(resumo.contains("Quantidade de personagens: 2"));
        assertTrue(resumo.contains("Poder total da guilda:"));
        assertTrue(resumo.contains("Merlin"));
    }
}