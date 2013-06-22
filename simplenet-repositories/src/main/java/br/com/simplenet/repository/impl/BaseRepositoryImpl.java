package br.com.simplenet.repository.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.simplenet.repository.BaseRepository;


@Repository
public abstract class BaseRepositoryImpl<T> implements BaseRepository<T> {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public T save(T object) throws Exception {
		this.entityManager.persist(object);
		return object;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public boolean delete(T object) throws Exception {
		try {
			this.entityManager.remove(object);
			return true;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public T update(T object) throws Exception {
		this.entityManager.merge(object);
		return object;
	}
}
