import models.Produto;
import service.ProdutoService;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        ProdutoService produtoService1 = new ProdutoService();
        produtoService1.cadastrarProdutoNovo("Suco", false, 8.00);
        produtoService1.cadastrarProdutoNovo("Cerveja", true, 5.00);


        for (Produto product : produtoService1.getMapProdutos().values()){
            System.out.println(product);
        }
    }
}