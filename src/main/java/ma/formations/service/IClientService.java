package ma.formations.service;
import java.util.List;

import ma.formations.domaine.ClientVo;
public interface IClientService {
	List<ClientVo> getClients();
	void save(ClientVo client);
	ClientVo getClientById(Long id);
	void delete(Long id);
	List<ClientVo> findByName(String name);
	List<ClientVo> findByAdresse(String adresse);
	List<ClientVo> findByNameAndAdresse(String name, String adresse);
	//Pour la pagination
	List<ClientVo> findAll(int pageId, int size);
	//pour le tri
	List<ClientVo> sortBy(String fieldName);
}
