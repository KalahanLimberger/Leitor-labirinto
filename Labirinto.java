import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Labirinto {
    private char[][] labirinto;
    private int linhas;
    private int colunas;

    // construtor sem parâmetros
    public Labirinto() {

    }

    public void criaLabirinto(String filename) throws IOException {
        // BufferedReader para leitura de arquivo e FileReader para a leitura dos caracteres dentro de "filename"
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String linha = br.readLine();
            if (linha == null) {
                throw new IllegalArgumentException("O arquivo está vazio.");
            }

            linhas = 0;
            colunas = linha.length();

            StringBuilder sb = new StringBuilder();
            do {
                sb.append(linha).append("\n");
                linhas++;
            } while ((linha = br.readLine()) != null);

            labirinto = new char[linhas][colunas];
            String[] linhasArray = sb.toString().split("\n");
            for (int i = 0; i < linhas; i++) {
                labirinto[i] = linhasArray[i].toCharArray();
            }
        }
    }

    public boolean percorreLabirinto() {
        return percorreLabirinto(0, 0);
    }

    private boolean percorreLabirinto(int x, int y) {
        // verifica se a posição atual está dentro dos limites e é um caminho aberto ou a saída
        if (x >= 0 && y >= 0 && x < labirinto.length && y < labirinto[0].length && 
            (labirinto[x][y] == ' ' || labirinto[x][y] == 'D')) {
                // veririca se é a saída
                if (labirinto[x][y] == 'D') {
                    return true;
                }

                // marca o caminho atual como parte da solução
                labirinto[x][y] = '+';

                // movimentando-se dentro do labirinto
                if (percorreLabirinto(x - 1, y) || //move para cima
                    percorreLabirinto(x + 1, y) || // move para baixo
                    percorreLabirinto(x, y - 1) || // move para a esquerda
                    percorreLabirinto(x, y + 1)) { // move para a direita
                        return true;
                    }

                // caso não for encontrado nenhuma solução a partir do ponto atual, retrocede com backtrack remarcando o caminho com ' '
                labirinto[x][y] = ' ';
            }
            return false;
    }

    public void imprimeLabirinto() {
        for (char[] linha : labirinto) {
            for (char celula : linha) {
                System.out.print(celula + " ");
            }
            System.out.println();
        }
    }
}
