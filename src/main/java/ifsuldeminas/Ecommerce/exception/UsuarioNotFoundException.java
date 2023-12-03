package ifsuldeminas.Ecommerce.exception;

public class UsuarioNotFoundException extends RuntimeException{
    public UsuarioNotFoundException(Long id){
        super("Usuario #" + id + " não encontrado");
    }
}
