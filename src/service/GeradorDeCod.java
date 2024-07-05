package service;

import java.io.Serializable;
import java.util.Random;

public class GeradorDeCod implements Serializable {
    Random random = new Random();
    int tamanhoCod = 6;
    int codigo;

    public int gerarCod() {
        for (int i = 0; i <= tamanhoCod; i++) {
            codigo = random.nextInt(10000);
        }
        return codigo;
    }
}
