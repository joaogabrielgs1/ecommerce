
package ifsuldeminas.Ecommerce;


public class avaliacao {
    private String texto;
    private int classificacao; // Pode ser um valor de 1 a 5, por exemplo
    private Usuario usuario;
    private Item produto;

    public avaliacao(String texto, int classificacao, Usuario usuario, Item produto) {
        this.texto = texto;
        this.classificacao = classificacao;
        this.usuario = usuario;
        this.produto = produto;
    }

    public void avaliar() {
        // Implemente aqui a l�gica para registrar a avalia��o no sistema.
        System.out.println("Avalia��o registrada com sucesso.");
    }
}
