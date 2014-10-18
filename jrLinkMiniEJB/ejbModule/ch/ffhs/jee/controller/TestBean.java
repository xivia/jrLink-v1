package ch.ffhs.jee.controller;

import java.util.Collection;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ch.ffhs.jee.model.TestTable;

/**
 * Session Bean implementation class TestBean
 */
@Stateless
public class TestBean implements TestBeanLocal {

	@PersistenceContext
	private EntityManager em;
	
    /**
     * Default constructor. 
     */
    public TestBean() { }

	@Override
	public Collection<TestTable> getList() {
		return em.createNamedQuery("TestTable.findAll", TestTable.class).getResultList();
	}

	@Override
	public TestTable getByKey(String key) {
		return em.find(TestTable.class, new String(key));
	}

	@Override
	public boolean create(String key, String value) {
		if (getByKey(key) == null) {
			TestTable tt = new TestTable();
			tt.setKey(key);
			tt.setValue(value);
			em.persist(tt);
			em.flush();
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void update(String key, String value) {
		TestTable tt = getByKey(key);
		tt.setValue(value);
		em.merge(tt);
		em.flush();
	}

	@Override
	public void delete(String key) {
		TestTable tt = getByKey(key);
		if (tt != null) em.remove(tt);
		em.flush();
	}

}
