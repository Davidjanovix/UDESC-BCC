package br.udesc.pratica2.dados;


public class Veterinario {
    private String nome;
    private float salario;
    private int quantidadeAnimais;
    private Endereco endereco;
    private Animal[] animais;



    //Construtor

    public Veterinario(String nome, float salario, int quantidadeAnimais) {
        this.nome = nome;
        this.salario = salario;
        this.quantidadeAnimais = quantidadeAnimais;
        this.animais = new Animal[quantidadeAnimais];
    }


    // Setters

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public void setQuantidadeAnimais(int quantidadeAnimais) {
        this.quantidadeAnimais = quantidadeAnimais;
    }

    public String getNome() {
        return nome;
    }
    
    public float getSalario() {
        return salario;
    }

    public Endereco getEndereco() {
        return endereco;
    }
    
    
    //Getters

    public int getQuantidadeAnimais() {
        return quantidadeAnimais;
    }

    public int quantidadeAnimaisCadastrados(){
        int i = 0;
        for (Animal animal : animais) {
            if (animal != null) {
                i++;
            }
        }
        return i;
    }
    
    public Animal[] getAnimais() {
        return animais;     
    }

    public Animal getAnimal(int numero){
        if (numero >= 0 && numero <quantidadeAnimais) {
            return animais[numero];
        } else {
            return null;
        }
    }

    public Dono getDono(int numeroAnimal){
        return animais[numeroAnimal].getDono();
    }


    //Factory

    public void cadastrarAnimal(int numero, String nome, String especie, String descricao) {

        this.animais[numero] = new Animal(nome, especie, descricao);
        
    }
}
