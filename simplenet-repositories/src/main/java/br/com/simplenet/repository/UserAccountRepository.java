package br.com.simplenet.repository;

import java.util.List;

import br.com.simplenet.entities.UserAccount;

public interface UserAccountRepository {
	
	UserAccount save(UserAccount userAccount) throws Exception;

	UserAccount update(UserAccount userAccount) throws Exception;

	void delete(UserAccount userAccount) throws Exception;

	UserAccount findBy(long id) throws Exception;

	List<UserAccount> findAll() throws Exception;
}
