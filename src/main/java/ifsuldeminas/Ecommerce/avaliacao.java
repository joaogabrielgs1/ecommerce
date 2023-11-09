
package ifsuldeminas.Ecommerce;


public class avaliacao {
    private String texto;
    private int classificacao;
    private Usuario usuario;
    private Item produto;

    public avaliacao(String texto, int classificacao, Usuario usuario, Item produto) {
        this.texto = texto;
        this.classificacao = classificacao;
        this.usuario = usuario;
        this.produto = produto;
    }

    public void avaliar() {
        System.out.println("Avaliacao registrada com sucesso.");
    }
}
