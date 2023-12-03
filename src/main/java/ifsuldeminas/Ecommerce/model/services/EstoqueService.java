package ifsuldeminas.Ecommerce.model.services;
import ifsuldeminas.Ecommerce.exception.EstoqueNotFoundException;
import ifsuldeminas.Ecommerce.model.Estoque;
import ifsuldeminas.Ecommerce.model.repositores.EstoqueRepository;
import ifsuldeminas.Ecommerce.exception.EstoqueNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
public class EstoqueService {
    private EstoqueRepository estoqueRepository;

    public EstoqueService(EstoqueRepository estoqueRepository){
        this.estoqueRepository = estoqueRepository;
    }

    public Estoque save(Estoque estoque){
        return estoqueRepository.save(estoque);
    }

    public List<Estoque> list(){
        return this.estoqueRepository.findAll();
    }

    public Estoque getById(Long id) throws EstoqueNotFoundException {
        Optional<Estoque> opt = estoqueRepository.findById(id);
        if(!opt.isPresent()){
            throw new EstoqueNotFoundException(id);
        }
        return opt.get();
    }

    public Estoque update(Long id, Estoque estoque) throws EstoqueNotFoundException{
        Estoque estoqueAux = this.getById(id);
        estoqueAux.setProdutos(estoque.getProdutos());
        return estoqueRepository.save(estoqueAux);
    }

    public void deleteById(Long id) throws EstoqueNotFoundException{
        if(!this.estoqueRepository.existsById(id)){
            throw new EstoqueNotFoundException(id);
        }
        this.estoqueRepository.deleteById(id);
    }

}
