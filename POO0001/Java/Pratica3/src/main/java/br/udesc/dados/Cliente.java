package br.udesc.dados;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    
    private String cpf;
    private String nome;
    private String endereco;
    private String telefone;
    private List<Reserva> reservas = new ArrayList<>();

    public Cliente(String cpf, String nome, String endereco, String telefone) {
        this.cpf = cpf;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    public Cliente() {
    }

    public void reservarIda(Reserva reserva) {
        reservas.add(reserva);
    }

    public void reservarVolta(Reserva ida, Reserva volta) {
        ida.setIdaEvolta(true);
        ida.setVolta(volta);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();     //Cria um objeto StringBuilder
        sb.append("Cliente: ");     //Concatena os valores na string
        sb.append(nome);
        sb.append(" CPF: "); 
        sb.append(cpf);
        sb.append(" Endereço: ");
        sb.append(endereco);
        sb.append(" Telefone: ");
        sb.append(telefone);
        sb.append(" Reservas:\n");
        for (Reserva reserva : reservas) {
            if (reserva.isIdaEvolta()) {    //Se for ida e volta, identifica na string
                sb.append("Reservas Número: ").append(reserva.getNumReserva()).append("/").append(reserva.getVolta().getNumReserva()).append(" (Ida e volta)\n");
            } else {
            sb.append("Reserva Número: ").append(reserva.getNumReserva()).append("\n");
            }
        }   //Para cada reserva, concatena o número da reserva na string
        return sb.toString();
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }    
}
