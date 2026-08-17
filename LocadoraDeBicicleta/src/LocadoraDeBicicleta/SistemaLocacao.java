package LocadoraDeBicicleta;

public class SistemaLocacao {

    private Cliente[] clientes = new Cliente[10];
    private Bicicleta[] bicicletas = new Bicicleta[10];
    private Aluguel[] alugueis = new Aluguel[10];

    private int qtdClientes = 0;
    private int qtdBicicletas = 0;
    private int qtdAlugueis = 0;

    public String cadastrarCliente(String nome, String cpf) {
        if (qtdClientes == 10)
            return "Limite de clientes atingido.";
        clientes[qtdClientes++] = new Cliente(nome, cpf);
        return "Cliente " + nome + " cadastrado com sucesso.";
    }

    public String cadastrarBicicleta(String codigo, String modelo, double diaria) {
        if (qtdBicicletas == 10)
            return "Limite de bicicletas atingido.";
        String mensagem = "";
        if (diaria <= 0) {
            mensagem += "ERRO: Valor de diaria invalido. Foi registrado o valor padrao de R$ 10.00.\n";
        }
        bicicletas[qtdBicicletas++] = new Bicicleta(codigo, modelo, diaria);
        mensagem += "Bicicleta " + codigo + " cadastrada com sucesso.";
        return mensagem;
    }

    private Cliente buscarCliente(String cpf) {
        for (int i = 0; i < qtdClientes; i++) {
            if (clientes[i].getCpf().equals(cpf))
                return clientes[i];
        }
        return null;
    }

    private Bicicleta buscarBicicleta(String codigo) {
        for (int i = 0; i < qtdBicicletas; i++) {
            if (bicicletas[i].getCodigo().equals(codigo))
                return bicicletas[i];
        }
        return null;
    }

    public String alugarBicicleta(String cpf, String codigo, int dias) {
        Cliente cliente = buscarCliente(cpf);
        if (cliente == null)
            return "ERRO: Cliente nao encontrado.";
        Bicicleta bicicleta = buscarBicicleta(codigo);
        if (bicicleta == null)
            return "ERRO: Bicicleta nao encontrada.";
        if (!bicicleta.isDisponivel())
            return "ERRO: A bicicleta " + codigo + " ja esta alugada no momento.";
        String mensagem = "";
        if (dias <= 0) {
            mensagem += "Quantidade de dias invalida. Foi considerado o valor padrao de 1 dia.\n";
            dias = 1;
        }
        bicicleta.alugar();
        Aluguel aluguel = new Aluguel(cliente, bicicleta, dias);
        alugueis[qtdAlugueis++] = aluguel;
        mensagem += "Aluguel realizado com sucesso!\n";
        mensagem += "Cliente: " + cliente.getNome() + "\n";
        mensagem += "Bicicleta: " + bicicleta.getCodigo() + "\n";
        mensagem += "Dias: " + aluguel.getDias() + "\n";
        mensagem += String.format("Valor total: R$ %.2f", aluguel.getValorTotal());

        return mensagem;
    }

    public String devolverBicicleta(String codigo) {

        for (int i = 0; i < qtdAlugueis; i++) {

            if (alugueis[i].isAtivo() &&
                    alugueis[i].getBicicleta().getCodigo().equals(codigo)) {

                alugueis[i].encerrar();
                alugueis[i].getBicicleta().devolver();

                return "Bicicleta " + codigo + " devolvida com sucesso.";
            }
        }

        return "ERRO: Bicicleta nao possui aluguel ativo.";
    }

    public String listarBicicletasDisponiveis() {

        String texto = "-- Bicicletas Disponiveis --\n";

        boolean encontrou = false;

        for (int i = 0; i < qtdBicicletas; i++) {

            if (bicicletas[i].isDisponivel()) {

                texto += String.format("%s - %s - R$ %.2f por dia\n",
                        bicicletas[i].getCodigo(),
                        bicicletas[i].getModelo(),
                        bicicletas[i].getDiaria());

                encontrou = true;
            }
        }

        if (!encontrou)
            texto += "Nenhuma bicicleta disponivel.";

        return texto;
    }

    public String listarAlugueisAtivos() {

        String texto = "-- Alugueis Ativos --\n";

        boolean encontrou = false;

        for (int i = 0; i < qtdAlugueis; i++) {

            if (alugueis[i].isAtivo()) {

                texto += String.format(
                        "Cliente: %s | Bicicleta: %s | Dias: %d | Valor total: R$ %.2f\n",
                        alugueis[i].getCliente().getNome(),
                        alugueis[i].getBicicleta().getCodigo(),
                        alugueis[i].getDias(),
                        alugueis[i].getValorTotal());

                encontrou = true;
            }
        }

        if (!encontrou)
            texto += "Nenhum aluguel ativo.";

        return texto;
    }
}