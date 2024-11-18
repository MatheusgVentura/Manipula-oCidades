import java.util.*;

class Cidade implements Comparable<Cidade> {
    private String nome;
    private String uf;
    private boolean capital;

    public Cidade(String nome, String uf, boolean capital) {
        this.nome = nome;
        this.uf = uf;
        this.capital = capital;
    }

    public String getNome() {
        return nome;
    }

    public String getUf() {
        return uf;
    }

    public boolean isCapital() {
        return capital;
    }

    @Override
    public String toString() {
        return nome + " - " + uf + (capital ? " (Capital)" : "");
    }

    @Override
    public int compareTo(Cidade outra) {
        return this.nome.compareTo(outra.nome);
    }
}


