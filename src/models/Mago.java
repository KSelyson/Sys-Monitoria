package models;

import javax.swing.*;

public class Mago extends Personagem{
    //atributo especifico de mago
    private int mana;

    //construtor do mago
    public Mago(String nome) {
        this.setNome(nome);
        this.setVida(35);
        this.mana = 50;
    }

    //get e set de mana
    public int getMana() {
        return mana;
    }
    public void setMana(int mana) {
        this.mana += mana;
    }

    //sobreescrita do metodo atacar
    @Override
    public void atacar(){
        JOptionPane.showMessageDialog(null, "O Mago conjurou um ataque mágico!");
        this.setMana(-5);
    }

    //toString para facilitar a visualização
    @Override
    public String toString() {
        return "Classe: Mago | Nome: " + this.getNome() + " | Vida: " + this.getVida() + " | Mana: " + this.getMana();
    }
}
