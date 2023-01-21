package ma.formations.domaine;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotEmpty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserVo {
	private Long id;
	@NotEmpty
	private String username;

	@NotEmpty
	private String password;
	private List<RoleVo> roles = new ArrayList<RoleVo>();

	public UserVo(String username, String password, List<RoleVo> roles) {
		this.username = username;
		this.password = password;
		this.roles = roles;
	}
}
