package ifsuldeminas.Ecommerce.controller;
import ifsuldeminas.Ecommerce.model.Carrinhodecompras;
import ifsuldeminas.Ecommerce.model.Estoque;
import ifsuldeminas.Ecommerce.model.Item;
import ifsuldeminas.Ecommerce.model.services.CarrinhodecomprasService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/carrinhodecompras")
public class CarrinhodecomprasController {
    private CarrinhodecomprasService carrinhodecomprasService;

    public CarrinhodecomprasController(CarrinhodecomprasService carrinhodecomprasService){
        this.carrinhodecomprasService = carrinhodecomprasService;
    }

    //operacao Create
    @PostMapping
    public Carrinhodecompras save(@Valid @RequestBody Carrinhodecompras estoque){
        return this.carrinhodecomprasService.save(estoque);
    }

    //operacao Read
    @GetMapping
    public List<Carrinhodecompras> list(){
        return this.carrinhodecomprasService.list();
    }

    @GetMapping("/{id}")
    public ResponseEntity show(@PathVariable Long id){
        Carrinhodecompras carrinhodecompras = this.carrinhodecomprasService.getById(id);
        return new ResponseEntity<Estoque>((MultiValueMap<String, String>) carrinhodecompras, HttpStatus.OK);
    }

    //operacao Updade
    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable Long id, @Valid @RequestBody Carrinhodecompras estoque){
        return new ResponseEntity<Item>((MultiValueMap<String, String>) this.carrinhodecomprasService.update(id, estoque),
                HttpStatus.OK);
    }

    //operacao Delete
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        this.carrinhodecomprasService.deleteById(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
