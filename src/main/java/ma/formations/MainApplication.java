package ma.formations;


import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ma.formations.domaine.ClientVo;
import ma.formations.domaine.RoleVo;
import ma.formations.domaine.UserVo;
import ma.formations.service.IClientService;
import ma.formations.service.IUserService;

@SpringBootApplication
public class MainApplication implements CommandLineRunner {

	@Autowired
	private IUserService userService;
	@Autowired
	private IClientService empService;

	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
	}

	@Override

	public void run(String... args) throws Exception {
		userService.cleanDataBase();
		userService.save(new RoleVo("ADMIN"));
		userService.save(new RoleVo("CLIENT"));

		RoleVo roleAdmin = userService.getRoleByName("ADMIN");
		RoleVo roleClient = userService.getRoleByName("CLIENT");
		UserVo admin1 = new UserVo("admin1", "admin1", Arrays.asList(roleAdmin));
		UserVo admin2 = new UserVo("admin2", "admin2", Arrays.asList(roleAdmin));
		UserVo client1 = new UserVo("client1", "client1", Arrays.asList(roleClient));
		UserVo client2 = new UserVo("client2", "client2", Arrays.asList(roleClient));
		userService.save(admin1);
		userService.save(client1);
		userService.save(client2);
		userService.save(admin2);

//		// *************
		empService.save(new ClientVo("clt1", "ville1", "clt1@gmail.com","0353624345"));
		empService.save(new ClientVo("clt2", "ville2", "clt2@gmail.com","0353624345"));
		empService.save(new ClientVo("clt3", "ville3", "clt3@gmail.com","0353624345"));
		empService.save(new ClientVo("clt4", "ville4", "clt4@gmail.com","0353624345"));
		empService.save(new ClientVo("clt5", "ville5", "clt5@gmail.com","0353624345"));

	}

}
