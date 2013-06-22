package br.com.simplenet.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.simplenet.entities.UserAccount;
import br.com.simplenet.repository.UserAccountRepository;

@Repository
public class UserAccountRepositoryImpl extends BaseRepositoryImpl<UserAccount> implements UserAccountRepository {

	@PersistenceContext
	private EntityManager entityManager;

//	@Override
//	@Transactional(propagation = Propagation.REQUIRED)
//	public UserAccount save(UserAccount userAccount) {
//		this.entityManager.persist(userAccount);
//		return userAccount;
//	}
//
//	@Override
//	@Transactional(propagation = Propagation.REQUIRED)
//	public boolean delete(UserAccount userAccount) throws Exception {
//		try {
//			this.entityManager.remove(userAccount);
//			return true;
//		} catch (Exception e) {
//			throw e;
//		}
//	}
//
//	@Override
//	@Transactional(propagation = Propagation.REQUIRED)
//	public UserAccount update(UserAccount userAccount) {
//		this.entityManager.merge(userAccount);
//		return userAccount;
//	}

	@Override
	public UserAccount findBy(Long id) {
		return this.entityManager.find(UserAccount.class, id);
	}

	@Override
	public List<UserAccount> findAll() throws Exception {
		Query q = this.entityManager
				.createQuery("SELECT user FROM UserAccount user");
		return q.getResultList();
	}
}
