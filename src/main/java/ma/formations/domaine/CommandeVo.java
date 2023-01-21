package ma.formations.domaine;

import lombok.Data;
import ma.formations.service.model.Client;
import ma.formations.service.model.Produit;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.List;

@Data
public class CommandeVo {
    private Client client;
    private List<Produit> produits;
    private Long id;
    //Bean validation (est implémenté par Hibernate Validator
    @NotEmpty(message="La date de la commande ne peut pas être vide")
    private Date date;
    @Max(value = 30000,message = "Le salaire ne doit pas dépasser 30000 ")
    private Double prixTot;
    public CommandeVo() {
        super();
    }

    public CommandeVo(Long id, Date date, List<Produit> produits, Client client){
        this(date,produits,client);
        this.id=id;
    }
    public CommandeVo(Date date, List<Produit> produits, Client client) {
        this.date = date;
        this.produits = produits;
        this.client=client;
    }
}
