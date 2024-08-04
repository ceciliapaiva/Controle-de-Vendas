package service;

import arquivos.FileService;
import models.Produto;
import models.ProdutosPreDefinidos;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class ProdutoService implements Serializable{
    private static final Logger logger = Logger.getLogger(ProdutoService.class.getName());

    FileService fileService = new FileService();
    File file = new File("src/arquivos/produtos.txt");
    Map<String, Produto> mapProdutos = new HashMap<>();
    Map<String, Produto> produtosRecuperados = new HashMap<>();

    // construtor
    public ProdutoService() throws IOException {
        for (ProdutosPreDefinidos produto : ProdutosPreDefinidos.values()){
            Produto novoProduto = new Produto(produto.getDescricao(), produto.isMaisDezoito(), produto.getPreco());
            mapProdutos.put(novoProduto.getDescricao(), novoProduto);
        }
        mapProdutos.putAll(recuperaProdutos());
    }

    // salvar produto no file
    public void cadastrarProdutoNovo(String desc, boolean maisDezoito, double preco) throws IOException {
        //cria produto novo
        Produto produto = new Produto(desc, maisDezoito, preco);
        mapProdutos.put(produto.getDescricao(), produto);

        fileService.salvarObjetoEmTXT(file, mapProdutos);
    }

    // Ler arquivo de produtos
    public Map<String, Produto> recuperaProdutos() throws IOException {
        Map<String, Produto> produtosRecuperados = FileService.recuperarObjetoDeTXT(file);
        return produtosRecuperados;
    }

    // getters e setters
    public Map<String, Produto> getMapProdutos() {
        return mapProdutos;
    }
}
