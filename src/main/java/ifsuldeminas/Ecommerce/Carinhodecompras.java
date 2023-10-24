
package ifsuldeminas.Ecommerce;

import java.util.HashMap;
import java.util.Map;


public class Carinhodecompras {
    private Usuario usuario;
    private Map<Item, Integer> itens;
    private double total;

    public Carinhodecomprass(Usuario usuario) {
        this.usuario = usuario;
        this.itens = new HashMap<>();
        this.total = 0.0;
    }

    public void adicionarItem(Item item, int quantidade) {
        if (itens.containsKey(item)) {
            itens.put(item, itens.get(item) + quantidade);
        } else {
            itens.put(item, quantidade);
        }
        total += item.getPreco() * quantidade;
    }

    public void removerItem(Item item, int quantidade) {
        if (itens.containsKey(item)) {
            int currentQuantity = itens.get(item);
            if (quantidade >= currentQuantity) {
                itens.remove(item);
                total -= item.getPreco() * currentQuantity;
            } else {
                itens.put(item, currentQuantity - quantidade);
                total -= item.getPreco() * quantidade;
            }
        }
    }

    public void visualizarCarrinho() {
        System.out.println("Carrinho de Compras de " + usuario.getNome());
        for (Map.Entry<Item, Integer> entry : itens.entrySet()) {
            Item item = entry.getKey();
            int quantidade = entry.getValue();
            System.out.println(item.getNome() + " - Quantidade: " + quantidade + " - Preço unitário: " + item.getPreco());
        }
        System.out.println("Total: " + total);
    }

    public double getTotal() {
        return total;
    }
}
