
package ifsuldeminas.Ecommerce;
import jakarta.persistence.*;

@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    private Carrinhodecompras carrinho;

    @ManyToOne
    private Estoque estoque;
    private double total;

    public String confirmaEstoque(){
        return finalizarPedido();
    }
    public Pedido(long id,Carrinhodecompras carrinho) {
        this.id=id;
        this.carrinho = carrinho;
        this.total = carrinho.getTotal();
    }

    private String finalizarPedido() {
        System.out.println("Pedido finalizado. Total: " + total);
        return null;
    }
}
