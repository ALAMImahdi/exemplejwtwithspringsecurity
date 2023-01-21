package ma.formations.service;

import ma.formations.dao.CommandeRepository;
import ma.formations.domaine.CommandeConverter;
import ma.formations.domaine.CommandeVo;
import ma.formations.service.model.Commande;
import ma.formations.service.model.Produit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.Date;
import java.util.List;

public class CommandeServiceImp implements ICommandeService{
    private CommandeRepository commandeRepository;
    private CommandeVo produitVo;

    @Override
    public List<CommandeVo> getCommandes() {
        List<Commande> list = commandeRepository.findAll();
        return CommandeConverter.toListVo(list);
    }

    @Override
    public void save(CommandeVo commande) {
    commandeRepository.save(CommandeConverter.toBo(commande));
    }

    @Override
    public CommandeVo getCommandeById(Long id) {
        boolean trouve = commandeRepository.existsById(id);
        if (!trouve)
            return null;
        return CommandeConverter.toVo(commandeRepository.getById(id));
    }
/*
    @Override
    public CommandeVo getCommanceByProduit(String Produit) {
        return produitVo;
    }
*/
    @Override
    public void delete(Long id) {
        commandeRepository.deleteById(id);
    }
/*
    @Override
    public List<CommandeVo> findByDate(Date date) {
        List<Commande> list = commandeRepository.findByDate(date);
        return CommandeConverter.toListVo(list);
    }
*/
    @Override
    public List<CommandeVo> findAll(int pageId, int size) {
        Page<Commande> result = commandeRepository.findAll(PageRequest.of(pageId, size, Sort.Direction.ASC, "name"));
        return CommandeConverter.toListVo(result.getContent());
    }


}
