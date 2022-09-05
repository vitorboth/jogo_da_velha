import java.util.Arrays;

public class JogoDaVelha {

    private int tamanhoTabuleiro = 0;
    private char [][] tabuleiro;

    public JogoDaVelha(int tamanhoTabuleiro) {
        this.tamanhoTabuleiro = tamanhoTabuleiro;
        this.tabuleiro= new char [tamanhoTabuleiro][tamanhoTabuleiro];
    }

    public int getTamanhoTabuleiro() {
        return tamanhoTabuleiro;
    }

    public void setTamanhoTabuleiro(int tamanhoTabuleiro) {
        this.tamanhoTabuleiro = tamanhoTabuleiro;
    }


    public boolean realizaJogada(int linha, int coluna, char caractere){

        if (tabuleiro[linha][coluna] != 'X' && tabuleiro[linha][coluna] != 'O'){
            tabuleiro[linha][coluna] = caractere;
            return true;
        }

        return false;

    }

    public boolean verificaGanhador(){

        int contaLinhaX = 0;
        int contaLinhaO = 0;
        int contaDiagPX= 0;
        int contaDiagPO = 0;
        int contaDiagSX = 0;
        int contaDiagSO = 0;
        int contaColunaX = 0;
        int contaColunaO = 0;
        int coluna = tamanhoTabuleiro-1;

        for (int i=0; i<tamanhoTabuleiro; i++){

            contaLinhaX=0;
            contaLinhaO = 0;
            contaColunaX = 0;
            contaColunaO = 0;
            //Para verificar a diagonal secudaria, o tamanho da coluna tem q diminuir 1 e o da linha aumentar 1
            if (tabuleiro[i][coluna] == 'X'){//verifica se o jogador X ganhou na diagonal secundaria
                contaDiagSX ++;
                if (contaDiagSX == tamanhoTabuleiro) return true;
            }
            if (tabuleiro[i][coluna] == 'O'){//verifica se o jogador O ganhou na diagonal secundaria
                contaDiagSO ++;
                if (contaDiagSO == tamanhoTabuleiro) return true;
                //Caso a variavel seja do tamanho da dimensão o jogador ganhou
            }
            coluna--;


            for (int j=0; j<tamanhoTabuleiro; j++){

                //verificar se o jogador ganhou na coluna
                if (tabuleiro[j][i] == 'X'){
                    contaColunaX++;
                    if(contaColunaX == tamanhoTabuleiro) return true;
                }
                if (tabuleiro[j][i] == 'O'){
                    contaColunaO++;
                    if(contaColunaO == tamanhoTabuleiro) return true;
                }

                //verifica se o jogador ganhou na linha
                if (tabuleiro[i][j] == 'X'){
                    contaLinhaX++;
                    if(contaLinhaX == tamanhoTabuleiro) return true;
                }
                if (tabuleiro[i][j] == 'O'){
                    contaLinhaO++;
                    if(contaLinhaO == tamanhoTabuleiro) return true;
                }

                //verifica se o jogador ganhou na diagonal principal
                if (i == j){
                    if (tabuleiro[i][j] == 'X'){
                        contaDiagPX++;
                        if(contaDiagPX==tamanhoTabuleiro) return true;
                    }
                    if (tabuleiro[i][j] == 'O'){
                        contaDiagPO++;
                        if(contaDiagPO==tamanhoTabuleiro) return true;
                    }
                }
            }
        }

        return false;
    }

    public boolean verificaEmpate(){
        int contaEmpate=0;
        for (int i=0; i<tamanhoTabuleiro; i++) {
            for (int j=0; j<tamanhoTabuleiro; j++) {

                if (tabuleiro[i][j] == 'X' || tabuleiro[i][j] == 'O'){

                    contaEmpate++;
                }
                if (contaEmpate == (tamanhoTabuleiro*tamanhoTabuleiro)) return true;

            }
        }
        return false;
    }

    public void exibeTabuleiro(){

        for (int i=0; i<tamanhoTabuleiro; i++){
            for(int j=0; j<tamanhoTabuleiro; j++){
                System.out.print(tabuleiro[i][j]);
            }
            System.out.println();
        }


    }

}
