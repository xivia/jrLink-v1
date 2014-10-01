package ch.ffhs.jee.controller;

import java.util.Collection;

import javax.ejb.Local;

import ch.ffhs.jee.model.TestTable;

@Local
public interface TestBeanLocal {

	/**
	 * get all records
	 */
	Collection<TestTable> getList();	
	
	/**
	 * get one record by key
	 */
	TestTable getByKey(Long key);

	/**
	 * add record
	 */
	void create(String value);
	
	/**
	 * update record
	 */
	void update(Long key, String value);
	
	/**
	 * delete record
	 */
	void delete(Long key);
	
	
}
