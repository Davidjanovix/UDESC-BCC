package br.udesc;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nome[], nomeAux;
        nome = new String[5];
        int idade[], idadeAux, i, j;
        idade = new int[5];
        for (i = 0 ; i < 5 ; i++) {
            System.out.print("Digite o nome da pessoa " + (i + 1) + ": ");
            nome[i] = scanner.nextLine();
            System.out.print("Digite a idade da pessoa " + (i + 1) + ": ");
            idade[i] = scanner.nextInt();
            scanner.nextLine(); //Limpeza do buffer de entrada
        }
        for (i = 0 ; i < 5 ; i++) {
            for (j = i + 1 ; j < 5 ; j++) {
                if (idade[i] < idade[j]) {
                    idadeAux = idade[i];
                    idade[i] = idade[j];
                    idade[j] = idadeAux;
                    nomeAux = nome[i];
                    nome[i] = nome[j];
                    nome[j] = nomeAux;
                }
            }
        }
        for (i = 0 ; i < 5 ; i ++) {
            System.out.println((i + 1) + "Nome: " + nome[i] + "\tIdade: " + idade[i]);
        }
        scanner.close();
    }
}  
