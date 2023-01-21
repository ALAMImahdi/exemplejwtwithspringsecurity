package ma.formations.service;


import ma.formations.dao.ProduitRepository;

import ma.formations.domaine.ProduitConverter;
import ma.formations.domaine.ProduitVo;

import ma.formations.service.model.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProduitServiceImp implements IProduitService{
    @Autowired
    private ProduitRepository produitRepository;
    @Override
    public List<ProduitVo> getProduits() {
        List<Produit> list = produitRepository.findAll();
        return ProduitConverter.toListVo(list);
    }
    @Override
    public void save(ProduitVo produit) {
        produitRepository.save(ProduitConverter.toBo(produit));
    }
    @Override
    public ProduitVo getProduitById(Long id) {
        boolean trouve = produitRepository.existsById(id);
        if (!trouve)
            return null;
        return ProduitConverter.toVo(produitRepository.getById(id));
    }
    @Override
    public void delete(Long id) {
        produitRepository.deleteById(id);
    }
    @Override
    public List<ProduitVo> findByPrix(Double prix) {
        List<Produit> list = produitRepository.findByPrix(prix);
        return ProduitConverter.toListVo(list);
    }
    @Override
    public List<ProduitVo> findByName(String name) {
        List<Produit> list = produitRepository.findByName(name);
        return ProduitConverter.toListVo(list);
    }
    @Override
    public List<ProduitVo> findByPrixAndName(Double prix, String name) {
        List<Produit> list = produitRepository.findByPrixAndName(prix, name);
        return ProduitConverter.toListVo(list);
    }
    @Override
    public ProduitVo getProduitHavaingMaxPrix() {
        return ProduitConverter.toVo(produitRepository.getProduitHavaingMaxPrix());
    }
    @Override
    public List<ProduitVo> findAll(int pageId, int size) {
        Page<Produit> result = produitRepository.findAll(PageRequest.of(pageId, size, Sort.Direction.ASC, "name"));
        return ProduitConverter.toListVo(result.getContent());
    }
    @Override
    public List<ProduitVo> sortBy(String fieldName) {
        return ProduitConverter.toListVo(produitRepository.findAll(Sort.by(fieldName)));
    }
}
