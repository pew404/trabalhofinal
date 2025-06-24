package model;

import java.util.HashSet;
import java.util.Set;

public class JogoForca {
    private String palavra;
    private Set<Character> letrasTentadas;
    private int tentativasRestantes;
    private char[] palavraAtual;
    private Jogador jogador;
    private boolean jogoAtivo;

    public JogoForca(String palavra, Jogador jogador, int maxTentativas) {
        this.palavra = palavra.toUpperCase();
        this.jogador = jogador;
        this.tentativasRestantes = maxTentativas;
        this.letrasTentadas = new HashSet<>();
        this.palavraAtual = new char[palavra.length()];
        this.jogoAtivo = true;

        for (int i = 0; i < palavraAtual.length; i++) {
            palavraAtual[i] = '_';
        }
    }

    public boolean tentarLetra(char letra) {
        letra = Character.toUpperCase(letra);

        if (letrasTentadas.contains(letra)) {
            return false;
        }

        letrasTentadas.add(letra);
        boolean acertou = false;

        for (int i = 0; i < palavra.length(); i++) {
            if (palavra.charAt(i) == letra) {
                palavraAtual[i] = letra;
                acertou = true;
            }
        }

        if (!acertou) {
            tentativasRestantes--;
        }

        if (tentativasRestantes == 0 || palavra.equals(String.valueOf(palavraAtual))) {
            jogoAtivo = false;
        }

        return acertou;
    }

    public String getEstado() {
        return String.valueOf(palavraAtual);
    }

    public Set<Character> getLetrasErradas() {
        Set<Character> erradas = new HashSet<>();
        for (char c : letrasTentadas) {
            if (palavra.indexOf(c) == -1) {
                erradas.add(c);
            }
        }
        return erradas;
    }

    public boolean isJogoAtivo() {
        return jogoAtivo;
    }

    public boolean isVitoria() {
        return palavra.equals(String.valueOf(palavraAtual));
    }

    public int getTentativasRestantes() {
        return tentativasRestantes;
    }

    public String getPalavra() {
        return palavra;
    }

    public Jogador getJogador() {
        return jogador;
    }
}