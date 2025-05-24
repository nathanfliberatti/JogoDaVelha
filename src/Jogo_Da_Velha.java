
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author Nathan
 */
public class Jogo_Da_Velha {

    static char[][] tab = {
        {' ', ' ', ' '},
        {' ', ' ', ' '},
        {' ', ' ', ' '}
    };
    
    static char jogador = 'O';
    static int parada = 1;
    static int contadorRodadas = 1;
    
    
    public static int menu() {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Escolha o modo:");
        System.out.println("1 - Jogador vs Jogador");
        System.out.println("2 - Jogador vs Máquina");
        System.out.println("3 - Sair");
        System.out.print("Opção: ");
        
        return input.nextInt();
    }
    
    
    
    public static void imprimirTabuleiro() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(tab[i][j] + " | ");
            }
            System.out.println("\n-------------");
        }
    }
    
    
    public static int verificarJogador() {
        if (jogador == 'O') {
            jogador = 'X';
        } else {
            jogador = 'O';
        }
        System.out.println("Vez de " + jogador);
        return jogador;
    }
    
    
    public static void fazerJogada() {
        Scanner input = new Scanner(System.in);
        
        int linha, coluna;
        
        while(true) { // atribuir quando para o jogo, dps de uma vitoria ou empate
            System.out.println("Linha: ");
            linha = input.nextInt();
            System.out.println("Coluna: ");
            coluna = input.nextInt();
            
            if (linha >= 0 && linha <= 2 && coluna >= 0 && coluna <= 2 && tab[linha][coluna] == ' ') {
                preencherTabuleiro(linha, coluna);
                break;
            } else {
                System.out.println("Jogada invalida! Tente novamente.");
            }
            
            imprimirTabuleiro();
        }
    }
    
    public static char preencherTabuleiro(int linha, int coluna) {
        if (jogador == 0) {
            tab[linha][coluna] = 'O';
        } else {
            tab[linha][coluna] = 'X';
        }
        
        return tab[linha][coluna];
    }
    
    
    public static void verificarVitoria() {
        
        //verificar horizontais
        if (contadorRodadas < 9) {
            for(int i = 0; i < 3; i++) {
                if (tab[i][0] == tab[i][1] && tab[i][0] == tab[i][2] && tab[i][0] != ' ') {
                    System.out.println("\n\n\n\n\n\n");
                    imprimirTabuleiro();       
                    if (jogador == 0) {
                        System.out.println("O 'O' ganhou!");
                    } else {
                        System.out.println("O 'X' ganhou!");
                    }
                    parada = 0;
                }
            }
            
            //verificar verticais
            for(int i = 0; i < 3; i++) {
                if (tab[0][i] == tab[1][i] && tab[0][i] == tab[2][i] && tab[0][i] != ' ') {
                    System.out.println("\n\n\n\n\n\n");
                    imprimirTabuleiro();
                    if (jogador == 0) {
                        System.out.println("O 'O' ganhou!");
                    } else {
                        System.out.println("O 'X' ganhou!");
                    }
                    parada = 0;
                }
            }
            
            //verificar diagonais
            if ((tab[0][0] == tab[1][1] && tab[0][0] == tab[2][2] && tab[0][0] != ' ') || 
                    (tab[0][2] == tab[1][1] && tab[0][2] == tab[2][0] && tab[0][2] != ' ')) {
                System.out.println("\n\n\n\n\n\n");
                imprimirTabuleiro();
                if (jogador == 0) {
                        System.out.println("O 'O' ganhou!");
                    } else {
                        System.out.println("O 'X' ganhou!");
                    }
                parada = 0;
            }
        } else {
            imprimirTabuleiro();
            System.out.println("Empate!");
            parada = 0;
        }
        contadorRodadas++;
    }
    
    
    
    public static void main(String[] args) {
        int opcao = 0;
        
        while(opcao != 3) {
            opcao = menu();
            switch(opcao) {
                case 1:
                    do{
                        imprimirTabuleiro();
                        verificarJogador();
                        fazerJogada();
                        verificarVitoria();
                    } while(parada != 0);
                break;

                case 2:

                break;

                case 3:
                    System.out.println("Voce escolheu sair!");
                break;

                default: 
                    System.out.print("Opcao invalida. Escolha outra opcao:");
            }
        }
    }
}
