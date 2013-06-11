package br.com.simplenet.repository.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.simplenet.entities.UserAccount;
import br.com.simplenet.repository.UserAccountRepository;

@Repository
public class UserAccountRepositoryImpl implements UserAccountRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void save(UserAccount userAccount) {
		this.entityManager.persist(userAccount);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public boolean delete(Long id) {
		//precisa retornar algo??
		// usa cast??
		UserAccount user = this.entityManager.find(UserAccount.class, id);
		if (user != null) {
			this.entityManager.remove(user);
			return true;
		}
		return false;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void update(UserAccount userAccount) {
		this.entityManager.merge(userAccount);
	}

	@Override
	public UserAccount findBy(Long id) {
		return this.entityManager.find(UserAccount.class, id);
	}

//	@Override
//	public void findAll() throws Exception {
//		// TODO Auto-generated method stub
//		
//	}
	
	
}
