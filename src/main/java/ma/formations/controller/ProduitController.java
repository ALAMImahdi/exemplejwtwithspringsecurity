package ma.formations.controller;

import ma.formations.domaine.ClientVo;
import ma.formations.domaine.ProduitVo;
import ma.formations.service.IClientService;
import ma.formations.service.IProduitService;
import ma.formations.service.model.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class ProduitController {
    /**
     * @Autowired permet d'injecter le bean de type IProdcutService (objet
     *            représentant la couche métier). Ici, le Design Pattern qui est
     *            appliqué est l'IOC (Inversion Of Control).
     */
    @Autowired
    private IProduitService service;

    /**
     * Pour chercher tous les produits
     */
    @GetMapping(value = "/produits", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })

    public List<ProduitVo> getAll() {
        return service.getProduits();
    }

    /**
     * Pour chercher un produit par son id
     */
    @GetMapping(value = "/produits/{id}")
    public ResponseEntity<Object> getProduitById(@PathVariable(value = "id") Long produitVoId) {
        ProduitVo produitVoFound = service.getProduitById(produitVoId);
        if (produitVoFound == null)
            return new ResponseEntity<>("produit doen't exist", HttpStatus.OK);
        return new ResponseEntity<>(produitVoFound, HttpStatus.OK);
    }

    /**
     * Pour créer un nouveau produit
     */
    @PostMapping(value = "/admin/create")
    public ResponseEntity<Object> createProduit(@Valid @RequestBody ProduitVo produitVo) {
        service.save(produitVo);
        return new ResponseEntity<>("produit is created successfully", HttpStatus.CREATED);
    }

    /**
     * Pour modifier un produit par son id
     */
    @PutMapping(value = "/admin/update/{id}")
    public ResponseEntity<Object> updateProduit(@PathVariable(name = "id") Long produitVoId,@Valid @RequestBody ProduitVo produitVo) {
        ProduitVo produitVoFound = service.getProduitById(produitVoId);
        if (produitVoFound == null)
            return new ResponseEntity<>("Produit doen't exist", HttpStatus.OK);
        produitVo.setId(produitVoId);
        service.save(produitVo);
        return new ResponseEntity<>("Produit is updated successsfully", HttpStatus.OK);
    }

    /**
     * Pour supprimer un produit par son id
     */
    @DeleteMapping(value = "/admin/delete/{id}")
    //@PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Object> deleteProduit(@PathVariable(name = "id") Long produitVoId) {
        ProduitVo produitVoFound = service.getProduitById(produitVoId);
        if (produitVoFound == null)
            return new ResponseEntity<>("produit doen't exist", HttpStatus.OK);
        service.delete(produitVoId);
        return new ResponseEntity<>("Produit is deleted successsfully", HttpStatus.OK);
    }

    /**
     * Pour chercher tous les emplyés
     */
    @GetMapping(value = "/produits/sort/{fieldName}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
    public List<ProduitVo> sortBy(@PathVariable String fieldName) {
        return service.sortBy(fieldName);
    }

    /**
     * Afficher la liste des produit en utilisant la pagination
     */
    @GetMapping("/produits/pagination/{pageid}/{size}")
    public List<ProduitVo> pagination(@PathVariable int pageid, @PathVariable int size, Model m) {
        return service.findAll(pageid, size);
    }
}
