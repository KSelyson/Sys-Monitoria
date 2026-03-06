package models;

import javax.swing.*;

public class Guerreiro extends Personagem{
    //atributo especifico de Guerreiro
    private int stamina;

    //construtor do guerreiro
    public Guerreiro(String nome) {
        this.setNome(nome);
        this.setVida(50);
        this.stamina = 30;
    }

    //get e set de stamina
    public int getStamina() {
        return stamina;
    }
    public void setStamina(int stamina) {
        this.stamina += stamina;
    }

    //sobreescrita do metodo atacar
    @Override
    public void atacar(){
        JOptionPane.showMessageDialog(null, "O Guerreiro emitiu um ataque físico!");
        this.setStamina(-5);
    }

    //toString para facilitar a visualização
    @Override
    public String toString() {
        return "Classe: Guerreiro | Nome: " + this.getNome() + " | Vida: " + this.getVida() + " | Stamina: " + this.getStamina();
    }
}
