
package ifsuldeminas.Ecommerce;
import jakarta.persistence.*;

@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    private Carrinhodecompras carrinho;

    private double total;

    public Pedido(long id,Carrinhodecompras carrinho) {
        this.id=id;
        this.carrinho = carrinho;
        this.total = carrinho.getTotal();
    }

    public void finalizarPedido() {
        System.out.println("Pedido finalizado. Total: " + total);
    }
}
