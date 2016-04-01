package br.unifor.pin.brothercar.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import br.unifor.pin.brothercar.entity.Automoveis;
import br.unifor.pin.brothercar.entity.PontoParada;
import br.unifor.pin.brothercar.entity.Trajetos;

/**
 * @author maycon
 * @since 16/03/2016
 */

@Repository
public class TrajetosDAO extends GenericDAO<Integer, Trajetos>{

	/**
	 * Construtor para inicializa o contrutror da classe pai,
	 * passando o tipo (Trajetos).
	 * */
	public TrajetosDAO() {
		super(Trajetos.class);
	}
	
	/**
	 * @param Trajetos
	 * @return void
	 * Salvar, Atualiza, Deletar e Listar todos os Trajetos.
	 */
	
	public void salvarTrajetos(Trajetos trajeto) {
		super.save(trajeto);
	}
	
	public void atualizarTrajetos(Trajetos trajeto) {
		super.update(trajeto);
	}
	
	public void deletarTrajetos(Trajetos trajeto) {
		super.delete(trajeto);
	}
	
	public List<Trajetos> listarTodosAutomoveis() {
		return super.findAll();
	}
	
	public Trajetos buscarPorId(Integer id) {
		return super.getById(id);
	}
	
	/**
	 * @param nomeTrajeto
	 * @return Automoveis
	 * Retorna o Trajeto pelo nome do Trajeto.
	 */
	
	public Trajetos buscarPorNome(String nomeTrajeto) {
		Query query = (Query) super.createQuery("from Trajetos t where t.nome_trajeto=?");
		query.setString(0, nomeTrajeto);
		
		try {
			return (Trajetos)query.uniqueResult();
		} catch(NoResultException e){
			return null;
		}
	}
	
	/**
	 * @param latitude_saida, longitude_saida
	 * @return PontoParada
	 * Busca um Trajetos pela latitude_saida e longitude_saida
	 */
	
	public Trajetos buscarPorLatitudeLongitudeSaida(String latitudeSaida, String longitudeSaida) {
		CriteriaBuilder criteriaBuilder = super.createCriteriaBuilder();
		CriteriaQuery<Trajetos> criteriaQuery = criteriaBuilder.createQuery(Trajetos.class);
		Root<Trajetos> trajeto = criteriaQuery.from(Trajetos.class);
		Predicate restriction = criteriaBuilder.and(
				criteriaBuilder.equal(trajeto.<String>get("latitude_saida"), latitudeSaida),
				criteriaBuilder.equal(trajeto.<String>get("longitude_saida"), longitudeSaida)
			);
		criteriaQuery.where(criteriaBuilder.and(restriction));
		
		Query query = (Query) super.createQuery(criteriaQuery);
		try {
			return (Trajetos)query.uniqueResult();
		} catch(NoResultException e){
			return null;
		}
	}
	
	/**
	 * @param latitude_chegada, longitude_chegada
	 * @return PontoParada
	 * Busca um Trajetos pela latitude_chegada e longitude_chegada
	 */
	
	public Trajetos buscarPorLatitudeLongitudeChegada(String latitudeChegada, String longitudeChegada) {
		CriteriaBuilder criteriaBuilder = super.createCriteriaBuilder();
		CriteriaQuery<Trajetos> criteriaQuery = criteriaBuilder.createQuery(Trajetos.class);
		Root<Trajetos> trajeto = criteriaQuery.from(Trajetos.class);
		Predicate restriction = criteriaBuilder.and(
				criteriaBuilder.equal(trajeto.<String>get("latitude_chegada"), latitudeChegada),
				criteriaBuilder.equal(trajeto.<String>get("longitude_chegada"), longitudeChegada)
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
