package br.unifor.pin.brothercar.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import br.unifor.pin.brothercar.entity.PontoParada;


@Repository
public class PontoParadaDAO extends GenericDAO<Integer, PontoParada>{
	
	public PontoParadaDAO() {
		super(PontoParada.class);
	}
	
	public void salvarPontoParada(PontoParada pontoParada) {
		super.save(pontoParada);
	}
	
	public boolean atualizarPontoParada(PontoParada pontoParada) {
		super.update(pontoParada);
		return true;
	}
	
	public boolean deletarPontoParada(PontoParada pontoParada) {
		super.delete(pontoParada);
		return true;
	}
	
	public List<PontoParada> listarTodosPontoParada() {
		return super.findAll();
	}
	
	public PontoParada buscarPorId(Integer id) {
		return super.getById(id);
	}
	
	public PontoParada buscarPorLatitudeLongitude(String latitude, String longitude) {
		CriteriaBuilder criteriaBuilder = super.createCriteriaBuilder();
		CriteriaQuery<PontoParada> criteriaQuery = criteriaBuilder.createQuery(PontoParada.class);
		Root<PontoParada> pontoParada = criteriaQuery.from(PontoParada.class);
		Predicate restriction = criteriaBuilder.and(
				criteriaBuilder.equal(pontoParada.<String>get("latitude"), latitude),
				criteriaBuilder.equal(pontoParada.<String>get("longitude"), longitude)
			);
		criteriaQuery.where(criteriaBuilder.and(restriction));
		
		Query query = (Query) super.createQuery(criteriaQuery);
		try {
			return (PontoParada)query.uniqueResult();
		} catch(NoResultException e){
			return null;
		}
	}

}
