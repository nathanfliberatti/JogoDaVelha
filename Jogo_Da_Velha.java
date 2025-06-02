import java.util.Random;
import java.util.Scanner;

public class Jogo_Da_Velha {

    public static int menu() {
        Scanner input = new Scanner(System.in);

        System.out.println("-------------------------");
        System.out.println("|*--- Escolha o modo---*|");
        System.out.println("|1  Jogador vs Jogador  |");
        System.out.println("|2  Jogador vs Maquina  |");
        System.out.println("|3       Créditos       |");
        System.out.println("|4         Sair         |");
        System.out.println("-------------------------");
        System.out.print  ("         Opção: ");

        return input.nextInt();
    }

    public static int creditos (int opcao) {

        System.out.println("\n\nJogo feito por:");
        System.out.println("Erick Yuji");
        System.out.println("Gabriel Lima");
        System.out.println("Marcos Boé");
        System.out.println("Nathan Liberatti");

        System.out.println("AgredecimentoS a matéria Algoritimos e Programação que nos permitiu aprender tanto!\n\n");

        return opcao;
    }

    public static char[][] tabuleiro() {
        char[][] tab = {
                { ' ', ' ', ' ' },
                { ' ', ' ', ' ' },
                { ' ', ' ', ' ' }
        };

        return tab;
    }
    

