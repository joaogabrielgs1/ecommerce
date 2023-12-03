package ifsuldeminas.Ecommerce.exception;

public class PedidoNotFoundException extends RuntimeException{
    public PedidoNotFoundException(Long id){
        super("Pedido #" + id + " não encontrado");
    }
}
