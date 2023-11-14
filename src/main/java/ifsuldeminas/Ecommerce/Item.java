
package ifsuldeminas.Ecommerce;
import jakarta.persistence.*;

@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
     private String nome;
    private double preco;

    public Item(long id,String nome, double preco) {
        this.id=id;
        this.nome = nome;
        this.preco = preco;
    }
    public long getId(){return  id; }
    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }
}
