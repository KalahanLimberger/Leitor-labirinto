import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Labirinto labirinto = new Labirinto();

        try {
            labirinto.criaLabirinto("resources/labirinto.txt");
            System.out.println("Imprimindo labirinto:");
            labirinto.imprimeLabirinto();

            if (labirinto.percorreLabirinto()) {
                System.out.println("\nExiste uma saída do labirinto!");
                labirinto.imprimeLabirinto();
            } else {
                System.out.println("Labirinto sem saída!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
