package br.udesc;
import java.util.Scanner;

public class Main 
{
    public static void main( String[] args )
    {
        Scanner scanner = new Scanner(System.in);
        Pessoa[] pessoas = new Pessoa[5];
        pessoas[0] = new Pessoa("João", 20);
        pessoas[1] = new Pessoa("Maria", 25);
        pessoas[2] = new Pessoa("José", 30);
        pessoas[3] = new Pessoa("Ana", 22);
        pessoas[4] = new Pessoa("Carlos", 28);

        Sorteador sorteador = new Sorteador(pessoas);
        for (int i = 0; i < 5; i++) {
            System.out.println("Pressione Enter para sortear uma pessoa...");
            scanner.nextLine();
            Pessoa sorteado = sorteador.sortearProximo();
            System.out.println("Sorteado: " + sorteado.getNome() + ", Idade: " + sorteado.getIdade());
        }
        scanner.close();
        System.out.println("Todos os sorteios foram realizados.");
    }
}
