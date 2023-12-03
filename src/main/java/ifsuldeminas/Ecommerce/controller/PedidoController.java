package ifsuldeminas.Ecommerce.controller;
import ifsuldeminas.Ecommerce.model.Pedido;
import ifsuldeminas.Ecommerce.model.services.PedidoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/pedido")
public class PedidoController {
    private PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService){
        this.pedidoService = pedidoService;
    }

    //operacao Create
    @PostMapping
    public Pedido save(@Valid @RequestBody Pedido pedido){
        return this.pedidoService.save(pedido);
    }

    //operacao Read
    @GetMapping
    public List<Pedido> list(){
        return this.pedidoService.list();
    }

    @GetMapping("/{id}")
    public ResponseEntity show(@PathVariable Long id){
        Pedido pedido = this.pedidoService.getById(id);
        return new ResponseEntity<Pedido>(pedido, HttpStatus.OK);
    }

    //operacao Updade
    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable Long id, @Valid @RequestBody Pedido pedido){
        return new ResponseEntity<Pedido>(this.pedidoService.update(id, pedido),
                HttpStatus.OK);
    }

    //operacao Delete
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        this.pedidoService.deleteById(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
