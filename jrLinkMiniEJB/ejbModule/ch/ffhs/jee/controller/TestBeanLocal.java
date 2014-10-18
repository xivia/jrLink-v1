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
	TestTable getByKey(String key);

	/**
	 * add record
	 */
	boolean create(String key, String value);
	
	/**
	 * update record
	 */
	void update(String key, String value);
	
	/**
	 * delete record
	 */
	void delete(String key);
	
	
}
