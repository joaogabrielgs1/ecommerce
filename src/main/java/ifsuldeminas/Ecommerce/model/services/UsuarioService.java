package ifsuldeminas.Ecommerce.model.services;
import ifsuldeminas.Ecommerce.exception.PedidoNotFoundException;
import ifsuldeminas.Ecommerce.model.Usuario;
import ifsuldeminas.Ecommerce.model.repositores.UsuarioRepository;
import ifsuldeminas.Ecommerce.exception.UsuarioNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
public class UsuarioService {
    private UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario save(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> list(){
        return this.usuarioRepository.findAll();
    }

    public Usuario getById(Long id) throws UsuarioNotFoundException {
        Optional<Usuario> opt = usuarioRepository.findById(id);
        if(!opt.isPresent()){
            throw new UsuarioNotFoundException(id);
        }
        return opt.get();
    }

    public Usuario update(Long id, Usuario usuario) throws UsuarioNotFoundException{
        Usuario usuarioAux = this.getById(id);
        usuarioAux.setNome(usuario.getNome());
        usuarioAux.setSenha(usuario.getSenha());
        usuarioAux.setEndereco(usuario.getEndereco());
        usuarioAux.setEmail(usuario.getEmail());
        return usuarioRepository.save(usuarioAux);
    }

    public void deleteById(Long id) throws UsuarioNotFoundException{
        if(!this.usuarioRepository.existsById(id)){
            throw new PedidoNotFoundException(id);
        }
        this.usuarioRepository.deleteById(id);
    }

}
