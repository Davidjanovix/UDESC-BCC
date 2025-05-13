package pratica8.persistencia;
import pratica8.dados.Contato;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContatoDAO {
    public void insert(Contato contato) {
        ArquivoContatoDAO arquivoContatoDAO = new ArquivoContatoDAO();
        List<Contato> contatos = arquivoContatoDAO.leContatos();
        contatos.add(contato);
        arquivoContatoDAO.salvaContatos(contatos);
    }
    public void delete(Contato contato) {
        ArquivoContatoDAO arquivoContatoDAO = new ArquivoContatoDAO();
        List<Contato> contatos = arquivoContatoDAO.leContatos();
        contatos.remove(contato);
        arquivoContatoDAO.salvaContatos(contatos);
    }
    public Map<Character, List<Contato>> getAll() {
        Map<Character, List<Contato>> map = new HashMap<>();
        ArquivoContatoDAO arquivoContatoDAO = new ArquivoContatoDAO();
        List<Contato> contatos = arquivoContatoDAO.leContatos();
        for (char letra = 'A'; letra <= 'Z'; letra++) {
            map.put(letra, new ArrayList<>());
        }
        for (Contato contato : contatos) {
            char inicial = Character.toUpperCase(contato.getNome().charAt(0));
            map.get(inicial).add(contato);
        }

        for (List<Contato> lista : map.values()) {
            lista.sort(Comparator.comparing(Contato::getNome, String.CASE_INSENSITIVE_ORDER));
        }
        return map;
    }
}
