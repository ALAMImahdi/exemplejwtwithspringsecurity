package ma.formations.dao;

import ma.formations.service.model.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProduitRepository extends JpaRepository<Produit,Long> {
    List<Produit> findByPrix(Double prix);

    List<Produit> findByName(String name);

    List<Produit> findByPrixAndName(Double prix, String name);

    @Query(" SELECT p from Produit p where p.prix=(select MAX(prix) as prix FROM Produit)")
    Produit getProduitHavaingMaxPrix();
}
