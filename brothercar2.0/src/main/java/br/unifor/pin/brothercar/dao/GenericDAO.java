package br.unifor.pin.brothercar.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional(propagation = Propagation.REQUIRED)
public class GenericDAO<ID, T> {

	@PersistenceContext
	private EntityManager entityManager;
	
	private Class<T> clazz;
	
	public GenericDAO() {
		
	}
	
	public GenericDAO(Class<T> clazz) {
		this.clazz = clazz;
	}
	
	public T getById(ID id) {
        return entityManager.find(this.clazz, id);
    }
 
    public void save(T entity) {
        entityManager.persist(entity);
    }
 
    public void update(T entity) {
        entityManager.merge(entity);
    }
 
    public void delete(T entity) {
        entityManager.remove(entity);
    }
 
    @SuppressWarnings("unchecked")
	public List<T> findAll() {
        return entityManager.createQuery(("FROM " + this.clazz.getName()))
                .getResultList();
    }
    
    public Query createQuery(String query) {
    	return (Query) entityManager.createQuery(query);
		
	}
    
    public Query createQuery(CriteriaQuery<T> criteriaQuery) {
    	return (Query) entityManager.createQuery(criteriaQuery);
		
	}
    
    public CriteriaBuilder createCriteriaBuilder() {
		return entityManager.getCriteriaBuilder();
	}
}
