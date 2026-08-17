package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import supermercado.Cliente;
import supermercado.SistemaSupermercado;

public class TestSupermercado {
	// =========================================================
    // TESTES DE CADASTRO COM DADOS INVÁLIDOS
    // =========================================================

    @Test
    public void testCadastrarClienteComCodigoVazio() throws Exception {
        SistemaSupermercado controlador = new SistemaSupermercado();

        boolean resultado = controlador.cadastrarCliente(
                "",
                "Maria da Silva",
                111111111,
                "maria@email.com",
                "Ouro"
        );

        assertFalse(resultado);
        assertEquals(0, controlador.contarClientes());
    }

    @Test
    public void testCadastrarClienteComNomeVazio() throws Exception {
    	SistemaSupermercado controlador = new SistemaSupermercado();

        boolean resultado = controlador.cadastrarCliente(
                "C001",
                "",
                111111111,
                "maria@email.com",
                "Ouro"
        );

        assertFalse(resultado);
        assertEquals(0, controlador.contarClientes());
    }

    @Test
    public void testCadastrarClienteComDocumentoVazio() throws Exception {
    	SistemaSupermercado controlador = new SistemaSupermercado();

        boolean resultado = controlador.cadastrarCliente(
                "C001",
                "Maria da Silva",
                0, "maria@email.com",
                "Ouro"
        );

        assertFalse(resultado);
        assertEquals(0, controlador.contarClientes());
    }

    @Test
    public void testCadastrarClienteComEmailVazio() throws Exception {
    	SistemaSupermercado controlador = new SistemaSupermercado();

        boolean resultado = controlador.cadastrarCliente(
                "C001",
                "Maria da Silva",
                111111111,
                "",
                "Ouro"
        );

        assertFalse(resultado);
        assertEquals(0, controlador.contarClientes());
    }

    @Test
    public void testCadastrarClienteComCategoriaInvalida() throws Exception {
    	SistemaSupermercado controlador = new SistemaSupermercado();

        boolean resultado = controlador.cadastrarCliente(
                "C001",
                "Maria da Silva",
                111111111,
                "maria@email.com",
                "Prata"
        );

        assertFalse(resultado);
        assertEquals(0, controlador.contarClientes());
    }


    // =========================================================
    // TESTES DE CADASTRO VÁLIDO
    // =========================================================

    @Test
    public void testCadastrarClienteComum() throws Exception {
    	SistemaSupermercado controlador = new SistemaSupermercado();

        boolean resultado = controlador.cadastrarCliente(
                "C001",
                "Maria da Silva",
                111111111,
                "maria@email.com",
                "Comum"
        );

        assertTrue(resultado);
        assertEquals(1, controlador.contarClientes());
    }

    @Test
    public void testCadastrarClienteOuro() throws Exception {
    	SistemaSupermercado controlador = new SistemaSupermercado();

        boolean resultado = controlador.cadastrarCliente(
                "C001",
                "Maria da Silva",
                111111111,
                "maria@email.com",
                "Ouro"
        );

        assertTrue(resultado);
        assertEquals(1, controlador.contarClientes());
    }

    @Test
    public void testCadastrarClienteDiamante() throws Exception {
    	SistemaSupermercado controlador = new SistemaSupermercado();

        boolean resultado = controlador.cadastrarCliente(
                "C001",
                "Maria da Silva",
                111111111,
                "maria@email.com",
                "Diamante"
        );

        assertTrue(resultado);
        assertEquals(1, controlador.contarClientes());
    }


    // =========================================================
    // TESTE DE CÓDIGO REPETIDO
    // =========================================================

    @Test
    public void testCadastrarClienteComCodigoRepetido() throws Exception {
    	SistemaSupermercado controlador = new SistemaSupermercado();

        boolean primeiroCadastro = controlador.cadastrarCliente(
                "C001",
                "Maria da Silva",
                111111111,
                "maria@email.com",
                "Ouro"
        );

        boolean segundoCadastro = controlador.cadastrarCliente(
                "C001",
                "Joao da Silva",
                222222222,
                "joao@email.com",
                "Comum"
        );

        assertTrue(primeiroCadastro);
        assertFalse(segundoCadastro);
        assertEquals(1, controlador.contarClientes());
    }


    // =========================================================
    // TESTES DE CONSULTA
    // =========================================================

    @Test
    public void testConsultarClienteExistente() throws Exception {
    	SistemaSupermercado controlador = new SistemaSupermercado();

        controlador.cadastrarCliente(
                "C001",
                "Maria da Silva",
                111111111,
                "maria@email.com",
                "Ouro"
        );

        Cliente cliente = controlador.consultaCliente("C001");

        assertEquals("C001", cliente.getCodigo());
        assertEquals("Maria da Silva", cliente.getNome());
        assertEquals(0, cliente.getQuantPontos());
    }

    @Test
    public void testConsultarClienteInexistente() {
    	SistemaSupermercado controlador = new SistemaSupermercado();

        Cliente cliente = controlador.consultaCliente("C999");

        assertEquals(null, cliente);
    }


    // =========================================================
    // TESTES DE REMOÇÃO
    // =========================================================

