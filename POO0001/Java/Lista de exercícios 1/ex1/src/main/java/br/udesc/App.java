package br.udesc;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int valores[], media = 0, i;
        valores = new int[5];
        for (i = 0 ; i < 5 ; i++) {
            System.out.print("Digite o valor " + (i + 1) + ": ");
            valores[i] = scanner.nextInt();
            media += valores[i];
            scanner.nextLine(); //Limpeza do buffer de entrada
        }
        media /= 5;
        System.out.println("A média dos 5 valores é: " + media);
        scanner.close();
    }
}  