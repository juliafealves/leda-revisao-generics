package vetor;

public class TestarVetor {

	public static void main(String[] args) {
		// preencha esse metodo com codigo para testar a classe vetor.
		// À medida que voce evoluir no exercício o conteúdo deste mpetodo
		// também será modificado.
        Vetor vetor = new Vetor<String>(3);

        System.out.println("Esta vazio? " + vetor.isVazio());
        System.out.println("Existe? - Julia: " + vetor.procurar("Julia"));

        vetor.inserir("Julia");
        System.out.println("Esta vazio? " + vetor.isVazio());

        vetor.inserir("Fernandes");
        System.out.println("Esta cheio? " + vetor.isCheio());

        vetor.inserir("Alves");
        System.out.println("Esta cheio? " + vetor.isCheio());

        System.out.println("Existe? - Julia: " + vetor.procurar("Julia"));
        System.out.println("Existe? - Joana: " + vetor.procurar("Joana"));


        /**
         * Remover
         */
        Vetor nomes = new Vetor<String>(3);
        nomes.inserir("Joao");
        nomes.inserir("Lucas");
        nomes.inserir("Matheus");
        nomes.remover("Lucas");
        System.out.println(nomes.procurar("Lucas"));

    }
}
