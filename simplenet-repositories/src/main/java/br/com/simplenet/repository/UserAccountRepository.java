package br.com.simplenet.repository;

import br.com.simplenet.entities.UserAccount;

public interface UserAccountRepository {

	void save(UserAccount userAccount) throws Exception;
}
