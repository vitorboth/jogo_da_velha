public class Jogador {

    private String nomeJogador;
    int pontosJogador;

    public Jogador(String nomeJogador) {
        this.nomeJogador = nomeJogador;
        System.out.println("\nNome digitado: " + nomeJogador);
        pontosJogador = 0;
    }

    public String getNomeJogador() {
        return nomeJogador;
    }

    public int getPontosJogador(){
        return pontosJogador;
    }

    public void setNomeJogador(String nomeJogador) {
        this.nomeJogador = nomeJogador;
    }

    public void setPontosJogador(int pontosJogador) {
        this.pontosJogador = pontosJogador;
    }

    @Override
    public String toString() {
        return "\nPONTUAÇÃO: \n" + "Nome do jogador: " + nomeJogador + "\n" + "Pontos do jogador: " + pontosJogador + "\n";
    }
}
