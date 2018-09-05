package vetor;

import java.util.Comparator;

/**
 * Implementação de um vetor de objetos simples para exercitar os conceitos de
 * Generics.
 * 
 * @author Adalberto
 *
 */
public class Vetor<T extends Comparable<T>> {

	// O array interno onde os objetos manipulados são guardados
	private T[] arrayInterno;

	// O tamanho que o array interno terá
	private int tamanho;

	// Indice que guarda a proxima posição vazia do array interno
	private int indice;

	// O Comparators a serem utilizados
	private Comparator comparadorMaximo;
	private Comparator comparadorMinimo;

	public Vetor(int tamanho) {
		super();
		this.tamanho = tamanho;
		this.indice = -1;
		this.arrayInterno = (T[])(new Comparable[tamanho]);
	}

	public void setComparadorMaximo(Comparator comparadorMaximo) {
		this.comparadorMaximo = comparadorMaximo;
	}

	public void setComparadorMinimo(Comparator comparadorMinimo) {
		this.comparadorMinimo = comparadorMinimo;
	}

	// Insere um objeto no vetor
	public void inserir(T o) {
	    if (!this.isCheio()){
	        this.arrayInterno[++this.indice] = o;
        }
    }

	// Remove um objeto do vetor
	public T remover(T o) {
		T elementoExcluido = null;
		boolean encontrado = false;
		int i = 0;

		if(!isVazio()){
		    while (i <= this.indice && !encontrado){
		        if(this.arrayInterno[i].equals(o)){
		            elementoExcluido = this.arrayInterno[i];
		            encontrado = true;
                }

                i++;
            }

            for(int j = i - 1; j < this.indice; j++){
                this.arrayInterno[j] = this.arrayInterno[j + 1];
            }

            this.arrayInterno[this.indice] = null;
            this.indice--;
        }

        return  elementoExcluido;
	}

	// Procura um elemento no vetor
	public T procurar(T o) {
	    T elemento = null;
	    boolean encontrado = false;
	    int i = 0;

		if(!isVazio()){
		    while (i <= this.indice && !encontrado){
                if(this.arrayInterno[i].equals(o)){
                    elemento = this.arrayInterno[i];
                    encontrado = true;
                }

                i++;
            }
        }

        return elemento;
	}

	// Diz se o vetor está vazio
	public boolean isVazio() {
		return this.indice == -1;
	}

	// Diz se o vetor está cheio
	public boolean isCheio() {
		return this.tamanho - 1 == this.indice;
	}

	public T maximo(){
	    T maximo = null;

	    if(!isVazio()){
	        maximo = this.arrayInterno[0];

	        for(int i = 1; i <= this.indice; i++){
	            if(comparadorMaximo.compare(maximo, this.arrayInterno[i]) < 0){
	                maximo = this.arrayInterno[i];
                }
            }
        }

	    return maximo;
    }

    public T minimo(){
        T minimo = null;

        if(!isVazio()){
            minimo = this.arrayInterno[0];

            for(int i = 1; i <= this.indice; i++){
                if(comparadorMinimo.compare(minimo, this.arrayInterno[i]) < 0){
                    minimo = this.arrayInterno[i];
                }
            }
        }

        return minimo;
    }
}

class ComparatorMaximo implements Comparator<Aluno>{

    @Override
    public int compare(Aluno aluno, Aluno outroAluno) {
        return Double.compare(aluno.getMedia(), outroAluno.getMedia());
    }
}


class ComparatorMinimo implements Comparator<Aluno>{

    @Override
    public int compare(Aluno aluno, Aluno outroAluno) {
        return Double.compare(outroAluno.getMedia(), aluno.getMedia());
    }
}