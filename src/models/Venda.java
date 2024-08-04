package models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Venda {

    // Cliente - há criar
    private LocalDateTime data;
    private int quantidade;
    private Produto produto;
    private double valorTotal;

    public Venda(int quantidade, Produto produto) {
        this.data = LocalDateTime.now();
        this.quantidade = quantidade;
        this.produto = produto;
        this.valorTotal = quantidade * produto.getPreco();
    }

    // getters
    public String getDataFormatada(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return data.format(formatter);
    }

    public LocalDateTime getData() {
        return data;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    @Override
    public String toString() {
        return "Venda{" +
                "data=" + getDataFormatada() +
                ", quantidade=" + quantidade +
                ", produto=" + produto +
                ", valorTotal=" + valorTotal +
                '}';
    }
}
