package ifsuldeminas.Ecommerce.exception;

public class ItemNotFoundException extends RuntimeException{
    public ItemNotFoundException(Long id){
        super("Item #" + id + " não encontrado");
    }
}
