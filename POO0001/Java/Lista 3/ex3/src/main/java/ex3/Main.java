package ex3;

public class Main 
{
    public static void main( String[] args )
    {
        Grafo grafo = new Grafo();
        Digrafo digrafo = new Digrafo();
        for(int i = 0; i < 5; i++) { // Adiciona 5 vertices no grafo e no digrafo
            grafo.adicionarVertice();
            digrafo.adicionarVertice();
        }
        grafo.adicionarAresta(0, 1);
        grafo.adicionarAresta(0, 2);
        grafo.adicionarAresta(1, 1);
        grafo.adicionarAresta(1, 2);
        grafo.adicionarAresta(1, 3);
        grafo.adicionarAresta(1, 4);
        grafo.adicionarAresta(2, 3);
        grafo.adicionarAresta(3, 4);
        digrafo.adicionarAresta(0, 1);
        digrafo.adicionarAresta(0, 2);
        digrafo.adicionarAresta(1, 1);
        digrafo.adicionarAresta(1, 3);
        digrafo.adicionarAresta(2, 0);
        digrafo.adicionarAresta(2, 1);
        digrafo.adicionarAresta(2, 3);
        digrafo.adicionarAresta(3, 4);
        digrafo.adicionarAresta(4, 1);
        System.out.println("Grafo:");
        System.out.println(grafo.toString());
        System.out.println("Digrafo:");
        System.out.println(digrafo.toString());
    }
}
