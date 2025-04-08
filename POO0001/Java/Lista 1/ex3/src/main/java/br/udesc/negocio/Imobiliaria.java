package br.udesc.negocio;
import java.util.ArrayList;
import java.util.List;
import br.udesc.dados.Imovel;

public class Imobiliaria {
    private String nome;
    private List<Imovel> imoveis = new ArrayList<Imovel>();

    public Imobiliaria(String nome) {
        this.nome = nome;
    }
    public Imobiliaria() {}
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public List<Imovel> getImoveis() {
        return imoveis;
    }
    public void adicionarImovel(Imovel imovel) {
        imoveis.add(imovel);
    }
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Imobiliaria: ").append(nome).append("\n");
        for (Imovel imovel : imoveis) {
            sb.append(imovel.toString()).append("\n");
        }
        return sb.toString();
    }

    public List<Imovel> filtrarPorArea(float x) {
        List<Imovel> imoveisFiltrados = new ArrayList<Imovel>();
        for (Imovel imovel : imoveis) {
            if (imovel.area() >= x) {
                imoveisFiltrados.add(imovel);
            }
        }
        for (int i = 0; i < imoveisFiltrados.size(); i++) { //Metodo de ordenacao por bolha
            for (int j = i + 1; j < imoveisFiltrados.size(); j++) {
                if (imoveisFiltrados.get(i).area() > imoveisFiltrados.get(j).area()) {
                    Imovel temp = imoveisFiltrados.get(i);
                    imoveisFiltrados.set(i, imoveisFiltrados.get(j));
                    imoveisFiltrados.set(j, temp);
                }
            }
            
        }
        return imoveisFiltrados;
    }
}
