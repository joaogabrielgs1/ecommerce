package ifsuldeminas.Ecommerce.controller;
import ifsuldeminas.Ecommerce.model.Avaliacao;
import ifsuldeminas.Ecommerce.model.services.AvaliacaoService;
import ifsuldeminas.Ecommerce.model.services.EstoqueService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/avaliacao")
public class AvaliacaoController {
    private AvaliacaoService avaliacaoService;

    public AvaliacaoController(EstoqueService estoqueService){
        this.avaliacaoService = avaliacaoService;
    }

    //operacao Create
    @PostMapping
    public Avaliacao save(@Valid @RequestBody Avaliacao avaliacao){
        return this.avaliacaoService.save(avaliacao);
    }

    //operacao Read
    @GetMapping
    public List<Avaliacao> list(){
        return this.avaliacaoService.list();
    }

    @GetMapping("/{id}")
    public ResponseEntity show(@PathVariable Long id){
        Avaliacao avaliacao = this.avaliacaoService.getById(id);
        return new ResponseEntity<Avaliacao>(avaliacao, HttpStatus.OK);
    }

    //operacao Updade
    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable Long id, @Valid @RequestBody Avaliacao avaliacao){
        return new ResponseEntity<Avaliacao>((MultiValueMap<String, String>) this.avaliacaoService.update(id, avaliacao),
                HttpStatus.OK);
    }

    //operacao Delete
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        this.avaliacaoService.deleteById(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
