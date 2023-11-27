import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarrinhodecomprasTest {

    @Test
    public void testAdicionarItem() {
        Usuario usuario = new Usuario("NomeUsuario");
        Carrinhodecompras carrinho = new Carrinhodecompras(usuario);
        Item item = new Item("ItemTeste", 10.0);

        carrinho.adicionarItem(item, 2);

        assertEquals(2, carrinho.getItens().get(item));
        assertEquals(20.0, carrinho.getTotal());
    }

    @Test
    public void testRemoverItem() {
        Usuario usuario = new Usuario("NomeUsuario");
        Carrinhodecompras carrinho = new Carrinhodecompras(usuario);
        Item item = new Item("ItemTeste", 10.0);

        carrinho.adicionarItem(item, 3);
        carrinho.removerItem(item, 2);

        assertEquals(1, carrinho.getItens().get(item));
        assertEquals(10.0, carrinho.getTotal());
    }

    @Test
    public void testVisualizarCarrinho() {
        Usuario usuario = new Usuario("NomeUsuario");
        Carrinhodecompras carrinho = new Carrinhodecompras(usuario);
        Item item = new Item("ItemTeste", 10.0);
        carrinho.adicionarItem(item, 2);

        // Redirecionar a saída padrão para capturar a impressão no console
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        carrinho.visualizarCarrinho();

        // Restaurar a saída padrão
        System.setOut(System.out);

        // Verificar se a saída está correta
        assertEquals("Carrinho de Compras de NomeUsuario\nItemTeste - Quantidade: 2 - Preço unitário: 10.0\nTotal: 20.0\n", outContent.toString());
    }
}
