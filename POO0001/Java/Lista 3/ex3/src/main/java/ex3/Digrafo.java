package ex3;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
public class Digrafo {
    private Map<Integer, List<Integer>> matrizAdjacencia = new HashMap<>();

    public Digrafo() {

    }
    public Map<Integer, List<Integer>> getMatrizAdjacencia() {
        return matrizAdjacencia;
    }
    public void adicionarVertice() {
        if(matrizAdjacencia.isEmpty()) { //Se o mapa estiver vazio, adiciona o primeiro vertice
            matrizAdjacencia.put(0, new ArrayList<>());
            matrizAdjacencia.get(0).add(0); //Adiciona a primeira lista
            return;
        }
        for(List<Integer> lista : matrizAdjacencia.values()) { //Adiciona uma coluna para cada lista
            lista.add(0);
        }
        int size = matrizAdjacencia.size(); //Lê o tamanho do mapa
        matrizAdjacencia.put(size, new ArrayList<>()); //Adiciona uma nova lista
        for(int i = 0; i <= size; i++) {
            matrizAdjacencia.get(size).add(0); //Adiciona todas as colunas da lista adicionada
        }
    }
    public void adicionarAresta(int origem, int destino) {
        if(!matrizAdjacencia.containsKey(origem)) {
            return; //Se o vertice origem não existe, não adiciona a aresta
        }
        if(!matrizAdjacencia.containsKey(destino)) {
            return; //Se o vertice destino não existe, não adiciona a aresta
        }
        matrizAdjacencia.get(origem).set(destino, 1); //Adiciona a aresta
    }
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("  "); //Adiciona o espaço para os índices das colunas
        for (int i = 0; i < matrizAdjacencia.size(); i++) { //Adiciona os índices das colunas
            sb.append(i).append(" "); 
        }
        sb.append("\n");
        int i = 0;
        for (List<Integer> lista : matrizAdjacencia.values()) {
            sb.append(i++).append(" "); //Adiciona os índices das linhas
            for (Integer valor : lista) {
                sb.append(valor).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString(); //Retorna a string formatada
    }

}
