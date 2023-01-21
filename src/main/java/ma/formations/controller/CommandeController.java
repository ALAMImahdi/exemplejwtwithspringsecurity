package ma.formations.controller;

import ma.formations.domaine.CommandeVo;
import ma.formations.domaine.ProduitVo;
import ma.formations.service.ICommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class CommandeController {
    /**
     * @Autowired permet d'injecter le bean de type IProdcutService (objet
     *            représentant la couche métier). Ici, le Design Pattern qui est
     *            appliqué est l'IOC (Inversion Of Control).
     */
    @Autowired(required = true)
    private ICommandeService service;
/*
    public CommandeController(ICommandeService service) {
        this.service = service;
    }
*/
    /**
     * Pour chercher tous les commandes
     */
    @GetMapping(value = "/commandes", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })

    public List<CommandeVo> getAll() {
        return service.getCommandes();
    }

    /**
     * Pour chercher un commande par son id
     */
    @GetMapping(value = "/commandes/{id}")
    public ResponseEntity<Object> getCommandeById(@PathVariable(value = "id") Long commandeVoId) {
        CommandeVo commandeVoFound = service.getCommandeById(commandeVoId);
        if (commandeVoFound == null)
            return new ResponseEntity<>("commande doen't exist", HttpStatus.OK);
        return new ResponseEntity<>(commandeVoFound, HttpStatus.OK);
    }

    /**
     * Pour créer une nouvelle commande
     */
    @PostMapping(value = "/admin/create")
    public ResponseEntity<Object> createCommande(@Valid @RequestBody CommandeVo commandeVo) {
        service.save(commandeVo);
        return new ResponseEntity<>("commande is created successfully", HttpStatus.CREATED);
    }

    /**
     * Pour modifier une commande par son id
     */
    @PutMapping(value = "/admin/update/{id}")
    public ResponseEntity<Object> updateCommande(@PathVariable(name = "id") Long commandeVoId,@Valid @RequestBody CommandeVo commandeVo) {
        CommandeVo commandeVoFound = service.getCommandeById(commandeVoId);
        if (commandeVoFound == null)
            return new ResponseEntity<>("Commande doen't exist", HttpStatus.OK);
        commandeVo.setId(commandeVoId);
        service.save(commandeVo);
        return new ResponseEntity<>("Commande is updated successsfully", HttpStatus.OK);
    }

    /**
     * Pour supprimer une commande par son id
     */
    @DeleteMapping(value = "/admin/delete/{id}")
    //@PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Object> deleteCommande(@PathVariable(name = "id") Long commandeVoId) {
        CommandeVo commandeVoFound = service.getCommandeById(commandeVoId);
        if (commandeVoFound == null)
            return new ResponseEntity<>("commande doen't exist", HttpStatus.OK);
        service.delete(commandeVoId);
        return new ResponseEntity<>("Commande is deleted successsfully", HttpStatus.OK);
    }

    /**
     * Pour chercher tous les commandes

     * Afficher la liste des commande en utilisant la pagination
     */
    @GetMapping("/commandes/pagination/{pageid}/{size}")
    public List<CommandeVo> pagination(@PathVariable int pageid, @PathVariable int size, Model m) {
        return service.findAll(pageid, size);
    }
}
