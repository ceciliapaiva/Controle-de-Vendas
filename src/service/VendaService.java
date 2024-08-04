package service;

import arquivos.FileService;
import models.Produto;
import models.Venda;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class VendaService {

    File file = new File("src/arquivos/vendas.txt");
    FileService fileService = new FileService();
    private Map<Produto, Venda> vendasEfetuadas;

    public VendaService() {
        this.vendasEfetuadas = new HashMap<>();
    }

    public void efetuarVenda(int quant, Produto produto) {
        Venda venda;venda = new Venda(quant, produto);
        vendasEfetuadas.put(venda.getProduto(), venda);
    }

    public void salvarVenda() throws IOException {
        fileService.salvarObjetoEmTXT(file, vendasEfetuadas);
    }

}