    public static void imprimirTabuleiro(char[][] tab) {
        System.out.println("-------------"); 
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(tab[i][j] + " | ");
            }
            System.out.println(); 
            System.out.println("-------------"); 
        }
    }

    public static char[][] jogada(char[][] tab, char jogadorAtual, char jogadorUm, char jogadorDois) {
    Scanner input = new Scanner(System.in);

    
    if (jogadorAtual == jogadorUm) {
        System.out.println("É a vez do Jogador 1 (" + jogadorUm + ")!");
    } else if (jogadorAtual == jogadorDois) { // Adicionando essa condi��o para deixar claro que � o Jogador 2
        System.out.println("É a vez do Jogador 2 (" + jogadorDois + ")!");
    }
    // Para o modo Jogador vs M�quina, 'jogadorAtual' ser� o s�mbolo 'O',


    int linha, coluna;

    while(true) {
        System.out.print("Linha (0-2): "); // Instru��o mais clara para o usu�rio
        linha = input.nextInt();
        System.out.print("Coluna (0-2): "); // Instru��o mais clara para o usu�rio
        coluna = input.nextInt();

        // Verifica se a jogada � v�lida (dentro dos limites e em uma casa vazia)
        if (linha >= 0 && linha <= 2 && coluna >= 0 && coluna <= 2 && tab[linha][coluna] == ' ') {
            tab[linha][coluna] = jogadorAtual; // O s�mbolo do jogador atual marca a casa
            break; 
        } else {
            System.out.println("Jogada inválida! Tente novamente.");
            imprimirTabuleiro(tab); // Imprime o tabuleiro novamente para que o jogador veja e tente outra jogada
        }
    }

    return tab;
}

    public static char[][] primeiraJogadaPC(char[][] tab, char maquina) {
        Random random = new Random();

        int linha = random.nextInt(3);
        int coluna = random.nextInt(3);

        while (true) {
            if (linha >= 0 && linha <= 2 && coluna >= 0 && coluna <= 2 && tab[linha][coluna] == ' ') {
                tab[linha][coluna] = maquina;
                break;
            }
        }

        imprimirTabuleiro(tab);
        return tab;
    }

    public static char [][] jogadaMaquina(char[][] tab, char jogador, char maquina){

        // 1. L�GICA PARA A M�QUINA VENCER (ATACAR)
        // Horizontal
        if (tab[0][0] == maquina && tab [0][1] == maquina && tab[0][2] == ' ') {
            tab[0][2] = maquina;
            return tab;
        } else if (tab[0][1] == maquina && tab [0][2] == maquina && tab[0][0] == ' ') {
            tab[0][0] = maquina;
            return tab;
        } else if (tab[0][0] == maquina && tab [0][2] == maquina && tab[0][1] == ' ') {
            tab[0][1] = maquina;
            return tab;
        }

        else if (tab[1][0] == maquina && tab [1][1] == maquina && tab[1][2] == ' ') {
            tab[1][2] = maquina;
            return tab;
        } else if (tab[1][1] == maquina && tab [1][2] == maquina && tab[1][0] == ' ') {
            tab[1][0] = maquina;
            return tab;
        } else if (tab[1][0] == maquina && tab [1][2] == maquina && tab[1][1] == ' ') {
            tab[1][1] = maquina;
            return tab;
        }

        else if (tab[2][0] == maquina && tab [2][1] == maquina && tab[2][2] == ' ') {
            tab[2][2] = maquina;
            return tab;
        } else if (tab[2][0] == maquina && tab [2][2] == maquina && tab[2][1] == ' ') {
            tab[2][1] = maquina;
            return tab;
        } else if (tab[2][1] == maquina && tab [2][2] == maquina && tab[2][0] == ' ') {
            tab[2][0] = maquina;
            return tab;
        }

        // Vertical
        else if (tab[0][0] == maquina && tab [1][0] == maquina && tab[2][0] == ' ') {
            tab[2][0] = maquina;
            return tab;
        } else if (tab[1][0] == maquina && tab [2][0] == maquina && tab[0][0] == ' ') {
            tab[0][0] = maquina;
            return tab;
        } else if (tab[0][0] == maquina && tab [2][0] == maquina && tab[1][0] == ' ') {
            tab[1][0] = maquina;
            return tab;
        }                

        else if (tab[0][1] == maquina && tab [1][1] == maquina && tab[2][1] == ' ') {
            tab[2][1] = maquina;
            return tab;
        } else if (tab[1][1] == maquina && tab [2][1] == maquina && tab[0][1] == ' ') {
            tab[0][1] = maquina;
            return tab;
        } else if (tab[0][1] == maquina && tab [2][1] == maquina && tab[1][1] == ' ') {
            tab[1][1] = maquina;
            return tab;
        }

        else if (tab[0][2] == maquina && tab [1][2] == maquina && tab[2][2] == ' ') {
            tab[2][2] = maquina;
            return tab;
        } else if (tab[1][2] == maquina && tab [2][2] == maquina && tab[0][2] == ' ') {
            tab[0][2] = maquina;
            return tab;
        } else if (tab[0][2] == maquina && tab [2][2] == maquina && tab[1][2] == ' ') {
            tab[1][2] = maquina;
            return tab;
        }
        
        // Diagonal
        else if (tab[0][0] == maquina && tab [2][2] == maquina && tab[1][1] == ' ') {
            tab[1][1] = maquina;
            return tab;
        } else if (tab[0][0] == maquina && tab [1][1] == maquina && tab[2][2] == ' ') {
            tab[2][2] = maquina;
            return tab;
        } else if (tab[1][1] == maquina && tab [2][2] == maquina && tab[0][0] == ' ') {
            tab[0][0] = maquina;
            return tab;
        } 

        else if (tab[2][0] == maquina && tab [0][2] == maquina && tab[1][1] == ' ') {
            tab[1][1] = maquina;
            return tab;
        } else if (tab[0][2] == maquina && tab [1][1] == maquina && tab[2][0] == ' ') {
            tab[2][0] = maquina;
            return tab;
        } else if (tab[2][0] == maquina && tab [1][1] == maquina && tab[0][2] == ' ') {
            tab[0][2] = maquina;
            return tab;
        }


        // 2. L�GICA PARA A M�QUINA SE DEFENDER (BLOQUEAR O JOGADOR)
        // Horizontal
        else if (tab[0][0] == jogador && tab [0][1] == jogador && tab[0][2] == ' ') {
            tab[0][2] = maquina;
            return tab;
        } else if (tab[0][1] == jogador && tab [0][2] == jogador && tab[0][0] == ' ') {
            tab[0][0] = maquina;
            return tab;
        } else if (tab[0][0] == jogador && tab [0][2] == jogador && tab[0][1] == ' ') {
            tab[0][1] = maquina;
            return tab;
        }

        else if (tab[1][0] == jogador && tab [1][1] == jogador && tab[1][2] == ' ') {
            tab[1][2] = maquina;
            return tab;
        } else if (tab[1][1] == jogador && tab [1][2] == jogador && tab[1][0] == ' ') { 
            tab[1][0] = maquina;
            return tab;
        } else if (tab[1][0] == jogador && tab [1][2] == jogador && tab[1][1] == ' ') {
            tab[1][1] = maquina;
            return tab;
        }

        else if (tab[2][0] == jogador && tab [2][1] == jogador && tab[2][2] == ' ') {
            tab[2][2] = maquina;
            return tab;
        } else if (tab[2][0] == jogador && tab [2][2] == jogador && tab[2][1] == ' ') {
            tab[2][1] = maquina;
            return tab;
        } else if (tab[2][1] == jogador && tab [2][2] == jogador && tab[2][0] == ' ') {
            tab[2][0] = maquina;
            return tab;
        }

        // Vertical
        else if (tab[0][0] == jogador && tab [1][0] == jogador && tab[2][0] == ' ') {
            tab[2][0] = maquina;
            return tab;
        } else if (tab[1][0] == jogador && tab [2][0] == jogador && tab[0][0] == ' ') {
            tab[0][0] = maquina;
            return tab;
        } else if (tab[0][0] == jogador && tab [2][0] == jogador && tab[1][0] == ' ') {
            tab[1][0] = maquina;
            return tab;
        }                

        else if (tab[0][1] == jogador && tab [1][1] == jogador && tab[2][1] == ' ') {
            tab[2][1] = maquina;
            return tab;
        } else if (tab[1][1] == jogador && tab [2][1] == jogador && tab[0][1] == ' ') {
            tab[0][1] = maquina;
            return tab;
        } else if (tab[0][1] == jogador && tab [2][1] == jogador && tab[1][1] == ' ') {
            tab[1][1] = maquina;
            return tab;
        }

        else if (tab[0][2] == jogador && tab [1][2] == jogador && tab[2][2] == ' ') {
            tab[2][2] = maquina;
            return tab;
        } else if (tab[1][2] == jogador && tab [2][2] == jogador && tab[0][2] == ' ') {
            tab[0][2] = maquina;
            return tab;
        } else if (tab[0][2] == jogador && tab [2][2] == jogador && tab[1][2] == ' ') {
            tab[1][2] = maquina;
            return tab;
        }
        
        // Diagonal
        else if (tab[0][0] == jogador && tab [2][2] == jogador && tab[1][1] == ' ') {
            tab[1][1] = maquina;
            return tab;
        } else if (tab[0][0] == jogador && tab [1][1] == jogador && tab[2][2] == ' ') {
            tab[2][2] = maquina;
            return tab;
        } else if (tab[1][1] == jogador && tab [2][2] == jogador && tab[0][0] == ' ') {
            tab[0][0] = maquina;
            return tab;
        } 

        else if (tab[2][0] == jogador && tab [0][2] == jogador && tab[1][1] == ' ') {
            tab[1][1] = maquina;
            return tab;
        } else if (tab[0][2] == jogador && tab [1][1] == jogador && tab[2][0] == ' ') {
            tab[2][0] = maquina;
            return tab;
        } else if (tab[2][0] == jogador && tab [1][1] == jogador && tab[0][2] == ' ') {
            tab[0][2] = maquina;
            return tab;
        }

        // 3. L�GICA PARA JOGADA ESTRAT�GICA OU ALEAT�RIA
        // Tenta o centro
        else if (tab[1][1] == ' ') {
            tab[1][1] = maquina;
            return tab;
        }

        // Tenta os cantos
        else if (tab[0][0] == ' ') {
            tab[0][0] = maquina;
            return tab;
        }
        else if (tab[0][2] == ' ') {
            tab[0][2] = maquina;
            return tab;
        }
        else if (tab[2][0] == ' ') {
            tab[2][0] = maquina;
            return tab;
        }
        else if (tab[2][2] == ' ') {
            tab[2][2] = maquina;
            return tab;
        }

        // Se tudo mais falhar (tabuleiro quase cheio ou apenas laterais vazias),
        // joga na primeira casa vazia encontrada
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tab[i][j] == ' ') {
                    tab[i][j] = maquina;
                    return tab;
                }
            }
        }

        return tab;
    }

    public static int verificarVitoria(char[][] tab, char jogadorAtual, int opcao) {

        int contador = 1;
        // Verificar Horizontais
        for(int i = 0; i < 3; i++) {
            
            if (tab[i][0] == tab[i][1] && tab[i][0] == tab[i][2] && tab[i][0] != ' ') { // Varre todas as verticais e valida se os todos os simbolos s�o iguais
                System.out.println("\n\n\n\n\n\n"); 
                imprimirTabuleiro(tab);                                                 /*Ap�s validar que o campo do jogo est� totalmente preenchido 
                                                                                         com os mesmos s�mbolos, valida qual om s�mbolo para atribuir vit�ria.*/
                                                                                         // Jogador: X - M�quina: O  
                                                                                         // Jogador1: x - Jogador2: O               
                if (opcao == 1 && tab[i][0] == 'O'){
                    System.out.println("Jogador 2 ('O') venceu!");                      //
                } else 
                if(opcao == 1 && tab[i][0] == 'X'){
                    System.out.println("Jogador 1 ('X') venceu!");
                }else 
                if(opcao == 2 && tab[i][0] == 'O'){
                    System.out.println("A M�quina venceu!");
                }else 
                if(opcao == 2 && tab[i][0] == 'X'){
                    System.out.println("Voc� venceu a M�quina, jogador!");
                }
                return 1; // 1 para indicar que o jogo terminou na Main
            }
        }

        // Verificar Verticais
        for(int j = 0; j < 3; j++) {
        
            if (tab[0][j] == tab[1][j] && tab[0][j] == tab[2][j] && tab[0][j] != ' ') { 
                System.out.println("\n\n\n\n\n\n");
                imprimirTabuleiro(tab);
                
                if (opcao == 1 && tab[0][j] == 'O'){
                    System.out.println("Jogador 2 ('O') venceu!");
                } else 
                if(opcao == 1 && tab[0][j] == 'X'){
                    System.out.println("Jogador 1 ('X') venceu!");
                }else 
                if(opcao == 2 && tab[0][j] == 'O'){
                    System.out.println("A M�quina venceu!");
                }else 
                if(opcao == 2 && tab[0][j] == 'X'){
                    System.out.println("Voc� venceu a M�quina, jogador!");
                }
                
                return 1; 
            }
        }

            // Verificar Diagonais
            // Diagonal principal (canto superior esquerdo para inferior direito)
            if (tab[0][0] == tab[1][1] && tab[0][0] == tab[2][2] && tab[0][0] != ' ') {
                System.out.println("\n\n\n\n\n\n");
                imprimirTabuleiro(tab);
                
                if (opcao == 1 && tab[0][0] == 'O'){
                    System.out.println("Jogador 2 ('O') venceu!");
                } else 
                if(opcao == 1 && tab[0][0] == 'X'){
                    System.out.println("Jogador 1 ('X') venceu!");
                }else 
                if(opcao == 2 && tab[0][0] == 'O'){
                    System.out.println("A M�quina venceu!");
                }else 
                if(opcao == 2 && tab[0][0] == 'X'){
                    System.out.println("Voc� venceu a M�quina, jogador!");
                }
                return 1;
            }

            // Diagonal secund�ria (canto superior direito para inferior esquerdo)
            if (tab[0][2] == tab[1][1] && tab[0][2] == tab[2][0] && tab[0][2] != ' ') {
                System.out.println("\n\n\n\n\n\n");
                imprimirTabuleiro(tab);
                
                if (opcao == 1 && tab[0][2] == 'O'){
                    System.out.println("Jogador 2 ('O') venceu!");
                } else 
                if(opcao == 1 && tab[0][2] == 'X'){
                    System.out.println("Jogador 1 ('X') venceu!");
                }else 
                if(opcao == 2 && tab[0][2] == 'O'){
                    System.out.println("A M�quina venceu!");
                }else 
                if(opcao == 2 && tab[0][2] == 'X'){
                    System.out.println("Voc� venceu a M�quina, jogador!");
                }
                return 1;
            }

            // 4. Verificar Empate (somente se nenhuma vit�ria foi detectada at� agora)
            int casasPreenchidas = 0;
            for(int l = 0; l < 3; l++){
                for(int c = 0; c < 3; c++){
                    if (tab[l][c] != ' ') {
                        casasPreenchidas++;
                    }
                }
            }

            if (casasPreenchidas == 9) { // Se todas as 9 casas est�o preenchidas e ningu�m ganhou
                System.out.println("\n\n\n\n\n\n");
                imprimirTabuleiro(tab);
                System.out.println("Deu velha!\n");
                return 1; // Jogo terminou em empate
            }

            //Se nenhuma vit�ria ou empate foi detectado, o jogo continua
            return 0; 
        }
        

    /*--------------------------------------------------------------------------------------------------------------------------------- */



    public static void main(String[] args) {

        int parada = 0;
        char jogador1 = 'X';
        char jogador2 = 'O';
        char jogadorAtual = jogador1;
        char [][] tab = tabuleiro();

        int opcao = 0;

         while(opcao != 4) {
            opcao = menu();
            switch(opcao) {
                case 1:
                    tab = tabuleiro();
                    do {
                        imprimirTabuleiro(tab);

                        // Chama jogada passando o jogador atual e os s�mbolos fixos dos jogadores 1 e 2
                        jogada(tab, jogadorAtual, jogador1, jogador2);

                        // Verifica se houve vit�ria, derrota ou empate
                        parada = verificarVitoria(tab, jogadorAtual,opcao); 

                        if (parada == 0) { 
                    
                        if (jogadorAtual == jogador1) {
                            jogadorAtual = jogador2;
                        } else {
                            jogadorAtual = jogador1;
                        }
                        System.out.println("Vez de " + jogadorAtual); // Informa o pr�ximo jogador
                        }

                    } while (parada == 0);
                    break;

                case 2:                        
                    tab = tabuleiro();
                    imprimirTabuleiro(tab);
                    tab = jogada(tab, jogadorAtual,jogador1,jogador2);
                    tab = primeiraJogadaPC(tab, jogador2);
                    do{    
                        tab = jogada(tab, jogadorAtual,jogador1,jogador2);
                        tab = jogadaMaquina(tab, jogador1, jogador2);
                        imprimirTabuleiro(tab);
                        parada = verificarVitoria(tab, jogadorAtual,opcao);
                    }while (parada == 0);

                    System.out.print("\n\n\n\n");
                    break;

                case 3:
                    creditos(opcao);
                    break;

                case 4: 
                    System.out.println("Voce escolheu sair!");
                    System.exit(0);
                default:
                    System.out.print("Opcao invalida. Escolha outra opcao:");
            }

                
                
        

        }
    }
}