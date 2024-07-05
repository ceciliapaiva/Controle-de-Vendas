import models.Produto;
import service.ProdutoService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ProdutoService produtoService1 = new ProdutoService();

        //produtoService1.cadastrarProdutoNovo("Cerveja", "Com alcool", 5.00);
        List<Produto> p = produtoService1.recuperaProdutos();
        for (Produto pro : p){
            System.out.printf(p.toString());
        }
        //produtoService2.cadastrarProdutoNovo("Cerveja", "Com alcool", 5.00);


    }
}