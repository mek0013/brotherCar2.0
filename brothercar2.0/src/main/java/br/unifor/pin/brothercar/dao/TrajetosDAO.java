package br.unifor.pin.brothercar.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import br.unifor.pin.brothercar.entity.Trajetos;

@Repository
public class TrajetosDAO extends GenericDAO<Integer, Trajetos>{

	public TrajetosDAO() {
		super(Trajetos.class);
	}
	
	public void salvarTrajeto(Trajetos trajeto) {
		super.save(trajeto);
	}
	
	public boolean atualizarTrajeto(Trajetos trajeto) {
		super.update(trajeto);
		return true;
	}
	
	public boolean deletarTrajeto(Trajetos trajeto) {
		super.delete(trajeto);
		return true;
	}
	
	public List<Trajetos> listarTodosTrajetos() {
		return super.findAll();
	}
	
	public Trajetos buscarPorId(Integer id) {
		return super.getById(id);
	}
	
	public Trajetos buscarPorLatitudeLongitudeInicial(String latitudeInicial, String longitudeInicial) {
		CriteriaBuilder criteriaBuilder = super.createCriteriaBuilder();
		CriteriaQuery<Trajetos> criteriaQuery = criteriaBuilder.createQuery(Trajetos.class);
		Root<Trajetos> trajeto = criteriaQuery.from(Trajetos.class);
		Predicate restriction = criteriaBuilder.and(
				criteriaBuilder.equal(trajeto.<String>get("latitude_inicial"), latitudeInicial),
				criteriaBuilder.equal(trajeto.<String>get("longitude_inicial"), longitudeInicial)
			);
		criteriaQuery.where(criteriaBuilder.and(restriction));
		
		Query query = (Query) super.createQuery(criteriaQuery);
		try {
			return (Trajetos)query.uniqueResult();
		} catch(NoResultException e){
			return null;
		}
	}
	
	public Trajetos buscarPorLatitudeLongitudeFinal(String latitudeFinal, String longitudeFinal) {
		CriteriaBuilder criteriaBuilder = super.createCriteriaBuilder();
		CriteriaQuery<Trajetos> criteriaQuery = criteriaBuilder.createQuery(Trajetos.class);
		Root<Trajetos> trajeto = criteriaQuery.from(Trajetos.class);
		Predicate restriction = criteriaBuilder.and(
				criteriaBuilder.equal(trajeto.<String>get("latitude_final"), latitudeFinal),
				criteriaBuilder.equal(trajeto.<String>get("longitude_final"), longitudeFinal)
			);
		criteriaQuery.where(criteriaBuilder.and(restriction));
		
		Query query = (Query) super.createQuery(criteriaQuery);
		try {
			return (Trajetos)query.uniqueResult();
		} catch(NoResultException e){
			return null;
		}
	}
}
