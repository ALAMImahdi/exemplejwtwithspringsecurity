package ma.formations.domaine;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class ClientVo {
	private Long id;
	//Bean validation (est implémenté par Hibernate Validator
	@NotEmpty(message="Le nom du client ne peut pas être vide")
	private String name;
	@NotEmpty(message="L'adresse du client ne peut pas être vide")
	private String adresse;
	@NotEmpty(message="Email du client ne peut pas être vide")
	private String email;
	@NotEmpty(message="Le tel du client ne peut pas être vide")
	private String tel;
	public ClientVo() {
		super();
	}
	public ClientVo(Long id, String name, String adresse, String email,String tel) {
		this(name,adresse,email,tel);
		this.id = id;
	}
	
	public ClientVo(String name, String adresse, String email,String tel) {
		this.name = name;
		this.adresse = adresse;
		this.email = email;
		this.tel=tel;
	}
}
