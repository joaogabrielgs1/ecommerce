package ifsuldeminas.Ecommerce.controller;
import ifsuldeminas.Ecommerce.model.Pedido;
import ifsuldeminas.Ecommerce.model.Usuario;
import ifsuldeminas.Ecommerce.model.services.PedidoService;
import ifsuldeminas.Ecommerce.model.services.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    private UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    //operacao Create
    @PostMapping
    public Usuario save(@Valid @RequestBody Usuario usuario){
        return this.usuarioService.save(usuario);
    }

    //operacao Read
    @GetMapping
    public List<Usuario> list(){
        return this.usuarioService.list();
    }

    @GetMapping("/{id}")
    public ResponseEntity show(@PathVariable Long id){
        Usuario usuario = this.usuarioService.getById(id);
        return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
    }

    //operacao Updade
    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable Long id, @Valid @RequestBody Usuario usuario){
        return new ResponseEntity<Pedido>((MultiValueMap<String, String>) this.usuarioService.update(id, usuario),
                HttpStatus.OK);
    }

    //operacao Delete
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        this.usuarioService.deleteById(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
