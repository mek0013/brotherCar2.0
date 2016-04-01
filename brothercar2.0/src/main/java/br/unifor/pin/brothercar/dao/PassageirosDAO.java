package br.unifor.pin.brothercar.dao;

import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import br.unifor.pin.brothercar.entity.Motoristas;
import br.unifor.pin.brothercar.entity.Passageiros;
import br.unifor.pin.brothercar.entity.Usuarios;

/**
 * @author maycon
 * @since 16/03/2016*/

@Repository
public class PassageirosDAO extends GenericDAO<Integer, Passageiros>{

	
	/**
	 * Construtor para inicializa o contrutror da classe pai,
	 * passando o tipo (Passageiros).
	 * */
	
	public PassageirosDAO() {
		super(Passageiros.class);
	}
	
	public Passageiros buscarPorId(Integer id) {
		return super.getById(id);
	}
	
	/**
	 * @param nome
	 * @return List<Passageiros>
	 * Lista os passageiros pelo do nome.
	 */
	
	@SuppressWarnings("unchecked")
	public List<Passageiros> listarPorNome(String nome) {
		Query query = (Query) super.createQuery("from Passageiros p where p.nome=?");
		query.setString(0, nome);
		
		try {
			List<Passageiros> listaPassageiros = query.list();
			return listaPassageiros;
		} catch(NoResultException e){
			return null;
		}
	}
	
	/**
	 * @param email
	 * @return Passageiros
	 * Busca o Passageiros pelo email.
	 */
	
	public Passageiros buscarPorEmail(String email) {
		Query query = (Query) super.createQuery("from Passageiros p where p.email=?");
		query.setString(0, email);
		
		try {
			return (Passageiros)query.uniqueResult();
		} catch(NoResultException e){
			return null;
		}
	}
	
	/**
	 * @param cpf
	 * @return Motoristas
	 * Busca o Motoristas pela cpf.
	 */
	
	public Passageiros buscarPorCpf(String cpf) {
		Query query = (Query) super.createQuery("from Passageiros p where p.cpf=?");
		query.setString(0, cpf);
		
		try {
			return (Passageiros)query.uniqueResult();
		} catch(NoResultException e){
			return null;
		}
	}
	
	/**
	 * @param id
	 * @return Quantidade de moedas
	 * Busca a quantidade de moedas pelo id do passageiro.
	 */
	
	public Integer buscarMoedasPassageiro(Integer id) {
		Query query = (Query) super.createQuery("select p.moedas_passageiro from Passageiros p where p.id= :id");
		query.setParameter(0, id);
		
		try {
			return query.getFetchSize();
		} catch(NoResultException e){
			return null;
		}
	}
}
