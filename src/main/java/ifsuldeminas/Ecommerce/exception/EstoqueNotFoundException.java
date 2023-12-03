package ifsuldeminas.Ecommerce.exception;

public class EstoqueNotFoundException extends RuntimeException{
    public EstoqueNotFoundException(Long id){
        super("Estoque #" + id + " não encontrado");
    }
}
