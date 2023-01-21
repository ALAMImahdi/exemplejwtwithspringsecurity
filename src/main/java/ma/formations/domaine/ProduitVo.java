package ma.formations.domaine;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;

@Data
public class ProduitVo {
    private Long id;
    //Bean validation (est implémenté par Hibernate Validator
    @NotEmpty(message="Le nom du produit ne peut pas être vide")
    private String name;
    @Max(value = 60000,message = "Le salaire ne doit pas dépasser 60000 ")
    private Double prix;
    @NotEmpty(message="La description du produit ne peut pas être vide")
    private String description;
    public ProduitVo() {
        super();
    }
    public ProduitVo(Long id, String name, Double prix, String description) {
        this(name,prix,description);
        this.id = id;
    }

    public ProduitVo(String name, Double prix, String description) {
        this.name = name;
        this.prix = prix;
        this.description = description;
    }
}
