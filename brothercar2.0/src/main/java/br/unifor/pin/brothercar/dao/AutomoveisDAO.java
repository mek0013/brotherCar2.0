package br.unifor.pin.brothercar.dao;

import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import br.unifor.pin.brothercar.entity.Automoveis;
import br.unifor.pin.brothercar.entity.Motoristas;


/**
 * @author maycon
 * @since 16/03/2016*/

@Repository
public class AutomoveisDAO extends GenericDAO<Integer, Automoveis>{

	/**
	 * Construtor para inicializa o contrutror da classe pai,
	 * passando o tipo (Automoveis).
	 * */
	public AutomoveisDAO() {
		super(Automoveis.class);
	}
	
	/**
	 * @param Automoveis
	 * @return void
	 * Salvar, Atualiza, Deletar e Listar todos os Automoveis.
	 */
	
	public void salvarAutomoveis(Automoveis automovel) {
		super.save(automovel);
	}
	
	public void atualizarAutomoveis(Automoveis automovel) {
		super.update(automovel);
	}
	
	public void deletarAutomoveis(Automoveis automovel) {
		super.delete(automovel);
	}
	
	public List<Automoveis> listarTodosAutomoveis() {
		return super.findAll();
	}
	
	public Automoveis buscarPorId(Integer id) {
		return super.getById(id);
	}
	
	/**
	 * @param placa
	 * @return Automoveis
	 * Retorna o automovel pela placa.
	 */
	
	public Automoveis buscarPorPlaca(String placa) {
		Query query = (Query) super.createQuery("from Automoveis a where a.placa=?");
		query.setString(0, placa);
		
		try {
			return (Automoveis)query.uniqueResult();
		} catch(NoResultException e){
			return null;
		}
	}
	
	/**
	 * @param modelo
	 * @return Automoveis
	 * Retorna o automovel pelo modelo.
	 */
	
	public Automoveis buscarPorModelo(String modelo) {
		Query query = (Query) super.createQuery("from Automoveis a where a.modelo=?");
		query.setString(0, modelo);
		
		try {
			return (Automoveis)query.uniqueResult();
		} catch(NoResultException e){
			return null;
		}
	}
	
	/**
	 * @param Motorista
	 * @return List<Automoveis>
	 * Retorna uma lista de todos os automoveis do motorista.
	 */
	
	@SuppressWarnings("unchecked")
	public List<Automoveis> listarPorMotorista(Motoristas motorista) {
		Query query = (Query) super.createQuery("from Automoveis a where a.motorista= :motorista");
		query.setEntity(0, motorista);
		
		try {
			List<Automoveis> listaAutomoveis = query.list();
			return listaAutomoveis;
		} catch(NoResultException e){
			return null;
		}
	}
}
