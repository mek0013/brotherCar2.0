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

/**
 * @author maycon
 * @since 16/03/2016
 */

@Repository
public class PontoParadaDAO extends GenericDAO<Integer, PontoParada>{

	/**
	 * Construtor para inicializa o contrutror da classe pai,
	 * passando o tipo (PontoParada).
	 * */
	public PontoParadaDAO() {
		super(PontoParada.class);
	}
	
	/**
	 * @param PontoParada
	 * @return void
	 * Salvar, Atualiza, Deletar e Listar todos os PontosParada.
	 */
	
	public void salvarPontoParada(PontoParada ponto) {
		super.save(ponto);
	}
	
	public void atualizarPontoParada(PontoParada ponto) {
		super.update(ponto);
	}
	
	public void deletarPontoParada(PontoParada ponto) {
		super.delete(ponto);
	}
	
	public List<PontoParada> listarTodosAutomoveis() {
		return super.findAll();
	}
	
	public PontoParada buscarPorId(Integer id) {
		return super.getById(id);
	}
	
	/**
	 * @param latitude, longitude
	 * @return PontoParada
	 * Busca um PontoParada pela latitude e longitude
	 */
	
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