    @Test
    public void testRemoverClienteExistente() throws Exception {
    	SistemaSupermercado controlador = new SistemaSupermercado();

        controlador.cadastrarCliente(
                "C001",
                "Maria da Silva",
                111111111,
                "maria@email.com",
                "Ouro"
        );

        boolean resultado =
                controlador.removerCliente("C001");

        assertTrue(resultado);
        assertEquals(0, controlador.contarClientes());
    }

    @Test
    public void testRemoverClienteInexistente() {
    	SistemaSupermercado controlador = new SistemaSupermercado();

        boolean resultado =
                controlador.removerCliente("C999");

        assertFalse(resultado);
        assertEquals(0, controlador.contarClientes());
    }


    // =========================================================
    // TESTES DE COMPRAS
    // =========================================================

    @Test
    public void testRegistrarCompraClienteComum() throws Exception {
    	SistemaSupermercado controlador = new SistemaSupermercado();

        controlador.cadastrarCliente(
                "C001",
                "Maria da Silva",
                111111111,
                "maria@email.com",
                "Comum"
        );

        double valorFinal =
                controlador.registrarCompra("C001", 100.00);

        assertEquals(100.00, valorFinal, 0.001);

        Cliente cliente =
                controlador.consultaCliente("C001");

        assertEquals(10, cliente.getQuantPontos());
    }

    @Test
    public void testRegistrarCompraClienteOuro() throws Exception {
    	SistemaSupermercado controlador = new SistemaSupermercado();

        controlador.cadastrarCliente(
                "C001",
                "Maria da Silva",
                111111111,
                "maria@email.com",
                "Ouro"
        );

        double valorFinal =
                controlador.registrarCompra("C001", 100.00);

        assertEquals(95.00, valorFinal, 0.001);

        Cliente cliente =
                controlador.consultaCliente("C001");

        assertEquals(20, cliente.getQuantPontos());
    }

    @Test
    public void testRegistrarCompraClienteDiamante() throws Exception {
    	SistemaSupermercado controlador = new SistemaSupermercado();

        controlador.cadastrarCliente(
                "C001",
                "Maria da Silva",
                111111111,
                "maria@email.com",
                "Diamante"
        );

        double valorFinal =
                controlador.registrarCompra("C001", 100.00);

        assertEquals(90.00, valorFinal, 0.001);

        Cliente cliente =
                controlador.consultaCliente("C001");

        assertEquals(30, cliente.getQuantPontos());
    }


    // =========================================================
    // TESTES DE ACÚMULO DE PONTOS
    // =========================================================

    @Test
    public void testAcumularPontosEmMaisDeUmaCompra() throws Exception {
    	SistemaSupermercado controlador = new SistemaSupermercado();

        controlador.cadastrarCliente(
                "C001",
                "Maria da Silva",
                111111111,
                "maria@email.com",
                "Ouro"
        );

        controlador.registrarCompra("C001", 100.00);
        controlador.registrarCompra("C001", 50.00);

        Cliente cliente =
                controlador.consultaCliente("C001");

        // 100 -> 20 pontos
        // 50  -> 10 pontos
        // Total -> 30 pontos
        assertEquals(30, cliente.getQuantPontos());
    }


    // =========================================================
    // TESTES DE COMPRAS INVÁLIDAS
    // =========================================================

//    @Test
//    public void testRegistrarCompraComValorZero() {
//    	SistemaSupermercado controlador = new SistemaSupermercado();
//
//        controlador.cadastrarCliente(
//                "C001",
//                "Maria da Silva",
//                111111111,
//                "maria@email.com",
//                "Ouro"
//        );
//
//        boolean resultado =
//                controlador.registrarCompra("C001", 0);
//
//        assertFalse(resultado);
//
//        Cliente cliente =
//                controlador.consultarCliente("C001");
//
//        assertEquals(0, cliente.getPontos());
//    }

//    @Test
//    public void testRegistrarCompraComValorNegativo() {
//    	SistemaSupermercado controlador = new SistemaSupermercado();
//
//        controlador.cadastrarCliente(
//                "C001",
//                "Maria da Silva",
//                111111111,
//                "maria@email.com",
//                "Ouro"
//        );
//
//        boolean resultado =
//                controlador.registrarCompra("C001", -100);
//
//        assertFalse(resultado);
//
//        Cliente cliente =
//                controlador.consultarCliente("C001");
//
//        assertEquals(0, cliente.getPontos());
//    }

//    @Test
//    public void testRegistrarCompraDeClienteInexistente() {
//    	SistemaSupermercado controlador = new SistemaSupermercado();
//
//        boolean resultado =
//                controlador.registrarCompra("C999", 100);
//
//        assertFalse(resultado);
//    }


    // =========================================================
    // TESTE DA REPRESENTAÇÃO TEXTUAL
    // =========================================================

    @Test
    public void testToStringCliente() throws Exception {
    	SistemaSupermercado controlador = new SistemaSupermercado();

        controlador.cadastrarCliente(
                "C001",
                "Maria da Silva",
                111111111,
                "maria@email.com",
                "Ouro"
        );

        Cliente cliente =
                controlador.consultaCliente("C001");

        assertEquals(
                "C001 | Maria da Silva | 0 pontos | Ouro",
                cliente.toString()
        );
    }
}
