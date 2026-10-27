package lab_ordenacao;

public class Ordenacao implements Ordenacao_IF{

	public boolean checaVetorOrdenado(Pessoa[] pessoas) { //Método brinde pra ajudar a testar os algoritmos implementados
		for (int i = 1; i < pessoas.length; i++) {
			if (pessoas[i - 1].getIdade() > pessoas[i].getIdade()) {
				return false;
			} else if (pessoas[i - 1].getIdade() == pessoas[i].getIdade()) {
				if (pessoas[i - 1].getNome().compareTo(pessoas[i].getNome()) > 0) {
					return false;
				}
			}
		}
		return true;
	}

	@Override
	public void bubbleSort(Pessoa[] pessoas) {
		int n = pessoas.length;
		boolean trocou = true;
		for (int i = 0; i < n - 1 && trocou; i++) {
			trocou = false;
			for (int j = 0; j < n - 1 - i; j++) {
				if (pessoas[j].compareTo(pessoas[j + 1]) > 0) {
					Pessoa p = pessoas[j];
					pessoas[j] = pessoas[j + 1];
					pessoas[j + 1] = p;
					trocou = true;
				}
			}
		}
	}

	@Override
	public void selectionSort(Pessoa[] pessoas) {
		int n = pessoas.length;
		for (int i = 0; i < n - 1; i++) {
			int menor = i;
			for (int j = i + 1; j < n; j++) {
				if (pessoas[j].compareTo(pessoas[menor]) < 0) {
					menor = j;
				}
			}
			if (menor != i) {
				Pessoa tmp = pessoas[i];
				pessoas[i] = pessoas[menor];
				pessoas[menor] = tmp;
			}
		}
	}

	@Override
	public void insertionSort(Pessoa[] pessoas) {
		for (int i = 1; i < pessoas.length; i++) {
			Pessoa chave = pessoas[i];
			int j = i - 1;
			while (j >= 0 && pessoas[j].compareTo(chave) > 0) {
				pessoas[j + 1] = pessoas[j];
				j--;
			}
			pessoas[j + 1] = chave;
		}
	}

	@Override
	public void mergeSort(Pessoa[] pessoas) {
		if (pessoas == null || pessoas.length < 2) {
			return;
		}
		Pessoa[] aux = new Pessoa[pessoas.length];
		mergeSort(pessoas, aux, 0, pessoas.length - 1);
	}

	private void mergeSort(Pessoa[] v, Pessoa[] aux, int esq, int dir) {
		if (esq >= dir) {
			return;
		}
		int meio = esq + (dir - esq) / 2;
		mergeSort(v, aux, esq, meio);
		mergeSort(v, aux, meio + 1, dir);
		merge(v, aux, esq, meio, dir);
	}

	private void merge(Pessoa[] v, Pessoa[] aux, int esq, int meio, int dir) {
		for (int k = esq; k <= dir; k++) {
			aux[k] = v[k];
		}
		int i = esq;
		int j = meio + 1;
		for (int k = esq; k <= dir; k++) {
			if (i > meio) {
				v[k] = aux[j++];
			} else if (j > dir) {
				v[k] = aux[i++];
			} else if (aux[j].compareTo(aux[i]) < 0) { 
				v[k] = aux[j++];
			} else {
				v[k] = aux[i++];
			}
		}
	}
}
