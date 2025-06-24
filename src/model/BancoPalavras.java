package model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

public class BancoPalavras {
    private List<String> palavras;
    private Random random;

    public BancoPalavras(String arquivoPalavras) throws IOException {
        this.palavras = Files.readAllLines(Paths.get(arquivoPalavras));
        this.random = new Random();
    }

    public String getPalavraAleatoria() {
        return palavras.get(random.nextInt(palavras.size())).toUpperCase();
    }
}