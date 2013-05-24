package br.com.simplenet.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.simplenet.entities.UserAccount;
import br.com.simplenet.repository.UserAccountRepository;

@Repository
public class UserAccountRepositoryImpl implements UserAccountRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	public UserAccount save(UserAccount userAccount) throws Exception {
		this.em.persist(userAccount);
		return userAccount;
	}

	@Override
	public UserAccount update(UserAccount userAccount) throws Exception {
		this.em.merge(userAccount);
		return userAccount;

	}

	@Override
	public void delete(UserAccount userAccount) throws Exception {
		this.em.remove(userAccount);
	}

	@Override
	public UserAccount findBy(long id) throws Exception {
		Query query = this.em
				.createQuery("FROM UserAccount u WHERE u.id = :id");
		query.setParameter("id", id);
		return (UserAccount) query.getSingleResult();

	}

	@Override
	@SuppressWarnings("unchecked")
	public List<UserAccount> findAll() throws Exception {
		Query query = this.em.createQuery("FROM UserAccount t");
		return query.getResultList();
	}

}
