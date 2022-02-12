package code.webdkmh.dao.managers;

import code.webdkmh.dao.entities.UserHasRole;
import code.webdkmh.dao.repositories.UserHasRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
* Generated by Spring Data Generator on 12/02/2022
*/
@Component
public class UserHasRoleManager {

	private UserHasRoleRepository userHasRoleRepository;

	@Autowired
	public UserHasRoleManager(UserHasRoleRepository userHasRoleRepository) {
		this.userHasRoleRepository = userHasRoleRepository;
	}

}
