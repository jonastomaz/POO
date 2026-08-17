package controlador;

import heroi.Heroi;
import heroi.SistemaHeroi;

public class ControladorSistemaHeroi {

    private SistemaHeroi sistema;

    public ControladorSistemaHeroi() {
    	this.sistema = new SistemaHeroi();
    }

    public boolean cadastrarHeroiFisico(
            int codigo,
            String nomeVerdadeiro,
            String codinome,
            int energia,
            int experiencia,
            int nivelForca) {

        return sistema.cadastrarHeroiFisico(
                codigo,
                nomeVerdadeiro,
                codinome,
                energia,
                experiencia,
                nivelForca);
    }

    public boolean cadastrarHeroiTecnologico(
            int codigo,
            String nomeVerdadeiro,
            String codinome,
            int energia,
            int experiencia,
            String equipamentoPrincipal,
            int nivelTecnologico) {

        return sistema.cadastrarHeroiTecnologico(
                codigo,
                nomeVerdadeiro,
                codinome,
                energia,
                experiencia,
                equipamentoPrincipal,
                nivelTecnologico);
    }

    public boolean cadastrarHeroiMistico(
            int codigo,
            String nomeVerdadeiro,
            String codinome,
            int energia,
            int experiencia,
            String origemPoder,
            int nivelMagia) {

        return sistema.cadastrarHeroiMistico(
                codigo,
                nomeVerdadeiro,
                codinome,
                energia,
                experiencia,
                origemPoder,
                nivelMagia);
    }

    public Heroi buscarHeroi(int codigo) {
        return sistema.buscarHeroi(codigo);
    }

    public String exibirInformacoesHeroi(int codigo) {
        return sistema.exibirInformacoesHeroi(codigo);
    }

    public String exibirTodosHerois() {
        return sistema.exibirTodosHerois();
    }

    public int contarHerois() {
        return sistema.contarHerois();
    }

    public String executarHabilidade(int codigo) {
        return sistema.executarHabilidade(codigo);
    }

    public String executarHabilidadesDeTodos() {
        return sistema.executarHabilidadesDeTodos();
    }

    public int calcularForcaTotal(int codigo) {
        return sistema.calcularForcaTotal(codigo);
    }

    public int calcularForcaTotalEquipe() {
        return sistema.calcularForcaTotalEquipe();
    }

    public Heroi encontrarHeroiMaisForte() {
        return sistema.encontrarHeroiMaisForte();
    }

    public String registrarConclusaoMissao(int codigo) {
        return sistema.registrarConclusaoMissao(codigo);
    }
}
