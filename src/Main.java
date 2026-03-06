import models.Guerreiro;
import models.Mago;
import models.Personagem;

import javax.swing.*;
import java.util.*;

public class Main {
    // lista dos personagens criados
    static ArrayList<Personagem> personagens = new ArrayList<>();

    public static void main(String[] args) {
        // string com o menu para maior legibilidade
        String menu = """
                SysRPG!
                
                1 - Criar Guerreiro
                2 - Criar Mago
                3 - Listar personagens e executar ataque
                
                0 - Sair
                """;

        int opcao;

        do {
            // Captura de exceção caso o cliente feche o programa
            try{
                String opcaoStr = JOptionPane.showInputDialog(menu);
                opcao = Integer.parseInt(opcaoStr);

                //switch case para a funcionalidade do menu
                switch (opcao) {
                    case 1: criarGuerreiro(); break;
                    case 2: criarMago(); break;
                    case 3: listarPersonagens(); break;
                    case 0: JOptionPane.showMessageDialog(null, "Obrigado por utilizar o programa!"); System.exit(0);
                    default: JOptionPane.showMessageDialog(null, "Insira um valor valido!"); break;
                }
                // caso o cliente feche o joptionpane com o botão de cancelar, ele captura a exceção e fecha normalmente sem erro
            } catch (NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Obrigado por utilizar o programa!");
                System.exit(0);
            }
        } while (true);
    }

    //--------------------------------------------------------------------------------------------------------//

    //toda a logica da opção 1
    public static void criarGuerreiro(){
        String msg = """
                Tela do Personagem - Lvl 1
                
                Seu Guerreiro vai começar com 50 de vida e 30 de Stamina!
                
                Qual o nome do seu Guerreiro?
                """;
        String nome = JOptionPane.showInputDialog(msg);

        //tratamento de erro
        if (nome == null || nome.length() < 3 || nome.length() > 30) {
            JOptionPane.showMessageDialog(null, "Insira um nome valido! Acima de 3 e dentro de 30 caracteres.");
        } else {
            // caso passe, o codigo roda normalmente
            Guerreiro novoGuerreiro = new Guerreiro(nome);
            personagens.add(novoGuerreiro); //salva na lista

            JOptionPane.showMessageDialog(null, "Guerreiro criado com sucesso!");
        }
    }
    //toda a logica da opção 2
    public static void criarMago(){
        String msg = """
                Tela do Personagem - Lvl 1
                
                Seu Mago vai começar com 35 de vida e 50 de mana!
                
                Qual o nome do seu Mago?
                """;
        String nome = JOptionPane.showInputDialog(msg);

        //tratamento para caso o cliente coloque um valor estranho/invalido
        if (nome == null || nome.length() < 3 || nome.length() > 30) {
            JOptionPane.showMessageDialog(null, "Insira um valor valido! Acima de 3 e dentro de 30 caracteres.");
        } else {
            //caso o nome passe da condicional, o codigo roda normalmente
            Mago novoMago = new Mago(nome);
            personagens.add(novoMago); // salva na lista

            JOptionPane.showMessageDialog(null, "Mago criado com sucesso!");
        }
    }
    //toda a logica da opção 3
    public static void listarPersonagens(){

        //se não estiver vazia ele continua normalmente
        if (!personagens.isEmpty()) {
            //StringBuilder pra facilitar a concatenação da lista
            StringBuilder Apresentacao = new StringBuilder("""
                    | Lista de Personagens |
                    \n
                    """);
            for (Personagem personagem : personagens) {
                Apresentacao.append(personagem).append("\n");
            }

            String opcaoPersona = JOptionPane.showInputDialog(Apresentacao + "\n Qual personagem deve atacar? (escreva o nome dele)");

            // utilizo stream pra conseguir utilizar os lambdas
            personagens.stream()
                    .filter(personagem -> personagem.getNome().equals(opcaoPersona)) //filtro para encontrar personagem com o mesmo nome
                    .findFirst() // Aqui ele pega o primeiro que o filtro encontrar (O ideal seria utilizar um hashmap pra não permitir duplicatas na lista, mas deixei arrayList msm pq comecei assim
                    .ifPresentOrElse( // Como a stream capturou um com o FindFisrt, da pra usar esse metodo de condicional para tratamento de erros
                            Personagem::atacar,
                            () -> JOptionPane.showMessageDialog(null, "Não existe personagem com esse nome.")
                    );
        } else {
            //se a lista estiver vazia ele retorna
            JOptionPane.showMessageDialog(null, "Nenhuma personagem foi encontrada!");
        }
    }
}