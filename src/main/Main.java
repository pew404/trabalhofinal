package main;

import java.io.IOException;
import model.BancoPalavras;
import model.Jogador;
import model.JogoForca;
import view.ForcaUI;

public class Main {
    public static void main(String[] args) {
        try {
            BancoPalavras banco = new BancoPalavras("data/palavras.txt");
            ForcaUI ui = new ForcaUI();

            boolean jogarNovamente = true;

            while (jogarNovamente) {
                String nome = ui.lerNomeJogador();
                Jogador jogador = new Jogador(nome);
                String palavra = banco.getPalavraAleatoria();
                JogoForca jogo = new JogoForca(palavra, jogador, 6);

                while (jogo.isJogoAtivo()) {
                    ui.mostrarEstado(jogo);
                    char letra = ui.lerLetra();

                    if (!jogo.tentarLetra(letra) && !jogo.getLetrasErradas().contains(letra)) {
                        ui.mostrarMensagem("Letra já tentada!");
                    }
                }

                ui.mostrarResultado(jogo);
                jogarNovamente = ui.perguntarNovoJogo();
            }

            ui.mostrarMensagem("Obrigado por jogar!");
        } catch (IOException e) {
            System.err.println("Erro ao carregar palavras: " + e.getMessage());
        }
    }
}