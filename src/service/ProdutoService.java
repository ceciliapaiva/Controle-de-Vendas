package service;

import models.Produto;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class ProdutoService implements Serializable{
    private static final Logger logger = Logger.getLogger(ProdutoService.class.getName());
    File file = new File("src/arquivos/produtos.txt");
    List<Produto> listaProdutos = new ArrayList<>();

    // salvar produto no file
    public void cadastrarProdutoNovo(String desc, String classif, double preco){
        //cria produto novo
        Produto produto = new Produto(desc, classif, preco);
        listaProdutos.add(produto);

        try { // tenta criar o arquivo
            file.createNewFile();
            logger.info("Arquivo " + file.getPath() + " criado");

            // tenta escrever produto
            try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))){
                out.writeObject(listaProdutos);
                logger.info("Produto slavo com sucesso no arquivo: " + file.getPath());
            }catch (IOException e){
                logger.severe("Error ao salvar o produto: " + e.getMessage());
                e.printStackTrace();
            }
        }catch (IOException e){
            logger.severe("Ocorreu error ao criar o arquivo: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Ler arquvo de produtos
    public List<Produto> recuperaProdutos() {

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))){

            logger.info("Lista de produtos recuperada: ");
            List<Produto> produtosRecuperados = (List<Produto>) in.readObject();
            logger.info(produtosRecuperados.toString());
            listaProdutos.addAll(produtosRecuperados);

        } catch (IOException | ClassNotFoundException e) {
            logger.severe("Erro ao ler a lista de produtos: " + e.getMessage());
            e.printStackTrace();
        }
        return listaProdutos;
    }

}
