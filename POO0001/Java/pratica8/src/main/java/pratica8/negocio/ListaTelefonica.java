package pratica8.negocio;
import pratica8.dados.Contato;
import pratica8.persistencia.ContatoDAO;
import java.util.List;
import java.util.Map;

public class ListaTelefonica {
    public ListaTelefonica() {
    }
    public void adicionarContato(Contato contato) {
        ContatoDAO contatoDAO = new ContatoDAO();
        contatoDAO.insert(contato);
    }
    public void removerContato(Contato contato) {
        ContatoDAO contatoDAO = new ContatoDAO();
        contatoDAO.delete(contato);
    }
    public List<Contato> buscarContato(char letra) {
        ContatoDAO contatoDAO = new ContatoDAO();
        Map<Character, List<Contato>> contatos = contatoDAO.getAll();
        return contatos.get(letra);
    }
    public Map<Character, List<Contato>> listarContatos() {
        ContatoDAO contatoDAO = new ContatoDAO();
        return contatoDAO.getAll();
    }
    public Contato buscarPorNome(String nome) {
        ContatoDAO contatoDAO = new ContatoDAO();
        Map<Character, List<Contato>> contatos = contatoDAO.getAll();
        for (List<Contato> lista : contatos.values()) {
            for (Contato contato : lista) {
                if (contato.getNome().equalsIgnoreCase(nome)) {
                    return contato;
                }
            }
        }
        return null;
    }
}
