package vetor;

import java.util.Comparator;

public class TestarVetor {

	public static void main(String[] args) {
		// preencha esse metodo com codigo para testar a classe vetor.
		// À medida que voce evoluir no exercício o conteúdo deste mpetodo
		// também será modificado.
        Vetor vetor = new Vetor<Aluno>(3);
        Aluno aluno = new Aluno("Julia", 9);
        Aluno aluno1 = new Aluno("Ivana", 10);
        Aluno aluno2 = new Aluno("Isabelle", 8);

        System.out.println("Esta vazio? " + vetor.isVazio());
        System.out.println("Existe? - Aluna Julia: " + vetor.procurar(aluno));

        vetor.inserir(aluno);
        System.out.println("Esta vazio? " + vetor.isVazio());

        vetor.inserir(aluno1);
        System.out.println("Esta cheio? " + vetor.isCheio());

        vetor.inserir(aluno2);
        System.out.println("Esta cheio? " + vetor.isCheio());

        System.out.println("Existe? - Julia: " + vetor.procurar(aluno));
        System.out.println("Existe? - Joana: " + vetor.procurar(new Aluno("Joana", 7)));

        vetor.remover(aluno);
        System.out.println(vetor.procurar(aluno));

        vetor.setComparadorMaximo(new ComparatorMaximo());
        vetor.setComparadorMinimo(new ComparatorMinimo());
        Aluno alunoMaximo = (Aluno) vetor.maximo();
        Aluno alunoMinimo = (Aluno) vetor.minimo();

        System.out.println("Max: " + alunoMaximo.getNome());
        System.out.println("Min: " + alunoMinimo.getNome());

    }
}
