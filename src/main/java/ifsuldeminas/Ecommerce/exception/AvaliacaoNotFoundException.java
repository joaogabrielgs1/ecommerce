package ifsuldeminas.Ecommerce.exception;

public class AvaliacaoNotFoundException extends RuntimeException{
    public AvaliacaoNotFoundException(Long id){
        super("Avaliacao #" + id + " não encontrado");
    }
}
