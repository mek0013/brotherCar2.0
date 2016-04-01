package br.unifor.pin.brothercar.dao;

import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import br.unifor.pin.brothercar.entity.Motoristas;
import br.unifor.pin.brothercar.entity.Usuarios;

/**
 * @author maycon
 * @since 16/03/2016
 * */

@Repository
public class MotoristasDAO extends GenericDAO<Integer, Motoristas>{

	/**
	 * Construtor para inicializa o contrutror da classe pai,
	 * passando o tipo (Motoristas).
	 * */
	
	public MotoristasDAO() {
		super(Motoristas.class);
	}
	
	
	public Motoristas buscarPorId(Integer id) {
		return super.getById(id);
	}
	
	/**
	 * @param nome
	 * @return List<Motoristas>
	 * Lista os motoristas pelo do nome.
	 */
	
	@SuppressWarnings("unchecked")
	public List<Motoristas> listarPorNome(String nome) {
		Query query = (Query) super.createQuery("from Motoristas m where m.nome=?");
		query.setString(0, nome);
		
		try {
			List<Motoristas> listaMotoristas = query.list();
			return listaMotoristas;
		} catch(NoResultException e){
			return null;
		}
	}
	
	/**
	 * @param email
	 * @return Motoristas
	 * Busca o Motoristas pelo email.
	 */
	
	public Motoristas buscarPorEmail(String email) {
		Query query = (Query) super.createQuery("from Motoristas m where m.email=?");
		query.setString(0, email);
		
		try {
			return (Motoristas)query.uniqueResult();
		} catch(NoResultException e){
			return null;
		}
	}
	
	/**
	 * @param cnh
	 * @return Motoristas
	 * Busca o Motoristas pela cnh.
	 */
	
	public Motoristas buscarPorCnh(String cnh) {
		Query query = (Query) super.createQuery("from Motoristas m where m.cnh=?");
		query.setString(0, cnh);
		
		try {
			return (Motoristas)query.uniqueResult();
		} catch(NoResultException e){
			return null;
		}
	}
	
	/**
	 * @param id
	 * @return Quantidade de pontos
	 * Busca a quantidade de pontos pelo id do motorista.
	 */
	
	public Integer buscarQuantidadePontos(Integer id) {
		Query query = (Query) super.createQuery("select m.quantidade_pontos from Motoristas m where m.id= :id");
		query.setParameter(0, id);
		
		try {
			return query.getFetchSize();
		} catch(NoResultException e){
			return null;
		}
	}
	
	/**
	 * @param id
	 * @return Quantidade de moedas
	 * Busca a quantidade de moedas pelo id do motorista.
	 */
	
	public Integer buscarMoedasMotorista(Integer id) {
		Query query = (Query) super.createQuery("select m.moedas_motorista from Motoristas m where m.id= :id");
		query.setParameter(0, id);
		
		try {
			return query.getFetchSize();
		} catch(NoResultException e){
			return null;
		}
	}

}
