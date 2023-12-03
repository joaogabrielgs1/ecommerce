package ifsuldeminas.Ecommerce.model.services;
import ifsuldeminas.Ecommerce.model.Item;
import ifsuldeminas.Ecommerce.model.repositores.ItemRepository;
import ifsuldeminas.Ecommerce.exception.ItemNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
public class ItemService {
    private ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository){
        this.itemRepository = itemRepository;
    }

    public Item save(Item item){
        return itemRepository.save(item);
    }

    public List<Item> list(){
        return this.itemRepository.findAll();
    }

    public Item getById(Long id) throws ItemNotFoundException {
        Optional<Item> opt = itemRepository.findById(id);
        if(!opt.isPresent()){
            throw new ItemNotFoundException(id);
        }
        return opt.get();
    }

    public Item update(Long id, Item item) throws ItemNotFoundException{
        Item itemAux = this.getById(id);
        itemAux.setNome(item.getNome());
        itemAux.setPreco(item.getPreco());
        return itemRepository.save(itemAux);
    }

    public void deleteById(Long id) throws ItemNotFoundException{
        if(!this.itemRepository.existsById(id)){
            throw new ItemNotFoundException(id);
        }
        this.itemRepository.deleteById(id);
    }
}
