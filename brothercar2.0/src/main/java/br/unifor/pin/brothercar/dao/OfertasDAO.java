package br.unifor.pin.brothercar.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import br.unifor.pin.brothercar.entity.Motoristas;
import br.unifor.pin.brothercar.entity.Ofertas;
import br.unifor.pin.brothercar.entity.Trajetos;

/**
 * @author maycon
 * @since 16/03/2016*/

@Repository
public class OfertasDAO extends GenericDAO<Integer, Ofertas>{

	/**
	 * Construtor para inicializa o contrutror da classe pai,
	 * passando o tipo (Ofertas).
	 * */
	public OfertasDAO() {
		super(Ofertas.class);
	}
	
	/**
	 * @param Ofertas
	 * @return void
	 * Salvar, Atualiza, Deletar e Listar todas as Ofertas.
	 */
	
	public void salvarOfertas(Ofertas oferta) {
		super.save(oferta);
	}
	
	public void atualizarOfertas(Ofertas oferta) {
		super.update(oferta);
	}
	
	public void deletarOfertas(Ofertas oferta) {
		super.delete(oferta);
	}
	
	public List<Ofertas> listarTodosAutomoveis() {
		return super.findAll();
	}
	
	public Ofertas buscarPorId(Integer id) {
		return super.getById(id);
	}
	
	/**
	 * @param statusOferta
	 * @return Ofertas
	 * Retorna a Oferta pelo status.
	 */
	
	public Ofertas buscarPorStatusOferta(Boolean statusOferta) {
		Query query = (Query) super.createQuery("from Ofertas o where o.statusOferta=?");
		query.setBoolean(0, statusOferta);
		
		try {
			return (Ofertas)query.uniqueResult();
		} catch(NoResultException e){
			return null;
		}
	}
	
	/**
	 * @param situacaoOferta
	 * @return Ofertas
	 * Retorna a Oferta pelo situação.
	 */
	
	public Ofertas buscarPorSituacaoOferta(String situacaoOferta) {
		Query query = (Query) super.createQuery("from Ofertas o where o.situacaoOferta=?");
		query.setString(0, situacaoOferta);
		
		try {
			return (Ofertas)query.uniqueResult();
		} catch(NoResultException e){
			return null;
		}
	}
	
	/**
	 * @param dataOferta
	 * @return Ofertas
	 * Retorna a Oferta pela data.
	 */
	
	public Ofertas buscarPelaData(Date dataOferta) {
		Query query = (Query) super.createQuery("from Ofertas o where o.data_oferta=?");
		query.setDate(0, dataOferta);
		
		try {
			return (Ofertas)query.uniqueResult();
		} catch(NoResultException e){
			return null;
		}
	}
	
	/**
	 * @param motorista
	 * @return Ofertas
	 * Retorna a Oferta pela motorista.
	 */
	
	public Ofertas buscarPeloMotorista(Motoristas motorista) {
		Query query = (Query) super.createQuery("from Ofertas o where o.motorista=?");
		query.setEntity(0, motorista);
		
		try {
			return (Ofertas)query.uniqueResult();
		} catch(NoResultException e){
			return null;
		}
	}
}
