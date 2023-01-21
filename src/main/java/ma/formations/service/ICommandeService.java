package ma.formations.service;

import ma.formations.domaine.CommandeVo;
import ma.formations.service.model.Commande;

import java.util.Date;
import java.util.List;

public interface ICommandeService {
    List<CommandeVo> getCommandes();
    void save(CommandeVo commande);
    CommandeVo getCommandeById(Long id);
    //CommandeVo getCommanceByProduit(String Produit);
    void delete(Long id);
   // List<CommandeVo> findByDate(Date date);
    //Pour la pagination
    List<CommandeVo> findAll(int pageId, int size);

}
