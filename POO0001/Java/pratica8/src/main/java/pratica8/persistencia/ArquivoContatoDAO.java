package pratica8.persistencia;
import pratica8.dados.Contato;

import java.util.List;
import java.util.LinkedList;

public class ArquivoContatoDAO {
    private final String caminho = "arquivo/contatos.csv";

    private String toCSV(Contato c) {
        StringBuilder sb = new StringBuilder();
        sb.append(c.getNome());
        sb.append(",");
        sb.append(c.getTelefone());
        return sb.toString();
    }
    private Contato fromCSV(String s) {
        String[] partes = s.split(",");
        Contato c = new Contato();
        c.setNome(partes[0]);
        c.setTelefone(partes[1]);
        return c;
    }
    public List<Contato> leContatos() {
        EditorTexto editor = new EditorTexto();
        List<String> linhas = editor.leTexto(caminho);
        List<Contato> contatos = new LinkedList<Contato>();
        for (String linha : linhas) {
            Contato c = fromCSV(linha);
            contatos.add(c);
        }
        return contatos;
    }
    public void salvaContatos(List<Contato> contatos) {
        EditorTexto editor = new EditorTexto();
        List<String> linhas = new LinkedList<String>();
        for (Contato c : contatos) {
            linhas.add(toCSV(c));
        }
        editor.gravaTexto(caminho, linhas);
    }
}
