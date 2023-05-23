import java.util.Scanner;
import java.util.Stack;

public class VerificadorExpressao {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite uma expressão matemática: ");
        String expressao = scanner.nextLine();

        if (verificarParametrizacao(expressao)) {
            System.out.println("A expressão está escrita corretamente.");
        } else {
            System.out.println("A expressão está escrita incorretamente.");
        }
    }

    public static boolean verificarParametrizacao(String expressao) {
        Stack<Character> pilha = new Stack<>();

        for (char caractere : expressao.toCharArray()) {
            if (caractere == '(') {
                pilha.push(caractere);
            } else if (caractere == ')') {
                if (pilha.isEmpty() || pilha.pop() != '(') {
                    return false;
                }
            }
        }

        return pilha.isEmpty();
    }
}