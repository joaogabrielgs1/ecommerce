
package ifsuldeminas.Ecommerce;

public class Pedido {
    private Carrinhodecompras carrinho;
    private double total;

    public Pedido(Carrinhodecompras carrinho) {
        this.carrinho = carrinho;
        this.total = carrinho.getTotal();
    }

    public void finalizarPedido() {
        System.out.println("Pedido finalizado. Total: " + total);
    }
}
