package br.udesc.negocio;
import br.udesc.dados.*;
import java.util.List;
import java.util.LinkedList;
//import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class ListaTelefonica {

    private Map<Character, List<Contato>> contatos;

    public ListaTelefonica() {
        contatos = new HashMap<Character,List<Contato>>();
        for(char c = 'A' ; c <= 'Z' ; c++) {
            contatos.put(c, new LinkedList<Contato>());
        }
    }

    public void adicionarContato(Contato contato) {
        char inicial = Character.toUpperCase(contato.getNome().charAt(0));
        List<Contato> lista = contatos.get(inicial); //Busca o elemento no hashmap referente à chave "inicial", e retorna a lista
        lista.add(contato);
    }

    public void removerContato(Contato contato) {
        char inicial = Character.toUpperCase(contato.getNome().charAt(0));
        List<Contato> lista = contatos.get(inicial); //Busca o elemento no hashmap referente à chave "inicial", e retorna a lista
        lista.remove(contato);
    }
    
    public String toString() {
        StringBuffer str = new StringBuffer();
        contatos.forEach(
            (chave, valores)->{
                str.append(chave + ":\n");
                valores.forEach(
                    (valor)->{
                        str.append("\t" + valor + ";\n");
                    }
                );
            }    
        );
        return str.toString();
    }

    public Map<Character, List<Contato>> buscarContatos() {
        return contatos;
    }
    
    public List<Contato> buscarContatos(char inicial) {
        return contatos.get(Character.toUpperCase(inicial));
    }
}