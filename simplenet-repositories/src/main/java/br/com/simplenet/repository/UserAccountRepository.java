package br.com.simplenet.repository;

import br.com.simplenet.entities.UserAccount;

public interface UserAccountRepository {

	void save(UserAccount userAccount) throws Exception;
	
	boolean delete(Long id) throws Exception;
	
	void update(UserAccount userAccount) throws Exception;

	UserAccount findBy(Long id) throws Exception;
	
	// ?? findAll() throws Exception;
}
