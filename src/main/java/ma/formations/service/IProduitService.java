package ma.formations.service;

import ma.formations.domaine.ClientVo;
import ma.formations.domaine.ProduitVo;

import java.util.List;

public interface IProduitService {
    List<ProduitVo> getProduits();
    void save(ProduitVo produit);
    ProduitVo getProduitById(Long id);
    void delete(Long id);
    List<ProduitVo> findByPrix(Double prix);
    List<ProduitVo> findByName(String name);
    List<ProduitVo> findByPrixAndName(Double prix, String name);
    ProduitVo getProduitHavaingMaxPrix();
    //Pour la pagination
    List<ProduitVo> findAll(int pageId, int size);
    //pour le tri
    List<ProduitVo> sortBy(String fieldName);
}
