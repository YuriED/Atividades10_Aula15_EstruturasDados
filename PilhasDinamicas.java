import java.util.*;

public class PilhasDinamicas {
    public static void main(String[] args) {

        List<Integer> numerosSorteados = sortearNumeros(1, 9, 100);

        LinkedList<Integer> pilha1 = new LinkedList<>();
        LinkedList<Integer> pilha2 = new LinkedList<>();
        LinkedList<Integer> pilha3 = new LinkedList<>();

        for (int numero : numerosSorteados) {
            if (numero >= 1 && numero <= 3) {
                pilha1.add(numero);
            } else if (numero >= 4 && numero <= 6) {
                pilha2.add(numero);
            } else {
                pilha3.add(numero);
            }
        }

        List<Integer> numerosSorteadosFase2 = sortearNumeros(1, 3, 100);
        Random random = new Random();

        while (!pilha1.isEmpty() && !pilha2.isEmpty() && !pilha3.isEmpty() && !numerosSorteadosFase2.isEmpty()) {
            int pilhaEscolhida = numerosSorteadosFase2.remove(random.nextInt(numerosSorteadosFase2.size()));

            if (pilhaEscolhida == 1) {
                int numero1 = pilha2.removeLast();
                int numero2 = pilha3.removeLast();
                pilha1.add(numero1);
                pilha1.add(numero2);
                System.out.println("Empilhando os números " + numero1 + " e " + numero2 + " na pilha 1");
            } else if (pilhaEscolhida == 2) {
                int numero1 = pilha1.removeLast();
                int numero2 = pilha3.removeLast();
                pilha2.add(numero1);
                pilha2.add(numero2);
                System.out.println("Empilhando os números " + numero1 + " e " + numero2 + " na pilha 2");
            } else {
                int numero1 = pilha1.removeLast();
                int numero2 = pilha2.removeLast();
                pilha3.add(numero1);
                pilha3.add(numero2);
                System.out.println("Empilhando os números " + numero1 + " e " + numero2 + " na pilha 3");
            }
        }

        System.out.println("\nPilha 1: " + pilha1);
        System.out.println("Pilha 2: " + pilha2);
        System.out.println("Pilha 3: " + pilha3);

        if (pilha1.isEmpty() || pilha2.isEmpty() || pilha3.isEmpty()) {
            System.out.println("\nO programa foi encerrado porque uma das pilhas ficou vazia.");
        } else if (numerosSorteadosFase2.isEmpty()) {
            System.out.println("\nO programa foi encerrado após sortear os 100 números.");
        }
    }

    private static List<Integer> sortearNumeros(int min, int max, int quantidade) {
        List<Integer> numerosSorteados = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < quantidade; i++) {
            int numero = random.nextInt(max - min + 1) + min;
            numerosSorteados.add(numero);
        }

        return numerosSorteados;
    }
}