package models;

public enum ProdutosPreDefinidos {
    PRODUTO1("produto1", true, 15.0),
    PRODUTO2("produto2", false, 5.0);

    String descricao;
    boolean maisDezoito;
    double preco;

    ProdutosPreDefinidos(String descricao, boolean maisDezoito, double preco) {
        this.descricao = descricao;
        this.maisDezoito = maisDezoito;
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public boolean isMaisDezoito() {
        return maisDezoito;
    }

    public double getPreco() {
        return preco;
    }
}
