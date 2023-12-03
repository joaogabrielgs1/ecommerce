package ifsuldeminas.Ecommerce.model.services;
import ifsuldeminas.Ecommerce.exception.AvaliacaoNotFoundException;
import ifsuldeminas.Ecommerce.model.Avaliacao;
import ifsuldeminas.Ecommerce.model.repositores.AvaliacaoRepository;

import java.util.List;
import java.util.Optional;
public class AvaliacaoService {

    private AvaliacaoRepository avaliacaoRepository;

    public AvaliacaoService(AvaliacaoRepository avaliacaoRepository){
        this.avaliacaoRepository = avaliacaoRepository;
    }

    public Avaliacao save(Avaliacao avaliacao){
        return avaliacaoRepository.save(avaliacao);
    }

    public List<Avaliacao> list(){
        return this.avaliacaoRepository.findAll();
    }

    public Avaliacao getById(Long id) throws AvaliacaoNotFoundException {
        Optional<Avaliacao> opt = avaliacaoRepository.findById(id);
        if(!opt.isPresent()){
            throw new AvaliacaoNotFoundException(id);
        }
        return opt.get();
    }

    public Avaliacao update(Long id, Avaliacao avaliacao) throws AvaliacaoNotFoundException{
        Avaliacao avaliacaoAux = this.getById(id);
        avaliacaoAux.setProduto(avaliacao.getProduto());
        avaliacaoAux.setClassificacao(avaliacao.getClassificacao());
        avaliacaoAux.setTexto(avaliacao.getTexto());
        avaliacaoAux.setUsuario(avaliacao.getUsuario());
        return avaliacaoRepository.save(avaliacao);
    }

    public void deleteById(Long id) throws AvaliacaoNotFoundException{
        if(!this.avaliacaoRepository.existsById(id)){
            throw new AvaliacaoNotFoundException(id);
        }
        this.avaliacaoRepository.deleteById(id);
    }
}
