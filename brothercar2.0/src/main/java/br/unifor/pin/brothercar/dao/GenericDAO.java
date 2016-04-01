package br.unifor.pin.brothercar.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Query;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @autor maycon
 * @since 16/03/2016
 */


@Component
@Transactional(propagation = Propagation.REQUIRED)
public class GenericDAO<ID, T> {

	/**
	 * Dao generico.
	 * Centraliza as princinpais operações GRUD.
	 */
	
	@PersistenceContext
	private EntityManager entityManager;
	
	private Class<T> clazz;
	
	public GenericDAO() {
		
	}
	
	public GenericDAO(Class<T> clazz) {
		this.clazz = clazz;
	}
	
	/**
	 * @param id
	 * @return Entity
	 */
	
	public T getById(ID id) {
        return entityManager.find(this.clazz, id);
    }
	
	/**
	 * @param Entity
	 * @return void
	 */
 
    public void save(T entity) {
        entityManager.persist(entity);
    }
 
    /**
	 * @param Entity
	 * @return void
	 */
    
    public void update(T entity) {
        entityManager.merge(entity);
    }
 
    /**
	 * @param Entity
	 * @return void
	 */
    
    public void delete(T entity) {
        entityManager.remove(entity);
    }
    
    /**
	 * @param 
	 * @return Lista de entity
	 */
 
    @SuppressWarnings("unchecked")
	public List<T> findAll() {
        return entityManager.createQuery(("FROM " + this.clazz.getName()))
                .getResultList();
    }
    
    /**
	 * @param String query
	 * @return Query
	 */
    
    public Query createQuery(String query) {
    	return (Query) entityManager.createQuery(query);
		
	}
    
    /**
	 * @param criteriQuery<T>
	 * @return Query
	 */
    
    public Query createQuery(CriteriaQuery<T> criteriaQuery) {
    	return (Query) entityManager.createQuery(criteriaQuery);
		
	}
    
    /**
	 * @param 
	 * @return CriteriaBuilder
	 */
    
    public CriteriaBuilder createCriteriaBuilder() {
		return entityManager.getCriteriaBuilder();
	}
}
