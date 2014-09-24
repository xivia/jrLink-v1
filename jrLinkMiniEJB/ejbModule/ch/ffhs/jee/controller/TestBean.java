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
	public TestTable getByKey(Long key) {
		return em.find(TestTable.class, new Long(key));
	}

}
