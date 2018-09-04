package vetor;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Implementação de um vetor de objetos simples para exercitar os conceitos de
 * Generics.
 * 
 * @author Adalberto
 *
 */
public class Vetor<T> {

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
		this.arrayInterno = (T[])(new Object[tamanho]);
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

	public void teste(){
        System.out.println(Arrays.toString(this.arrayInterno));
    }

}
