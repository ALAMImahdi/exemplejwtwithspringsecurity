package ma.formations.dao;

import java.util.List;

import ma.formations.service.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ClientRepository extends JpaRepository<Client, Long> {
	List<Client> findByName(String name);

	List<Client> findByAdresse(String adresse);

	List<Client> findByNameAndAdresse(String name, String adresse);

}
