package models;

import service.GeradorDeCod;

import java.io.Serializable;

public class Produto implements Serializable {
    private static final long serialVersionUID = 1l;
    private long cod;
    private String descricao;
    private String classificacao;
    private double preco;
    GeradorDeCod geradorCod = new GeradorDeCod();

    public Produto(String descricao,String classificacao, double preco) {
        this.cod = geradorCod.gerarCod();
        this.descricao = descricao;
        this.classificacao = classificacao;
        this.preco = preco;
    }

    public long getCod() {
        return cod;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getClassificacao() {
        return classificacao;
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

    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "cod=" + cod +
                ", descricao='" + descricao + '\'' +
                ", classificacao='" + classificacao + '\'' +
                ", preco=" + preco +
                '}';
    }
}
