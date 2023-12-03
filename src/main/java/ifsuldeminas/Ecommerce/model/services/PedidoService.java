package ifsuldeminas.Ecommerce.model.services;
import ifsuldeminas.Ecommerce.model.Pedido;
import ifsuldeminas.Ecommerce.model.repositores.PedidoRepository;
import ifsuldeminas.Ecommerce.exception.PedidoNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class PedidoService {
    private PedidoRepository pedidoRepository;

    public PedidoService(PedidoRepository pedidoRepository){
        this.pedidoRepository = pedidoRepository;
    }

    public Pedido save(Pedido produto){
        return pedidoRepository.save(produto);
    }

    public List<Pedido> list(){
        return this.pedidoRepository.findAll();
    }

    public Pedido getById(Long id) throws PedidoNotFoundException{
        Optional<Pedido> opt = pedidoRepository.findById(id);
        if(!opt.isPresent()){
            throw new PedidoNotFoundException(id);
        }
        return opt.get();
    }

    public Pedido update(Long id, Pedido produto) throws PedidoNotFoundException{
        Pedido produtoAux = this.getById(id);
        produtoAux.setCarrinho(produto.getCarrinho());
        produtoAux.setEstoque(produto.getEstoque());
        produtoAux.setTotal(produto.getTotal());
        return pedidoRepository.save(produtoAux);
    }

    public void deleteById(Long id) throws PedidoNotFoundException{
        if(!this.pedidoRepository.existsById(id)){
            throw new PedidoNotFoundException(id);
        }
        this.pedidoRepository.deleteById(id);
    }
}
