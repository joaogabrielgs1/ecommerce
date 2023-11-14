
package ifsuldeminas.Ecommerce;

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
