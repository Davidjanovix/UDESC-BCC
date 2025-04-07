package br.udesc.apresentacao;
import br.udesc.dados.Contato;
import br.udesc.negocio.ListaTelefonica;

/**
 * Hello world!
 *
 */
public class Principal 
{
    private ListaTelefonica lista = new ListaTelefonica();

    public ListaTelefonica getLista() {
        return lista;
    }
    public void setLista(ListaTelefonica lista) {
        this.lista = lista;
    }
    public static void main( String[] args ) {
        Principal p = new Principal();

        Contato c = new Contato();

        c.setNome("David");
        c.setTelefone(991228141);
        p.getLista().adicionarContato(c);

        System.out.print(p.getLista());

        p.getLista().removerContato(c);

        System.out.print(p.getLista());
    }
}
