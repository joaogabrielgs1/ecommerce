
package ifsuldeminas.Ecommerce;
import jakarta.persistence.*;
@Entity
public class avaliacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String texto;
    private int classificacao;

    @ManyToOne
    private Usuario usuario;

    @ManyToOne
    private Item produto;

    public avaliacao(String texto, int classificacao, Usuario usuario, Item produto) {
        this.texto = texto;
        this.classificacao = classificacao;
        this.usuario = usuario;
        this.produto = produto;
    }

    public void avaliar() {
        System.out.println("Avaliacao registrada com sucesso.");
    }
}
