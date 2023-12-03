
package ifsuldeminas.Ecommerce.model;
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

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Carrinhodecompras getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(Carrinhodecompras carrinho) {
        this.carrinho = carrinho;
    }

    public Estoque getEstoque() {
        return estoque;
    }

    public void setEstoque(Estoque estoque) {
        this.estoque = estoque;
    }

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
