package ifsuldeminas.Ecommerce.controller;
import ifsuldeminas.Ecommerce.model.Item;
import ifsuldeminas.Ecommerce.model.Pedido;
import ifsuldeminas.Ecommerce.model.services.ItemService;
import ifsuldeminas.Ecommerce.model.services.PedidoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/item")
public class ItemController {

    private ItemService itemService;

    public ItemController(ItemService itemService){
        this.itemService = itemService;
    }

    //operacao Create
    @PostMapping
    public Item save(@Valid @RequestBody Item item){
        return this.itemService.save(item);
    }

    //operacao Read
    @GetMapping
    public List<Item> list(){
        return this.itemService.list();
    }

    @GetMapping("/{id}")
    public ResponseEntity show(@PathVariable Long id){
        Item item = this.itemService.getById(id);
        return new ResponseEntity<Item>(item, HttpStatus.OK);
    }

    //operacao Updade
    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable Long id, @Valid @RequestBody Item item){
        return new ResponseEntity<Item>(this.itemService.update(id, item),
                HttpStatus.OK);
    }

    //operacao Delete
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        this.itemService.deleteById(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
