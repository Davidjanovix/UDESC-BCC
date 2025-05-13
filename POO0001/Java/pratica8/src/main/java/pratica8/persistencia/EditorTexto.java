package pratica8.persistencia;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class EditorTexto {

    public List<String> leTexto(String caminho) {
        List<String> lista = new LinkedList<String>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                lista.add(linha);
            }
        } catch (IOException e) {
            System.err.println("Erro ao manipular o arquivo: ");
            System.exit(0);
        }

        return lista;
    }

    public void gravaTexto(String caminho, List<String> dados) {
        try (FileWriter fw = new FileWriter(caminho)) {
            for (String linha : dados) {
                fw.write(linha + "\n");
            }
        } catch (IOException e) {
            System.err.println("Erro ao manipular o arquivo: ");
            System.exit(0);
        }
    }
}
