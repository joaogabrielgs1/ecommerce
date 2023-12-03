
package ifsuldeminas.Ecommerce.model;

import java.util.HashMap;
import java.util.Map;
import jakarta.persistence.*;

@Entity
public class Estoque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ElementCollection
    @CollectionTable(name = "estoque_produtos", joinColumns = @JoinColumn(name = "estoque_id"))
    @MapKeyColumn(name = "nome_produto")
    @Column(name = "quantidade")
    private Map<String, Integer> produtos;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Map<String, Integer> getProdutos() {
        return produtos;
    }

    public void setProdutos(Map<String, Integer> produtos) {
        this.produtos = produtos;
    }

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
