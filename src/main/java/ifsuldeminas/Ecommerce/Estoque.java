
package ifsuldeminas.Ecommerce;

import java.util.HashMap;
import java.util.Map;


public class Estoque {
      private Map<String, Integer> produtos;

    public Estoque() {
        produtos = new HashMap<>();
    }

    public void adicionarProduto(String nomeProduto, int quantidade) {
        produtos.put(nomeProduto, quantidade);
    }

    public boolean verificarDisponibilidade(String nomeProduto, int quantidade) {
        if (produtos.containsKey(nomeProduto)) {
            return produtos.get(nomeProduto) >= quantidade;
        }
        return false;
    }
}
