public class Principal {

    public static void main(String[] args) {
        int linha;
        int coluna;
        char caractere;
        int empate = 0;
        int jogarNovamente=0;

        Jogador jogadorA = new Jogador(Teclado.leString("Digite o nome do primeiro jogador: "));
        Jogador jogadorB = new Jogador(Teclado.leString("Digite o nome do segundo jogador: "));

        String nomeA = jogadorA.getNomeJogador();
        String nomeB = jogadorB.getNomeJogador();

        int pontosA = jogadorA.getPontosJogador();
        int pontosB = jogadorB.getPontosJogador();


        int tamanho = Teclado.leInt("Digite a dimensão do tabuleiro entre 3 e 10: ");
        while (tamanho < 3 || tamanho > 10) {
            System.out.println("\nTAMANHO DO TABULEIRO INVÁLIDO");
            tamanho = Teclado.leInt("Digite a dimensão do tabuleiro entre 3 e 10: ");
        }

        do {
            JogoDaVelha jogo = new JogoDaVelha(tamanho);
            jogo.exibeTabuleiro();

            System.out.println(jogadorA.toString());
            System.out.println(jogadorB.toString());

            do {
                System.out.println("\nVez de " + nomeA + ":");
                caractere = 'X';

                linha = Teclado.leInt("Digite a linha da jogada: ");
                coluna = Teclado.leInt("Digite a coluna da jogada: ");
                while ((linha == 0 || linha > tamanho) || (coluna == 0 || coluna > tamanho)) {
                    System.out.println("JOGADA INVÁLIDA, TENTE NOVAMENTE");
                    linha = Teclado.leInt("Digite a linha da jogada: ");
                    coluna = Teclado.leInt("Digite a coluna da jogada: ");
                }

                while (jogo.realizaJogada(linha - 1, coluna - 1, caractere) == false) {
                    System.out.println("JOGADA INVÁLIDA, TENTE NOVAMENTE");
                    linha = Teclado.leInt("Digite a linha da jogada: ");
                    coluna = Teclado.leInt("Digite a coluna da jogada: ");
                    while ((linha == 0 || linha > tamanho) || (coluna == 0 || coluna > tamanho)) {
                        System.out.println("JOGADA INVÁLIDA, TENTE NOVAMENTE");
                        linha = Teclado.leInt("Digite a linha da jogada: ");
                        coluna = Teclado.leInt("Digite a coluna da jogada: ");
                    }
                }
                jogo.exibeTabuleiro();

                if (jogo.verificaGanhador() == false && jogo.verificaEmpate() == false) {
                    System.out.println("\nVez de " + nomeB + ":");
                    caractere = 'O';
                    linha = Teclado.leInt("Digite a linha da jogada: ");
                    coluna = Teclado.leInt("Digite a coluna da jogada: ");
                    while ((linha == 0 || linha > tamanho) || (coluna == 0 || coluna > tamanho)) {
                        System.out.println("JOGADA INVÁLIDA, TENTE NOVAMENTE");
                        linha = Teclado.leInt("Digite a linha da jogada: ");
                        coluna = Teclado.leInt("Digite a coluna da jogada: ");
                    }

                    while (jogo.realizaJogada(linha - 1, coluna - 1, caractere) == false) {
                        System.out.println("JOGADA INVÁLIDA, TENTE NOVAMENTE");
                        linha = Teclado.leInt("Digite a linha da jogada: ");
                        coluna = Teclado.leInt("Digite a coluna da jogada: ");
                        while ((linha == 0 || linha > tamanho) || (coluna == 0 || coluna > tamanho)) {
                            System.out.println("JOGADA INVÁLIDA, TENTE NOVAMENTE");
                            linha = Teclado.leInt("Digite a linha da jogada: ");
                            coluna = Teclado.leInt("Digite a coluna da jogada: ");
                        }
                    }
                    jogo.exibeTabuleiro();
                }

                if (jogo.verificaEmpate() == true && jogo.verificaGanhador() == false) empate = 1;

            } while (jogo.verificaGanhador() == false && jogo.verificaEmpate() == false);

            if (empate == 1) {
                System.out.println("\nEMPATOU A PARTIDA");
                empate = 0;
            } else {
                if (caractere == 'X') {
                    System.out.println("\n" + nomeA + " GANHOU\n");
                    jogadorA.setPontosJogador((++pontosA));
                }

                if (caractere == 'O') {
                    System.out.println("\n" + nomeB + " GANHOU\n");
                    jogadorB.setPontosJogador((++pontosB));
                }
            }

            jogo.exibeTabuleiro();
            System.out.println(jogadorA.toString());
            System.out.println(jogadorB.toString());

            System.out.println("\nDeseja jogar novamente?\n 1-SIM\n 2-NÃO\n");
            jogarNovamente = Teclado.leInt("Selecione uma das opções acima:");

            while(jogarNovamente!=1 && jogarNovamente!=2){
                System.out.println("Opção inválida");
                System.out.println("\nDeseja jogar novamente?\n 1-SIM\n 2-NÃO\n");
                jogarNovamente = Teclado.leInt("Selecione uma das opções acima:");
            }


        }while(jogarNovamente==1);

        System.out.println("\nObrigado por jogar, até a próxima!!");

    }


}
