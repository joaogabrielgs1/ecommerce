
package ifsuldeminas.Ecommerce.model;
import jakarta.persistence.*;
@Entity
public class Avaliacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String texto;
    private int classificacao;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public int getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(int classificacao) {
        this.classificacao = classificacao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Item getProduto() {
        return produto;
    }

    public void setProduto(Item produto) {
        this.produto = produto;
    }

    @ManyToOne
    private Usuario usuario;

    @ManyToOne
    private Item produto;

    public Avaliacao(String texto, int classificacao, Usuario usuario, Item produto) {
        this.texto = texto;
        this.classificacao = classificacao;
        this.usuario = usuario;
        this.produto = produto;
    }

    public void avaliar() {
        System.out.println("Avaliacao registrada com sucesso.");
    }
}
