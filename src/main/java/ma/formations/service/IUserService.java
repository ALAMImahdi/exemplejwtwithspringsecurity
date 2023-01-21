package ma.formations.service;


import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import ma.formations.domaine.RoleVo;
import ma.formations.domaine.UserVo;

public interface IUserService extends UserDetailsService{
	void save(UserVo user);
	void save(RoleVo role);
	List<UserVo> getAllUsers();
	List<RoleVo> getAllRoles();
	RoleVo getRoleByName(String role);
	void cleanDataBase();
	boolean existsByUsername(String username);
	UserVo findByUsername(String username);
}
