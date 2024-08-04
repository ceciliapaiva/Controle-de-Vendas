package models;

import service.GeradorDeCod;

import java.io.Serializable;

public class Produto implements Serializable {
    private static final long serialVersionUID = 1l;

    private long cod;
    private String descricao;
    private boolean maisDezoito;
    private double preco;
    GeradorDeCod geradorCod = new GeradorDeCod();

    public Produto(String descricao, boolean maisDezoito, double preco) {
        this.cod = geradorCod.gerarCod();
        this.descricao = descricao;
        this.maisDezoito = maisDezoito;
        this.preco = preco;
    }

    public long getCod() {
        return cod;
    }

    public String getDescricao() {
        return descricao;
    }

    public boolean getMaisDezoito() {
        return maisDezoito;
    }

    public double getPreco() {
        return preco;
    }

    public void setCod(long cod) {
        this.cod = cod;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setMaisDezoito(boolean maisDezoito) {
        this.maisDezoito = maisDezoito;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "cod=" + cod +
                ", descricao='" + descricao + '\'' +
                ", mais18='" + maisDezoito + '\'' +
                ", preco=" + preco +
                '}';
    }
}
