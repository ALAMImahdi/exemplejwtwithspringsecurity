package ma.formations.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ma.formations.domaine.ClientVo;
import ma.formations.service.IClientService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class ClientController {
	/**
	 * @Autowired permet d'injecter le bean de type IProdcutService (objet
	 *            représentant la couche métier). Ici, le Design Pattern qui est
	 *            appliqué est l'IOC (Inversion Of Control).
	 */
	@Autowired
	private IClientService service;

	/**
	 * Pour chercher tous les clients
	 */
	@GetMapping(value = "/clients", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	
	public List<ClientVo> getAll() {
		return service.getClients();
	}

	/**
	 * Pour chercher un client par son id
	 */
	@GetMapping(value = "/clients/{id}")
	public ResponseEntity<Object>  getClientById(@PathVariable(value = "id") Long clientVoId) {
		ClientVo clientVoFound = service.getClientById(clientVoId);
		if (clientVoFound == null)
			return new ResponseEntity<>("client doen't exist", HttpStatus.OK);
		return new ResponseEntity<>(clientVoFound, HttpStatus.OK);
	}

	/**
	 * Pour créer un nouveau client
	 */
	@PostMapping(value = "/admin/create")
	public ResponseEntity<Object> createClient(@Valid @RequestBody ClientVo clientVo) {
		service.save(clientVo);
		return new ResponseEntity<>("client is created successfully", HttpStatus.CREATED);
	}

	/**
	 * Pour modifier un client par son id
	 */
	@PutMapping(value = "/admin/update/{id}")
	public ResponseEntity<Object> updateClient(@PathVariable(name = "id") Long clientVoId,@Valid @RequestBody ClientVo clientVo) {
		ClientVo clientVoFound = service.getClientById(clientVoId);
		if (clientVoFound == null)
			return new ResponseEntity<>("client doen't exist", HttpStatus.OK);
		clientVo.setId(clientVoId);
		service.save(clientVo);
		return new ResponseEntity<>("Client is updated successsfully", HttpStatus.OK);
	}

	/**
	 * Pour supprimer un client par son id
	 */
	@DeleteMapping(value = "/admin/delete/{id}")
	//@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Object> deleteClient(@PathVariable(name = "id") Long clientVoId) {
		ClientVo clientVoFound = service.getClientById(clientVoId);
		if (clientVoFound == null)
			return new ResponseEntity<>("client doen't exist", HttpStatus.OK);
		service.delete(clientVoId);
		return new ResponseEntity<>("Client is deleted successsfully", HttpStatus.OK);
	}
	
	/**
	 * Pour chercher tous les clients
	 */
	@GetMapping(value = "/clients/sort/{fieldName}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public List<ClientVo> sortBy(@PathVariable String fieldName) {
		return service.sortBy(fieldName);
	}
	
	/**
	 * Afficher la liste des employés en utilisant la pagination
	 */
	@GetMapping("/clients/pagination/{pageid}/{size}")
	public List<ClientVo> pagination(@PathVariable int pageid, @PathVariable int size, Model m) {
		return service.findAll(pageid, size);
	}
}
