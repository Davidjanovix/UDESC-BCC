package ex1.sistema;

import ex1.dados.Pessoa;
import java.util.*;

public class Sistema {
    private List<Pessoa> criancas = new ArrayList<>();
    private List<Pessoa> adolescentes = new ArrayList<>();
    private List<Pessoa> jovens = new ArrayList<>();
    private List<Pessoa> adultos = new ArrayList<>();
    private List<Pessoa> idosos = new ArrayList<>();

    public void adicionarPessoa(Pessoa p) {
        int idade = p.getIdade();
        if (idade >= 1 && idade <= 12) {
            criancas.add(p);
        } else if (idade >= 13 && idade <= 18) {
            adolescentes.add(p);
        } else if (idade >= 19 && idade <= 25) {
            jovens.add(p);
        } else if (idade >= 26 && idade <= 59) {
            adultos.add(p);
        } else {
            idosos.add(p);
        }
    }

    public List<Pessoa> getCriancas() {
        return criancas;
    }
    public List<Pessoa> getAdolescentes() {
        return adolescentes;
    }
    public List<Pessoa> getJovens() {
        return jovens;
    }
    public List<Pessoa> getAdultos() {
        return adultos;
    }
    public List<Pessoa> getIdosos() {
        return idosos;
    }
    
}
