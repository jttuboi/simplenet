package br.com.simplenet.repository;

public interface BaseRepository<T> {
	T save(T object) throws Exception; 
	boolean delete(T object) throws Exception; 
	T update(T object) throws Exception; 
}
