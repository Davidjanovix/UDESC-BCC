package br.udesc.dados;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String cpf;
    private String nome;
    private String endereco;
    private String telefone;
    List<Reserva> reservas = new ArrayList<>();

    public void reservarIda(Reserva reserva) {
        reservas.add(reserva);
    }

    public void reservarVolta(Reserva ida, Reserva volta) {
        int index = reservas.indexOf(ida); //Encontra o índice da passagem de ida
        reservas.add(++index, volta); //Adiciona a passagem de volta logo em seguida da passagem de ida
        ida.setIdaEvolta(true); //Marca a passagem de ida como ida e volta
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(); //Cria um objeto StringBuilder
        sb.append("Cliente: ");
        sb.append(nome);
        sb.append(" CPF: "); //Concatena os valores na string
        sb.append(cpf);
        sb.append(" Endereço: ");
        sb.append(endereco);
        sb.append(" Telefone: ");
        sb.append(telefone);
        sb.append(" Reservas:\n");
        for (Reserva reserva : reservas) {
            if (reserva.isIdaEvolta()) { //Se for ida e volta, identifica na string
                sb.append("(Ida) Reserva Número: ").append(reserva.getNumReserva()).append("\n");
                sb.append("(Volta) ");
            } else {
            sb.append("Reserva Número: ").append(reserva.getNumReserva()).append("\n");
            }
        } //Para cada reserva, concatena o número da reserva na string
        return sb.toString();
    }
}
