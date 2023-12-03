package ifsuldeminas.Ecommerce.model.services;
import ifsuldeminas.Ecommerce.exception.EstoqueNotFoundException;
import ifsuldeminas.Ecommerce.model.Carrinhodecompras;
import ifsuldeminas.Ecommerce.model.repositores.CarrinhodecomprasRepository;
import ifsuldeminas.Ecommerce.exception.CarrinhodecomprasNotFoundException;
import java.util.List;
import java.util.Optional;
public class CarrinhodecomprasService {
    private CarrinhodecomprasRepository carrinhodecomprasRepository;

    public CarrinhodecomprasService(CarrinhodecomprasRepository carrinhodecomprasRepository){
        this.carrinhodecomprasRepository = carrinhodecomprasRepository;
    }

    public Carrinhodecompras save(Carrinhodecompras carrinhodecompras){
        return carrinhodecomprasRepository.save(carrinhodecompras);
    }

    public List<Carrinhodecompras> list(){
        return this.carrinhodecomprasRepository.findAll();
    }

    public Carrinhodecompras getById(Long id) throws CarrinhodecomprasNotFoundException {
        Optional<Carrinhodecompras> opt = carrinhodecomprasRepository.findById(id);
        if(!opt.isPresent()){
            throw new CarrinhodecomprasNotFoundException(id);
        }
        return opt.get();
    }

    public Carrinhodecompras update(Long id, Carrinhodecompras carrinhodecompras) throws CarrinhodecomprasNotFoundException{
        Carrinhodecompras carrinhodecomprasAux = this.getById(id);
        carrinhodecomprasAux.setItens(carrinhodecompras.getItens());
        carrinhodecomprasAux.setTotal(carrinhodecompras.getTotal());
        carrinhodecomprasAux.setUsuario(carrinhodecompras.getUsuario());
        return carrinhodecomprasRepository.save(carrinhodecomprasAux);
    }

    public void deleteById(Long id) throws CarrinhodecomprasNotFoundException{
        if(!this.carrinhodecomprasRepository.existsById(id)){
            throw new EstoqueNotFoundException(id);
        }
        this.carrinhodecomprasRepository.deleteById(id);
    }
}
