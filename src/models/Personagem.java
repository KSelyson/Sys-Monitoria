package models;

//superClasse (classe pai)
public class Personagem {
    //atributos
    private String nome;
    private int vida;

    //get e set de nome
    public String getNome() {
        return this.nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    //get e set de vida
    public int getVida() {
        return this.vida;
    }
    public void setVida(int vida) {
        this.vida = vida;
    }

    //metodo que permite que o personagem ataque
    public void atacar(){
        System.out.println("O personagem atacou");
    }
}
