package arquivos;

import java.io.*;
import java.util.Map;
import java.util.logging.Logger;

public class FileService {
    private static final Logger logger = Logger.getLogger(FileService.class.getName());

    public void salvarObjetoEmTXT(File file, Object objeto) throws IOException {
        try { // tenta criar o arquivo
            if (!file.exists()){
                file.createNewFile();
                logger.info("Arquivo " + file.getPath() + " criado");
            }

            // tenta escrever produto
            try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))){
                out.writeObject(objeto);
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

    public static <K, V> Map<K, V> recuperarObjetoDeTXT(File file) throws IOException {
        Map<K, V> map = null;

        if (!file.exists() || file.length() == 0){
            throw new IOException("O arquivo esta vazio ou não existe");
        }

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))){

            logger.info("Lista de produtos recuperada: ");
            map = (Map<K, V>) in.readObject();
            logger.info(map.toString());

        } catch (IOException | ClassNotFoundException e) {
            logger.severe("Erro ao ler a lista de produtos: " + e.getMessage());
            e.printStackTrace();
        }
        return map;
    }

}
