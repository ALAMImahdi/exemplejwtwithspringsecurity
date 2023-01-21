package ma.formations.dao;

import ma.formations.service.model.Client;
import ma.formations.service.model.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface CommandeRepository extends JpaRepository<Commande,Long> {
   // List<Commande> findByDate(Date date);
}
