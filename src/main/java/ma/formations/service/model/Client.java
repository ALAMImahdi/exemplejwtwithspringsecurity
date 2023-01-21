package ma.formations.service.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Client {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String adresse;
	private String email;
	private String tel;

	public Client(String name, String adresse, String email, String tel) {
		super();
		this.name = name;
		this.adresse = adresse;
		this.email = email;
		this.tel=tel;
	}

}