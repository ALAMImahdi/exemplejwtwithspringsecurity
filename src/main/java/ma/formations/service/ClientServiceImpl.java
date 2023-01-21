package ma.formations.service;

import java.util.List;

import ma.formations.service.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ma.formations.dao.ClientRepository;
import ma.formations.domaine.ClientConverter;
import ma.formations.domaine.ClientVo;

@Service
@Transactional
public class ClientServiceImpl implements IClientService {
	@Autowired
	private ClientRepository clientRepository;
	@Override
	public List<ClientVo> getClients() {
		List<Client> list = clientRepository.findAll();
		return ClientConverter.toListVo(list);
	}
	@Override
	public void save(ClientVo client) {
		clientRepository.save(ClientConverter.toBo(client));
	}
	@Override
	public ClientVo getClientById(Long id) {
		boolean trouve = clientRepository.existsById(id);
		if (!trouve)
			return null;
		return ClientConverter.toVo(clientRepository.getById(id));
	}
	@Override
	public void delete(Long id) {
		clientRepository.deleteById(id);
	}
	@Override
	public List<ClientVo> findByName(String name) {
		List<Client> list = clientRepository.findByName(name);
		return ClientConverter.toListVo(list);
	}
	@Override
	public List<ClientVo> findByAdresse(String adresse) {
		List<Client> list = clientRepository.findByAdresse(adresse);
		return ClientConverter.toListVo(list);
	}
	@Override
	public List<ClientVo> findByNameAndAdresse(String name, String adresse) {
		List<Client> list = clientRepository.findByNameAndAdresse(name, adresse);
		return ClientConverter.toListVo(list);
	}

	@Override
	public List<ClientVo> findAll(int pageId, int size) {
		Page<Client> result = clientRepository.findAll(PageRequest.of(pageId, size, Direction.ASC, "name"));
		return ClientConverter.toListVo(result.getContent());
	}
	@Override
	public List<ClientVo> sortBy(String fieldName) {
		return ClientConverter.toListVo(clientRepository.findAll(Sort.by(fieldName)));
	}
}
