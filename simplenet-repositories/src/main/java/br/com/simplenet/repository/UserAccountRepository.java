package br.com.simplenet.repository;

import java.util.List;

import br.com.simplenet.entities.UserAccount;

public interface UserAccountRepository extends BaseRepository<UserAccount> {

//	UserAccount save(UserAccount userAccount) throws Exception;
//
//	boolean delete(UserAccount userAccount) throws Exception;
//
//	UserAccount update(UserAccount userAccount) throws Exception;

	UserAccount findBy(Long id) throws Exception;

	List<UserAccount> findAll() throws Exception;
}
