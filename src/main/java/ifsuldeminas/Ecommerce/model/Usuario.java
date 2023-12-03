
package ifsuldeminas.Ecommerce.model;
import jakarta.persistence.*;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    private String nome;
    private String email;
    private String senha;
    private String endereco;

    // Construtor
    public Usuario(long id,String nome, String email, String senha, String endereco) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.endereco = endereco;
    }

    public void cadastrar() {
        System.out.println("Usuario cadastrado com sucesso.");
    }

    public void atualizarPerfil(long novoId,String novoNome, String novoEmail, String novaSenha, String novoEndereco) {
        this.id=novoId;
        this.nome = novoNome;
        this.email = novoEmail;
        this.senha = novaSenha;
        this.endereco = novoEndereco;
        System.out.println("Perfil atualizado com sucesso.");
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
