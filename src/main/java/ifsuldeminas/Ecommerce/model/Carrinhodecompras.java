
package ifsuldeminas.Ecommerce.model;

import java.util.HashMap;
import java.util.Map;
import jakarta.persistence.*;

@Entity
public class Carrinhodecompras {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    private Usuario usuario;

    @ElementCollection
    @CollectionTable(name = "carrinho_itens", joinColumns = @JoinColumn(name = "carrinho_id"))
    @MapKeyJoinColumn(name = "item_id")
    @Column(name = "quantidade")
    private Map<Item, Integer> itens;

    private double total;

    public Carrinhodecompras(Usuario usuario) {
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
            System.out.println(item.getNome() + " - Quantidade: " + quantidade + " - Pre�o unit�rio: " + item.getPreco());
        }
        System.out.println("Total: " + total);
    }

    public double getTotal() {
        return total;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Map<Item, Integer> getItens() {
        return itens;
    }

    public void setItens(Map<Item, Integer> itens) {
        this.itens = itens;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
