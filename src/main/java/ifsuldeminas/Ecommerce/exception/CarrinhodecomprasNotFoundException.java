package ifsuldeminas.Ecommerce.exception;

public class CarrinhodecomprasNotFoundException extends RuntimeException{
    public CarrinhodecomprasNotFoundException(Long id){
        super("Carrinho de compras #" + id + " não encontrado");
    }
}
