package code.webdkmh.dao.managers;

import code.webdkmh.dao.entities.SubPass;
import code.webdkmh.dao.repositories.SubPassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
* Generated by Spring Data Generator on 12/02/2022
*/
@Component
public class SubPassManager {

	private SubPassRepository subPassRepository;

	@Autowired
	public SubPassManager(SubPassRepository subPassRepository) {
		this.subPassRepository = subPassRepository;
	}

}
