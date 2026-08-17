package heroi;
import java.util.ArrayList;

public class SistemaHeroi {
	private ArrayList<Heroi> herois;
	
	public SistemaHeroi() {
		this.herois = new ArrayList<Heroi>();
	}
	
	public boolean cadastrarHeroiFisico(int codigoNumerico, String nomeVerdadeiro, String codinome, int energia, int experiencia,
			int nivelDeForca) {
		if(buscarHeroi(codigoNumerico) == null &&  (codigoNumerico >= 0 &&   energia >= 0 &&  experiencia >= 0 &&  nivelDeForca >= 0)) {
			HeroiFisico heroi = new HeroiFisico(codigoNumerico, nomeVerdadeiro, codinome, energia, experiencia, nivelDeForca);
			herois.add(heroi);
			
			return true;
		}
		return false;
		
	}
	
	public boolean cadastrarHeroiTecnologico(int codigoNumerico, String nomeVerdadeiro, String codinome, int energia, int experiencia,
			String equipamentoPrincipal, int nivelTecnologico) {
		if(buscarHeroi(codigoNumerico) == null &&  (codigoNumerico >= 0 &&  energia >= 0 &&  experiencia >= 0 &&  nivelTecnologico >= 0)) {
			HeroiTecnologico heroi = new HeroiTecnologico(codigoNumerico,nomeVerdadeiro,codinome,energia, experiencia,
					equipamentoPrincipal,nivelTecnologico);
			herois.add(heroi);
			
			return true;
		}
		return false;
	}
	
	public boolean cadastrarHeroiMistico(int codigoNumerico, String nomeVerdadeiro, String codinome, int energia, int experiencia,
			String origemDoPoder, int nivelDeMagia) {
		if(buscarHeroi(codigoNumerico) == null &&  (codigoNumerico >= 0 &&  energia >= 0 &&  experiencia >= 0 && nivelDeMagia >= 0)) {
			HeroiMistico heroi = new HeroiMistico(codigoNumerico,nomeVerdadeiro,codinome,energia,experiencia,
					origemDoPoder,nivelDeMagia);
			herois.add(heroi);
			
			return true;
		}
		return false;
	}
	
	public int contarHerois() {
		return herois.size();
	}
	
	public Heroi buscarHeroi(int codigo) {
		for(Heroi heroi: this.herois) {
			if(heroi.getCodigo() == codigo) {
				return heroi;
			}
		}
		return null;
	}
	
	public String exibirInformacoesHeroi(int codigo) {
		if(buscarHeroi(codigo) == null) {
			return "Heroi nao encontrado.";
		}
		return buscarHeroi(codigo).toString();
	}
	
	public String exibirTodosHerois() {
	    String mensagem = "";
	    
	    if (contarHerois() == 0) {
			return "Nenhum heroi cadastrado.";
		}
	    
	    for (int i = 0; i < this.herois.size(); i++) {
	        mensagem += exibirInformacoesHeroi(this.herois.get(i).getCodigo());
	        if (i != this.herois.size() - 1) {
	            mensagem += "\n\n";
	        }
	    }
	    return mensagem;
	}
	
	public String executarHabilidade(int codigo) {
		if(buscarHeroi(codigo) == null) {
			return "Heroi nao encontrado.";
		}
		Heroi heroi = buscarHeroi(codigo);
		return heroi.usarHabilidade();
	}
	
	public String executarHabilidadesDeTodos() {
		String mensagem = "";
		
		if (contarHerois() == 0) {
			return "Nenhum heroi cadastrado.";
		}
		
		for(int i = 0; i < this.herois.size(); i++) {
			mensagem += executarHabilidade(this.herois.get(i).getCodigo());
			if (i != this.herois.size() - 1) {
	            mensagem += "\n";
	        }
		}
		return mensagem;
	}
	
	public int calcularForcaTotal(int codigo) {
		if (contarHerois() == 0) {
			return 0;
		}
		
		Heroi heroi = buscarHeroi(codigo);
		return heroi.calcularForcaTotal();
	}
	
	public int calcularForcaTotalEquipe() {
		int forca = 0;
		
		if (contarHerois() == 0) {
			return 0;
		}
		
		for(Heroi heroi : this.herois) {
			forca += heroi.calcularForcaTotal();
		}
		return forca;
	}
	
	public Heroi encontrarHeroiMaisForte() {
		if (contarHerois() == 0) {
			return null;
		}
		
		Heroi heroiMaisForte = this.herois.get(0);
		for(int i = 0; i < this.herois.size()-1; i++) {
			if(heroiMaisForte.calcularForcaTotal() < this.herois.get(i+1).calcularForcaTotal()) {
				heroiMaisForte = this.herois.get(i+1);
			}
		}
		return heroiMaisForte;
	}
	
	public String registrarConclusaoMissao(int codigo) {
		if(buscarHeroi(codigo) != null) {
			buscarHeroi(codigo).setExperiencia(5);
			return buscarHeroi(codigo).getCodinome() + " concluiu a missao. Experiencia recebida: 5 pontos.";
		}
		return "Heroi nao encontrado.";
	}
}
