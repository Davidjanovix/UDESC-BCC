package ex3;

public class Grafo extends Digrafo {
    public Grafo() {
        super();
    }

    @Override
    public void adicionarAresta(int origem, int destino) {
        if (!super.getMatrizAdjacencia().containsKey(origem)) {
            return; // Se o vertice origem não existe, não adiciona a aresta
        }
        if (!super.getMatrizAdjacencia().containsKey(destino)) {
            return; // Se o vertice destino não existe, não adiciona a aresta
        }
        super.getMatrizAdjacencia().get(origem).set(destino, 1); // Adiciona a aresta
        super.getMatrizAdjacencia().get(destino).set(origem, 1); // Adiciona a aresta na direção oposta
    }
    
}
