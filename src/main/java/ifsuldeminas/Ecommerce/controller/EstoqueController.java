package ifsuldeminas.Ecommerce.controller;
import ifsuldeminas.Ecommerce.model.Estoque;
import ifsuldeminas.Ecommerce.model.services.EstoqueService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/estoque")
public class EstoqueController {

    private EstoqueService estoqueService;

    public EstoqueController(EstoqueService estoqueService){
        this.estoqueService = estoqueService;
    }

    //operacao Create
    @PostMapping
    public Estoque save(@Valid @RequestBody Estoque estoque){
        return this.estoqueService.save(estoque);
    }

    //operacao Read
    @GetMapping
    public List<Estoque> list(){
        return this.estoqueService.list();
    }

    @GetMapping("/{id}")
    public ResponseEntity show(@PathVariable Long id){
        Estoque estoque = this.estoqueService.getById(id);
        return new ResponseEntity<Estoque>(estoque, HttpStatus.OK);
    }

    //operacao Updade
    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable Long id, @Valid @RequestBody Estoque estoque){
        return new ResponseEntity<Estoque>((MultiValueMap<String, String>) this.estoqueService.update(id, estoque),
                HttpStatus.OK);
    }

    //operacao Delete
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        this.estoqueService.deleteById(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
