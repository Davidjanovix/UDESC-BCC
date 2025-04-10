package br.udesc.negocio;
import br.udesc.dados.*;

import java.util.ArrayList;
import java.util.List;

public class ReservaPassagem {

    private List<Cidade> cidades = new ArrayList<>();
    private List<Cliente> clientes = new ArrayList<>();

    public ReservaPassagem() {
    }

    public void cadastrarCidade(Cidade cidade) {
        cidades.add(cidade);
    }

    public void cadastrarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void reservarIda(Cliente cliente, Reserva reserva) {
        cliente.reservarIda(reserva);
    }

    public void reservarVolta(Cliente cliente, Reserva ida, Reserva volta) {
        cliente.reservarVolta(ida, volta);
    }

    public List<Reserva> mostrarReservas(String cpfCliente) {
        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpfCliente)) {      //Encontra o cliente pelo cpf
                return cliente.getReservas();               //Retorna as reservas do cliente
            }
                
        }
        return null;    //Se não encontrar, retorna null
    }

    public List<Cliente> mostrarClientes() {
        return clientes;
    }

    public List<Cidade> mostrarCidades() {
        return cidades;
    }
}
