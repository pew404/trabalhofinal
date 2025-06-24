package view;

import java.util.Scanner;
import model.JogoForca;

public class ForcaUI {
    private Scanner scanner;

    public ForcaUI() {
        this.scanner = new Scanner(System.in);
    }

    public String lerNomeJogador() {
        System.out.print("Digite seu nome: ");
        return scanner.nextLine();
    }

    public char lerLetra() {
        System.out.print("Digite uma letra: ");
        return scanner.nextLine().toUpperCase().charAt(0);
    }

    public void mostrarEstado(JogoForca jogo) {
        System.out.println("\n--- Jogo da Forca ---");
        System.out.println("Jogador: " + jogo.getJogador().getNome());
        System.out.println("Palavra: " + jogo.getEstado());
        System.out.println("Letras erradas: " + jogo.getLetrasErradas());
        System.out.println("Tentativas restantes: " + jogo.getTentativasRestantes());
    }

    public void mostrarResultado(JogoForca jogo) {
        if (jogo.isVitoria()) {
            System.out.println("\nParabéns! Você acertou a palavra: " + jogo.getPalavra());
        } else {
            System.out.println("\nGame Over! A palavra era: " + jogo.getPalavra());
        }
    }

    public boolean perguntarNovoJogo() {
        System.out.print("\nDeseja jogar novamente? (S/N): ");
        return scanner.nextLine().equalsIgnoreCase("S");
    }

    public void mostrarMensagem(String mensagem) {
        System.out.println(mensagem);
    }
}