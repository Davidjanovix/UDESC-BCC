package br.udesc.pratica2.dados;

public class SistemaPetShop {
    
    private Veterinario[] veterinarios = new Veterinario[50];
    private int quantidadeVeterinarios = 0;


    //Setters

    public void setQuantidadeVeterinarios(int quantidadeVeterinarios) {
        this.quantidadeVeterinarios = quantidadeVeterinarios;
    }


    //Getters

    public Veterinario getVeterinario(int num){
        if (num >= 0 && num < quantidadeVeterinarios) { //Verifica se o número é válido e se existe um veterinário na posição
            return veterinarios[num];
        } else {
            return null;
        }
    }

    public Veterinario[] getVeterinarios(){
        return veterinarios;
    }
    
    public int getQuantidadeVeterinarios(){
        return quantidadeVeterinarios;
    }
}
